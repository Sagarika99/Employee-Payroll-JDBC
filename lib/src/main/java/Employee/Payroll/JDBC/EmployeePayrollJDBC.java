package Employee.Payroll.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayrollJDBC {
	Connection con;
	
	public void getTableData() throws SQLException {
		try{
			JDBCConnection jdbcCon = new JDBCConnection();
			con = jdbcCon.getDBConnection();
			String query = "select * from employee_payroll";
	    	Statement stmt =  con.createStatement();
	       // PreparedStatement preparedStatement= dbConnection.prepareStatement("select * from employee_payroll");
	        ResultSet resultSet= stmt.executeQuery(query);
	        while (resultSet.next())
	        {
	            System.out.println(
	                    resultSet.getString(1)+" "+
	                            resultSet.getString(2)+ " "+
	                            resultSet.getString(3)+" "+
	                            resultSet.getString(4)
	            );
	        }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateBasePay(String name, double salary) throws SQLException {
		try{
			JDBCConnection jdbcCon = new JDBCConnection();
			con = jdbcCon.getDBConnection();
			
			String query = "update employee_payroll set salary=? where name=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, salary);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			System.out.println("Done");			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void getDatabyDateRange(String date) throws SQLException {
		try{
			JDBCConnection jdbcCon = new JDBCConnection();
			con = jdbcCon.getDBConnection();
			
			String query = String.format("SELECT * FROM employee_payroll WHERE start BETWEEN CAST('2018-01-01' AS DATE) AND DATE(NOW())",date);
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {			
				System.out.println(
						rs.getString(1)+" "+
						rs.getString(2)+" "+
						rs.getString(3)+" "+
						rs.getString(4)+" "+
						rs.getString(5));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void sumOfSalary() throws SQLException{
		try {
			JDBCConnection jdbcCon = new JDBCConnection();
			con = jdbcCon.getDBConnection();
			
			Statement stm = con.createStatement();
//			String query = "ALTER TABLE employee_payroll ADD gender CHAR(1) AFTER name";
//			stm.executeUpdate(query);
//			System.out.println("Column added");
			
			PreparedStatement pstmt = con.prepareStatement("update employee_payroll set gender = 'F' where name = 'Terisa'");
			pstmt.executeUpdate();
			
			PreparedStatement pstmt1 = con.prepareStatement("update employee_payroll set gender = 'M' where name = 'Bill' or name = 'Charlie';");
			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2 = con.prepareStatement("SELECT gender,SUM(salary) FROM employee_payroll WHERE gender='M'");
			ResultSet rs = pstmt2.executeQuery();
			while(rs.next()) {			
				System.out.println(
						rs.getString(1)+" "+
				rs.getInt(2));
			}		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insertData(String name,char gender, Double salary, String date) throws SQLException {
		JDBCConnection jdbcCon = new JDBCConnection();
		con = jdbcCon.getDBConnection();
		
		try {
			String query = String.format("insert into employee_payroll(name,gender,salary,start) values ('%s','%s',%2f,CAST('%s' AS DATE));", name, gender, salary, date);
			Statement stm = con.createStatement();
			int result = stm.executeUpdate(query);
			ResultSet rs = stm.executeQuery(query);
			while (rs.next())
		        {
		            System.out.println(
		                    rs.getString(1)+" "+
		                            rs.getString(2)+ " "+
		                            rs.getString(3)+" "+
		                            rs.getString(4)+" "+
		                            rs.getString(5)
		            );
		        }
			return result;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

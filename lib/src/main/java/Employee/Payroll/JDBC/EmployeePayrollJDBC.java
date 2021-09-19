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
}

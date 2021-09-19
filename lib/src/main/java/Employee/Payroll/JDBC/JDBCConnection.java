package Employee.Payroll.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private String url = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	private String username = "root";
    private String password = "hello";
    Connection con;

    public Connection getDBConnection() throws SQLException {	       
    	try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          con = DriverManager.getConnection(url, username, password);
	          //System.out.println("connection successful");
    	}
    	catch (ClassNotFoundException e){
    		e.printStackTrace();
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return con;
    }

}

package Employee.Payroll.JDBC.Test;

import org.junit.Assert;
import org.junit.Test;
import Employee.Payroll.JDBC.EmployeePayrollJDBC;
import Employee.Payroll.JDBC.JDBCConnection;
import java.sql.*;


public class EmployeePayrollJDBCTest {
	public EmployeePayrollJDBC employeePayrollJDBC = new EmployeePayrollJDBC();

    @Test
    public void get_AllEmployee() throws SQLException {
    	Connection dbConnection= new JDBCConnection().getDBConnection();
    	employeePayrollJDBC.getTableData();
    	dbConnection.close();    	
    }
    
    @Test
    public void whenGivenName_UpdateBasePay() throws SQLException {
    	Connection dbConnection= new JDBCConnection().getDBConnection();
    	employeePayrollJDBC.updateBasePay("Terisa",3000000.00);
    	dbConnection.close();
    }
    
    @Test
    public void givenDateRange_RetrieveEmployeeName() throws SQLException {
    	Connection dbConnection= new JDBCConnection().getDBConnection();
    	employeePayrollJDBC.getDatabyDateRange();
    	dbConnection.close();
    }
}

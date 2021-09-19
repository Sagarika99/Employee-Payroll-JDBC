package Employee.Payroll.JDBC.Test;

import org.junit.Test;
import java.sql.*;
import Employee.Payroll.JDBC.EmployeePayrollJDBC;

public class EmployeePayrollJDBCTest {

    @Test
    public void get_AllEmployee() throws SQLException {
    	Connection dbConnection= new EmployeePayrollJDBC().getDBConnection();
    	Statement statement =  dbConnection.createStatement();
        PreparedStatement preparedStatement= dbConnection.prepareStatement("select * from employee_payroll");
        ResultSet resultSet= preparedStatement.executeQuery();
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
}

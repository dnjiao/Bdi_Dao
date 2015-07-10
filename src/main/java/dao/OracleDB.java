package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDB
{
	public static Connection getConnection() 
	{
		String connectionURL = "jdbc:oracle:thin:@ldap://mdaoid.mdanderson.org:389/risdev3, cn=OracleContext,dc=mdacc,dc=tmc,dc=edu";
		String user = "BDI_USER";
		String pass = "bdiuser123";
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(connectionURL, user, pass);
			System.out.println("Connected to database.");
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Connection failed.");
			System.exit(1);
		}  catch (ClassNotFoundException e) {
			System.out.println("Cannot find Oracle JDBC Driver.");
			e.printStackTrace();
			System.exit(1);
		} 
		return connection;
	}
}
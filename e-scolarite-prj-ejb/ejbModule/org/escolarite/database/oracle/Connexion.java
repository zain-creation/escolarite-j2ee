package org.escolarite.database.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
@Name(value = "connexion")
@AutoCreate
public class Connexion {

	 Connection connection = null;

	public Connexion() {

	}

	public  Connection getConnection() throws ClassNotFoundException,
			SQLException {
		if (connection == null) {
			String driverName = "oracle.jdbc.driver.OracleDriver";

			Class.forName(driverName);

			String url = "jdbc:oracle:thin:@ip:port:uid";

			String username = "";
			String password = "";

			connection = DriverManager.getConnection(url, username, password);
			return connection;

		}

		return connection;

	}

	public  ResultSet createQuery(String req) throws SQLException, ClassNotFoundException {
		Statement st = getConnection().createStatement();
		ResultSet rs = st.executeQuery(req);
		//connection.close();		
		return rs;
	}
	
}

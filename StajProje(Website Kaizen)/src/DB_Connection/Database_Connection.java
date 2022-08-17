package DB_Connection;

import java.sql.*;
import DB_Connection.Database_Connection;

public class Database_Connection {

	public static Connection getConnection_Kaizen_Db() {
		Connection con = null;
		String url, kullanýcýAdý, þifre;
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		kullanýcýAdý = "";
		þifre = "";
		try {

			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			con = DriverManager.getConnection(url, kullanýcýAdý, þifre);

			return con;
		} catch (SQLException ex) {

			return null;
		}
	}

}

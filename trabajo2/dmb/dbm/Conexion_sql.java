package dbm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion_sql {

	private static String HOST;
	private static String PORT;
	private static String BBDD;
	private static String URL;
	private static String USER;
	private static String PASS;
	private static Connection conn;

	public static void conectarBBDD() {

		try (FileReader reader = new FileReader("cfg/database.cfg")) {
			Properties properties = new Properties();
			properties.load(reader);
			HOST = properties.getProperty("HOST");
			PORT = properties.getProperty("PORT");
			BBDD = properties.getProperty("BBDD");
			USER = properties.getProperty("TRABAJO");
			PASS = properties.getProperty("TRABAJO");

			URL = "jdbc:oracle:thin:@" + HOST + ":" + PORT + ":" + BBDD;
			conn = DriverManager.getConnection(URL, USER, PASS);

		} catch (SQLException sqle) {
			System.out.println(Model.Mensajes.DBMCONEXIONINCORRECTO);
		} catch (FileNotFoundException e) {
			System.err.println("Motivo: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Motivo: " + e.getMessage());
		}
	}

	public static Connection getConexion() {
		return conn;
	}

	public static void desconectarBBDD() {

		try {

			conn.close();

		} catch (SQLException sqle) {
			System.out.println(Model.Mensajes.DBMCONEXIONINCORRECTO);

		}

	}

	public static void ProbarBBDD() {

		conectarBBDD();
		getConexion();
		if (conn != null) {
			System.out.println(Model.Mensajes.DBMCONEXIONCORRECTO);
		} else {
			desconectarBBDD();
		}

	}

}

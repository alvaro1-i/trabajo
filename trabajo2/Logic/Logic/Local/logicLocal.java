package Logic.Local;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Model.Artista;
import Model.Local;

public class logicLocal {

	
	public static void newLoc(Local L) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();

		String sql = "{ call Local.insertLoc(?,?,?,?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, L.getLugar());
		orden.setString(2, L.getNombre());
		orden.setString(4, L.getHorarios());
		orden.setString(6, L.getIdLocal());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void delLoc(Local L) throws SQLException {

		dbm.Conexion_sql.conectarBBDD();
		String sql = "{ call Local.deleteLoc(?,?,?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, L.getIdLocal());
        orden.setString(2,L.getHorarios());
        orden.setString(3,L.getLugar());
        orden.setString(3,L.getNombre());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}


	public static List<Local> ListLoc() throws SQLException {
		List<Local> list = new ArrayList<Local>();
		try {
			dbm.Conexion_sql.conectarBBDD();

			String sql = "SELECT * FROM LOCAL";
			ResultSet resultado = dbm.Conexion_sql.getConexion().createStatement().executeQuery(sql);

			while (resultado.next()) {

				list.add(new  Local(resultado.getString("nombre"),
						resultado.getString("horario"),
						resultado.getString("lugar"), sql));

			}

			dbm.Conexion_sql.desconectarBBDD();

		} catch (SQLException sqle) {
			System.err.println("Error: " + sqle.getMessage());
		}

		return list;
	}

	
	public static void updLoc(Local L) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Local.updateLocalallfield(?,?,?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, L.getNombre());
		orden.setString(2, L.getLugar());
		orden.setString(4, L.getIdLocal());
		orden.setString(6, L.getHorarios());
	

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void updNombre(Local L) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateArtname(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, L.getNombre());
		orden.setString(2, L.getIdLocal());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void updLugar(Local L) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateapellido(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, L.getLugar());
		orden.setString(2, L.getIdLocal());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}



	
	public static void updHorario(Local L) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updatetelefono(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, L.getHorarios());
		orden.setString(2, L.getIdLocal());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}
}
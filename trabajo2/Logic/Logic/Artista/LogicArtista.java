package Logic.Artista;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Model.Artista;

public class LogicArtista {

	
	public static void newArt(Artista A) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();

		String sql = "{ call Artista.insertemp(?,?,?,?,?,?,?,?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, A.getNombre());
		orden.setString(2, A.getApellido());
		orden.setInt(4, A.getTelefono());
		orden.setString(6, A.getDNI());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void delArt(Artista A) throws SQLException {

		dbm.Conexion_sql.conectarBBDD();
		String sql = "{ call Artista.deleteArt(?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setInt(1, A.getIdArtista());

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}


	public static List<Artista> ListArt() throws SQLException {
		List<Artista> list = new ArrayList<Artista>();
		try {
			dbm.Conexion_sql.conectarBBDD();

			String sql = "SELECT * FROM ARTISTA";
			ResultSet resultado = dbm.Conexion_sql.getConexion().createStatement().executeQuery(sql);

			while (resultado.next()) {

				list.add(new  Artista(resultado.getString("nombre"),
						resultado.getString("apellido"),
						resultado.getInt("telefono"),resultado.getString("dni"), sql));

			}

			dbm.Conexion_sql.desconectarBBDD();

		} catch (SQLException sqle) {
			System.err.println("Error: " + sqle.getMessage());
		}

		return list;
	}

	
	public static void updArt(Artista A) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateArtistaallfield(?,?,?,?,?,?,?,?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, A.getNombre());
		orden.setString(2, A.getApellido());
		orden.setInt(4, A.getTelefono());
		orden.setString(6, A.getDNI());
		orden.setInt(9, A.getIdArtista());

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void updNombre(Artista A) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateArtname(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, A.getNombre());
		orden.setInt(2, A.getIdArtista());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void updApellido(Artista A) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateapellido(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, A.getApellido());
		orden.setInt(2, A.getIdArtista());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}



	
	public static void updTelefono(Artista A) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updatetelefono(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setInt(1, A.getTelefono());
		orden.setInt(2, A.getIdArtista());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	


	public static void updDni(Artista A) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updatedni(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, A.getDNI());
		orden.setInt(2, A.getIdArtista());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
}

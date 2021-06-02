package Logic.Invitado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Model.Invitado;

public class Invitado_lgc {

	
	public static void newInv(Invitado I) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();

		String sql = "{ call Invitado.insertInvt(?,?,?,?,?,?,?,?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, I.getNombre());
		orden.setString(2, I.getApellido());
		orden.setInt(4, I.getTelefono());
		orden.setString(6, I.getMail());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void delInv(Invitado I) throws SQLException {

		dbm.Conexion_sql.conectarBBDD();
		String sql = "{ call Invitado.deleteInvt(?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, I.getIdInvitado());

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}


	public static List<Invitado> ListInv() throws SQLException {
		List<Invitado> list = new ArrayList<Invitado>();
		try {
			dbm.Conexion_sql.conectarBBDD();

			String sql = "SELECT * FROM INVITADO";
			ResultSet resultado = dbm.Conexion_sql.getConexion().createStatement().executeQuery(sql);

			while (resultado.next()) {

				list.add(new  Invitado(resultado.getString("nombre"),resultado.getString("apellido"),
						sql,resultado.getString("dni"), resultado.getInt("telefono")));

			}

			dbm.Conexion_sql.desconectarBBDD();

		} catch (SQLException sqle) {
			System.err.println("Error: " + sqle.getMessage());
		}

		return list;
	}

	
	public static void updInv(Invitado I) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateempleadoallfield(?,?,?,?,?,?,?,?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, I.getNombre());
		orden.setString(2, I.getApellido());
		orden.setInt(4, I.getTelefono());
		orden.setString(9, I.getIdInvitado());

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void updNombre(Invitado I) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateuempname(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, I.getNombre());
		orden.setString(2, I.getIdInvitado());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void updApellido(Invitado I) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateapellido(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, I.getApellido());
		orden.setString(2, I.getIdInvitado());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}



	
	public static void updTelefono(Invitado I) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updatetelefono(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setInt(1, I.getTelefono());
		orden.setString(2, I.getIdInvitado());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void updMail(Invitado I) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updatetelefono(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, I.getMail());
		orden.setString(2, I.getIdInvitado());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	

	
	
	
}

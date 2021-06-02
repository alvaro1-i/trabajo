package Logic.Usuario;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Usuario;

public class LogicUsuario {

	
	public static void newUsu2(Usuario U) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		String sql = "{ call USUARIO.insertuser(?,?,?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, U.getNombreUsuario());
		orden.setString(2, U.getEmail());
		orden.setString(3, U.getContraseña());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void delUsu(Usuario u) throws SQLException {

		dbm.Conexion_sql.conectarBBDD();
		String sql = "{ call USUARIO.DELETEUSER(?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setInt(1, u.getIdUsuario());

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}

	
	public static void updateuserallfield(Usuario u) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		String sql = "{ call USUARIO.updateuserallfield(?,?,?,?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, u.getNombreUsuario());
		orden.setString(2, u.getEmail());
		orden.setString(3, u.getContraseña());
		orden.setInt(4, u.getIdUsuario());

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}

	
	public static List<Usuario> ListUsu() throws SQLException {
		List<Usuario> listado = new ArrayList<Usuario>();
		try {
			dbm.Conexion_sql.conectarBBDD();

			String sql = "SELECT * FROM USUARIO";
			ResultSet resultado = dbm.Conexion_sql.getConexion().createStatement().executeQuery(sql);

			while (resultado.next()) {

				listado.add(new Usuario(resultado.getInt("ID_USUARIO"), resultado.getString("NOMBRE"),
						resultado.getString("EMAIL"), resultado.getString("CONTRASEÑA")));

			}

			dbm.Conexion_sql.desconectarBBDD();
		} catch (SQLException sqle) {
			System.err.println("Error: " + sqle.getMessage());
		}

		return listado;
	}

	
	public static void compCorreoUsuario(String email) throws SQLException {

		dbm.Conexion_sql.conectarBBDD();
		String sql = "{ call USUARIO.validateEmail(?)}";

		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, email);
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

		public static void compNombreUsuario(String nombre) throws SQLException {

		dbm.Conexion_sql.conectarBBDD();
		String sql = "{call USUARIO.validateName(?)}";

		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, nombre);
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	public static void compContraseña(String password) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		String sql = "{call USUARIO.validatePassword(?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);

		orden.setString(1, password);
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

}

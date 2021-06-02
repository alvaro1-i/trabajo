package Logic.Proveedor;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Model.Artista;
import Model.Proveedor;

public class LogicProveedorlgc {

	
	public static void newArt(Proveedor PRO) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();

		String sql = "{ call Proveedor.insertpro(?,?,?,?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, PRO.getNombre());
		orden.setString(2, PRO.getDireccion());
		orden.setInt(3, PRO.getIdProveedor());
		orden.setString(4, PRO.getNif());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void delPro
	(Proveedor PRO) throws SQLException {

		dbm.Conexion_sql.conectarBBDD();
		String sql = "{ call Proveedor.deletePRO(?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setInt(1, PRO.getIdProveedor());

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}


	public static List<Proveedor> ListPro() throws SQLException {
		List<Proveedor> list = new ArrayList<Proveedor>();
		try {
			dbm.Conexion_sql.conectarBBDD();

			String sql = "SELECT * FROM PROVEEDOR";
			ResultSet resultado = dbm.Conexion_sql.getConexion().createStatement().executeQuery(sql);

			while (resultado.next()) {

				list.add(new  Proveedor(resultado.getString("nombre"),resultado.getString("nif"),resultado.getString("Direccion"),resultado.getString("idProveedor")));

			}

			dbm.Conexion_sql.desconectarBBDD();

		} catch (SQLException sqle) {
			System.err.println("Error: " + sqle.getMessage());
		}

		return list;
	}

	
	public static void updPRO(Proveedor PRO) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Proveedor.updateProveedorallfield(?,?,?,?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, PRO.getNombre());
		orden.setString(2, PRO.getNif());
		orden.setInt(3, PRO.getIdProveedor());
		orden.setString(4, PRO.getDireccion());

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void updNombre(Proveedor PRO) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateArtname(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, PRO.getNombre());
		orden.setInt(2, PRO.getIdProveedor());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void updDireccion(Proveedor PRO) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updateapellido(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, PRO.getDireccion());
		orden.setInt(2, PRO.getIdProveedor());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}



	
	public static void updNif(Proveedor PRO) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updatetelefono(?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, PRO.getNif());
		orden.setInt(2, PRO.getIdProveedor());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	


	

	
}
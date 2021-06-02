package Logic.TipoEspacio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Model.Tipo_espacio;

public class LogicTipoEspacio {

	
	public static void newTPE(Tipo_espacio TEP) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();

		String sql = "{ call TipoEspacio.inserttep(?,?,?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, TEP.getBarra());
		orden.setString(2, TEP.getMesas_y_sofa());
		orden.setString(4, TEP.getTerraza());
		orden.setString(4, TEP.getID());
		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	public static void delTEP(Tipo_espacio TEP) throws SQLException {

		dbm.Conexion_sql.conectarBBDD();
		String sql = "{ call Artista.deleteTEP(?)}";
		CallableStatement orden = dbm.Conexion_sql.getConexion().prepareCall(sql);
		orden.setString(1, TEP.getID());

		orden.execute();

		dbm.Conexion_sql.desconectarBBDD();
	}


	public static List<Tipo_espacio> ListArt() throws SQLException {
		List<Tipo_espacio> list = new ArrayList<Tipo_espacio>();
		try {
			dbm.Conexion_sql.conectarBBDD();

			String sql = "SELECT * FROM TIPOESPACIO";
			ResultSet resultado = dbm.Conexion_sql.getConexion().createStatement().executeQuery(sql);

			while (resultado.next()) {

				list.add(new  Tipo_espacio(resultado.getString("Barra"),
						resultado.getString("Mesas y sofa"),
						resultado.getString("Terraza")));

			}

			dbm.Conexion_sql.desconectarBBDD();

		} catch (SQLException sqle) {
			System.err.println("Error: " + sqle.getMessage());
		}

		return list;
	}

	
	public static void updTipoEspacio(Tipo_espacio TEP) throws SQLException {
		dbm.Conexion_sql.conectarBBDD();
		Connection conn = dbm.Conexion_sql.getConexion();
		String sql = "{ call Artista.updatetIPOEspacioallfield(?,?,?)}";
		CallableStatement orden = conn.prepareCall(sql);
		orden.setString(1, TEP.getMesas_y_sofa());
		orden.setString(2, TEP.getTerraza());
		orden.setString(3, TEP.getBarra());
	orden.execute();

		dbm.Conexion_sql.desconectarBBDD();

	}

	
	

	
}
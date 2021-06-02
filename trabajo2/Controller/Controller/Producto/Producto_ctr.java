package Controller.Producto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Artista;
import until.Teclado;

public class Producto_ctr {
	String nombre;
	String lugar;
    String idLocal;	

	public static void crear() {

		Loc = pedirDatos();

		try {
			System.out.println();
		   Logic.Artista.LogicArtista.newLoc(Loc);
			System.out.println(Model.Mensajes.GENERALCREADO);
		} catch (SQLException sqle) {
			System.out.println(Model.Mensajes.GENERALERROR);
			Integer codE = sqle.getErrorCode();

			errores(sqle, codE);
		}

	}

	
	public static void borrar() {
		Integer id;
		list = listar();

		if (list.size() > 0 || list == null) {
			try {

				id = sacarIndex();
				Loc.setidLocal(id);

				Logic.Artista.LogicArtista.delArt(Loc);
				System.out.println();
				System.out.println(Model.Mensajes.CTRLARTISTAARTBORRADO);
			} catch (SQLException e) {
				System.out.println(Model.Mensajes.GENERALERROR);
			}
		}

	}

	
	public static void modificarNombre() {
		list = listar();
		if (list.size() > 0 || list == null) {

			id = sacarIndex();
			nombre = Teclado.readString(Model.Mensajes.GENERALNOMBRE);
			A.setIdArtista(id);
			A.setNombre(nombre);

			try {
				Logic.Artista.LogicArtista.updNombre(A);
				System.out.println();
				System.out.println(Model.Mensajes.CTRLArtistaARTCODICORRECTO);
			} catch (SQLException sqle) {
				System.out.println(Model.Mensajes.GENERALERROR);
				Integer codE = sqle.getErrorCode();

				errores(sqle, codE);
			}
		}

	}


	public static void modificarLugar() {
		list = listar();
		if (list.size() > 0 || list == null) {

			id = sacarIndex();
			apellido = Teclado.readString(Model.Mensajes.CTRLCTRLARTISTAAPELLIDO);
		}
		A.setApellido(apellido);
		A.setIdArtista(id);

		try {
			Logic.Artista.LogicArtista.updApellido(Loc);
			System.out.println(Model.Mensajes.CTRLArtistaARTCODICORRECTO);
		} catch (SQLException sqle) {
			System.out.println(Model.Mensajes.GENERALERROR);
			Integer codE = sqle.getErrorCode();

			errores(sqle, codE);
		}
	}

	

	
	public static void modificarTelefono() {
		list = listar();

		if (list.size() > 0 || list == null) {
			id = sacarIndex();
			telefono = Teclado.readInt(Model.Mensajes.CTRLARTISTATELEFONO);
		}
		A.setTelefono(telefono);
		A.setIdArtista(id);

		try {
			Logic.Artista.LogicArtista.updTelefono(A);
			System.out.println(Model.Mensajes.CTRLArtistaARTCODICORRECTO);
		} catch (SQLException sqle) {
			System.out.println(Model.Mensajes.GENERALERROR);
			Integer codE = sqle.getErrorCode();

			errores(sqle, codE);
		}

	}

	

	
	public static void modificaridLocal() {
		list = listar();

		if (list.size() > 0 || list == null) {

			id = sacarIndex();
			dni = Teclado.readString(Model.Mensajes.CTRLARTISTADNI);
		}
		A.setDNI(dni);
		A.setIdArtista(id);

		try {
		    Logic.Artista.LogicArtista.updDni(A);
			System.out.println(Model.Mensajes. CTRLArtistaARTCODICORRECTO );
		} catch (SQLException sqle) {
			System.out.println(Model.Mensajes.GENERALERROR);
			Integer codE = sqle.getErrorCode();

			errores(sqle, codE);
		}

	}

	



	
	public static void modificarCampos() {
		list = listar();
		if (list.size() > 0) {

			id = sacarIndex();
			A = pedirDatos();
			A.setIdArtista(id);
			A.setNombre(nombre);
			A.setApellido(apellido);
            A.setTelefono(telefono);
			A.setDNI(dni);
			
	

			try {
				Logic.Artista.LogicArtista.updArt(A);
				System.out.println(Model.Mensajes. CTRLArtistaARTCODICORRECTO);
			} catch (SQLException sqle) {
				System.out.println(Model.Mensajes.GENERALERROR);
				Integer codE = sqle.getErrorCode();

				errores(sqle, codE);
			}

		}

	}

	
	public static List<Artista> listar() {
		Integer i = 0;
		System.out.println(Model.Mensajes.LISTArtistas);

		try {
			list = Logic.Artista.LogicArtista.ListArt();
			if (list.size() == 0) {
				System.out.println();
				System.out.println(Model.Mensajes.CTRLARTISTARTNEGATIVO);
			}
			if (list.size() > 0) {

				System.out.println();
				for (Artista A : list) {
					System.out.println((i + 1) + ". EL/LA ARTISTA " + A.getNombre() + " CON APELLIDOS "
							+ A.getApellido() + " " + " ,CON DNI " + A.getDNI()
							+ " Y CON NUMERO DE TELEFONO " + A.getTelefono());
					i++;
				}
			}
		} catch (SQLException A) {
			System.err.println(Model.Mensajes.GENERALERROR);
		}
		return list;

	}


	private static void errores(SQLException sqle, Integer codE) {

		String msg;
		switch (codE) {

		case 20101:
			msg = Model.Mensajes.CTRLERROR01;
			break;

		case 20102:
			msg = Model.Mensajes.CTRLERROR02;
			break;

		case 20104:
			msg = Model.Mensajes.CTRLERROR04;
			break;


		case 20106:
			msg = Model.Mensajes.CTRLERROR06;
			break;
	case 20109:
			msg = Model.Mensajes.CTRLERROR09;
			break;
		case 20110:
			msg = Model.Mensajes.CTRLERROR10;
			break;
		case 20111:
			msg = Model.Mensajes.CTRLERROR11;
			break;
		case 20112:
			msg = Model.Mensajes.CTRLERROR12;
			break;
		case 20113:
			msg = Model.Mensajes.CTRLERROR13;
			break;
		case 20114:
			msg = Model.Mensajes.CTRLERROR14;
			break;
		default:
			msg = sqle.getMessage();
		}
		System.err.println("El error es: " + msg);
	}

	
	private static Artista pedirDatos() {

		System.out.println();

		do {
			nombre = until.Teclado.readString(Model.Mensajes.GENERALNOMBRE);
		} while (!nombre.matches("[A-Za-z ]*") || nombre.isEmpty());

		do {
			apellido = until.Teclado.readString(Model.Mensajes.CTRLCTRLARTISTAAPELLIDO);
		} while (!apellido.matches("[A-Za-z ]*") || apellido.isEmpty());

	
		do {
			telefono = until.Teclado.readInt(Model.Mensajes.CTRLARTISTATELEFONO);
		} while (telefono.toString().length() != 9 || telefono.toString().isEmpty());

	
		do {
			dni = Teclado.readString(Model.Mensajes.CTRLARTISTADNI);

		} while (!dni.matches("[0-20]{8}[A-X a-x]{1}"));
		A.setNombre(nombre.toUpperCase());
		A.setApellido(apellido.toUpperCase());
		A.setTelefono(telefono);
		A.setDNI(dni.toUpperCase());
		return A;
		
	}

	
	private static Integer sacarIndex() {
		Integer id;
		Integer index;
		do {
			System.out.println();
			index = Teclado.readInt(Model.Mensajes.GENERALPOSICION);
		} while (index > list.size() || index <= 0);

		id = list.get(index - 1).getIdArtista();
		return id;
	}

}

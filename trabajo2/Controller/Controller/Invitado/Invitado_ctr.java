package Controller.Invitado;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Model.Invitado;
import until.Teclado;

public class Invitado_ctr {

	private static List<Invitado> list = new ArrayList<Invitado>();
	private static Invitado I = new Invitado();
	private static String id;
	private static String nombre;
	private static String apellido;
	private static Integer telefono;
	private static String dni;

	public static void crear() {

		I = pedirDatos();

		try {
			System.out.println();
		   Logic.Invitado.Invitado_lgc.newInv(I);
			System.out.println(Model.Mensajes.GENERALCREADO);
		} catch (SQLException sqle) {
			System.out.println(Model.Mensajes.GENERALERROR);
			Integer codE = sqle.getErrorCode();

			errores(sqle, codE);
		}

	}

	
	public static void borrar() {
		String id;
		list = listar();

		if (list.size() > 0 || list == null) {
			try {

				id = sacarIndex();
				

				Logic.Invitado.Invitado_lgc.delInv(I);
				System.out.println();
				System.out.println(Model.Mensajes.CTRLINVITADOINVBORRADO);
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
		
			I.setNombre(nombre);

			try {
				Logic.Invitado.Invitado_lgc.updNombre(I);
				System.out.println();
				System.out.println(Model.Mensajes.CTRLINVITADOARTNOMBRECORRECTO);
			} catch (SQLException sqle) {
				System.out.println(Model.Mensajes.GENERALERROR);
				Integer codE = sqle.getErrorCode();

				errores(sqle, codE);
			}
		}

	}


	public static void modificarApellido() {
		list = listar();
		if (list.size() > 0 || list == null) {

			id = sacarIndex();
			apellido = Teclado.readString(Model.Mensajes.CTRLCTRINVITADOAPELLIDO);
		}
		I.setApellido(apellido);
	

		try {
			Logic.Invitado.Invitado_lgc.updApellido(I);
			System.out.println(Model.Mensajes.CTRLINVITADOINVCODICORRECTO);
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
			telefono = Teclado.readInt(Model.Mensajes.CTRLINVITADOTELEFONO);
		}
		I.setTelefono(telefono);
		I.setIdInvitado(id);

		try {
			Logic.Invitado.Invitado_lgc.updInv(I);
			System.out.println(Model.Mensajes.CTRLINVITADOCODICORRECTO);
		} catch (SQLException sqle) {
			System.out.println(Model.Mensajes.GENERALERROR);
			Integer codE = sqle.getErrorCode();

			errores(sqle, codE);
		}

	}

	

	
	public static void modificarDni() {
		list = listar();

		if (list.size() > 0 || list == null) {

			id = sacarIndex();
			dni = Teclado.readString(Model.Mensajes.CTRLARTISTADNI);
		}
        I.setTelefono(0);
		I.setIdInvitado(id);

		try {
		    Logic.Invitado.Invitado_lgc.updTelefono(I);
			System.out.println(Model.Mensajes. CTRLINVITADOINVCODICORRECTO );
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
			I = pedirDatos();
			I.setIdInvitado(id);
			I.setNombre(nombre);
			I.setApellido(apellido);
            I.setTelefono(telefono);
			
			
	

			try {
				Logic.Invitado.Invitado_lgc.updInv(I);
				System.out.println(Model.Mensajes. CTRLINVITADOINVCODICORRECTO);
			} catch (SQLException sqle) {
				System.out.println(Model.Mensajes.GENERALERROR);
				Integer codE = sqle.getErrorCode();

				errores(sqle, codE);
			}

		}

	}

	
	public static List<Invitado> listar() {
		Integer i = 0;
		System.out.println(Model.Mensajes.LISTArtistas);

		try {
			list = Logic.Invitado.Invitado_lgc.ListInv();
			if (list.size() == 0) {
				System.out.println();
				System.out.println(Model.Mensajes.CTRLINVITADORTNEGATIVO);
			}
			if (list.size() > 0) {

				System.out.println();
				for (Invitado I : list) {
					System.out.println((i + 1) + ". EL/LA iNVITADO " + I.getNombre() + " CON APELLIDOS "
							+ I.getApellido() + " " 
							+ "Y CON NUMERO DE TELEFONO " + I.getTelefono());
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

	
	private static Invitado pedirDatos() {

		System.out.println();

		do {
			nombre = until.Teclado.readString(Model.Mensajes.GENERALNOMBRE);
		} while (!nombre.matches("[A-Za-z ]*") || nombre.isEmpty());

		do {
			apellido = until.Teclado.readString(Model.Mensajes.CTRLINVITADOAPELLIDO);
		} while (!apellido.matches("[A-Za-z ]*") || apellido.isEmpty());

	
		do {
			telefono = until.Teclado.readInt(Model.Mensajes.CTRLINVITADOTELEFONO);
		} while (telefono.toString().length() != 9 || telefono.toString().isEmpty());

	
		do {
			dni = Teclado.readString(Model.Mensajes.CTRLINVITADODNI);

		} while (!dni.matches("[0-20]{8}[A-X a-x]{1}"));
		I.setNombre(nombre.toUpperCase());
		I.setApellido(apellido.toUpperCase());
		I.setTelefono(telefono);
		return I;
		
	}

	
	private static String sacarIndex() {
		String id;
		Integer index;
		do {
			System.out.println();
			index = Teclado.readInt(Model.Mensajes.GENERALPOSICION);
		} while (index > list.size() || index <= 0);

		id = list.get(index - 1).getIdInvitado();
		return id;
	}

}
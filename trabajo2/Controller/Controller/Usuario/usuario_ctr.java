package Controller.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Usuario;
import until.Teclado;

public class usuario_ctr {
	private static List<Usuario> list = new ArrayList<Usuario>();
	Usuario u = new Usuario();
	private static String nombre;
	private static String email;
	private static String password;
	private static Integer codE = 0;


	public static void crear() {
		Usuario u = new Usuario();
		System.out.println();

		u = pedirDatos();

		try {
			System.out.println();
			Logic.Usuario.LogicUsuario.newUsu2(u);
			System.out.println(Model.Mensajes.GENERALCREADO);
		} catch (SQLException sqle) {
			System.out.println(Model.Mensajes.GENERALERROR);
			Integer codE = sqle.getErrorCode();

			errores(sqle, codE);
		}
	}


	public static void borrar() {
		Usuario u = new Usuario();
		Integer id;
		list = listar();
		if (list.size() > 0) {

			id = sacarIndex();
			u.setIdUsuario(id);

			try {
				Logic.Usuario.LogicUsuario.delUsu(u);
				System.out.println();
				System.out.println(Model.Mensajes.GENERALCREADO);
			} catch (SQLException e) {
				System.err.println(Model.Mensajes.GENERALERROR);
			}
		} else {
			System.out.println(Model.Mensajes.GENERALLISTNO);
		}

	}

	public static void modificarTodosCampos() {
		Usuario u = new Usuario();
		Integer id;

		list = listar();
		if (list.size() > 0) {
			try {

				id = sacarIndex();

				do {
					nombre = Teclado.readString(Model.Mensajes.CTRLUSUARIONOMBRE);
					try {
						Logic.Usuario.LogicUsuario.compNombreUsuario(nombre);

						System.out.println();
					} catch (SQLException sqle) {

						codE = sqle.getErrorCode();

						errores(sqle, codE);
					}
				} while (codE != 0);

				do {
					email = Teclado.readString(Model.Mensajes.CTRLUSUARIOEMAIL);
					try {

						Logic.Usuario.LogicUsuario.compCorreoUsuario(email);
						System.out.println();
					} catch (SQLException sqle) {
						System.out.println(Model.Mensajes.GENERALERROR);

						codE = sqle.getErrorCode();

						errores(sqle, codE);
					}
				} while (codE != 0);

				password = Teclado.readString(Model.Mensajes.CTRLUSUARIOPASSWORD);
				u.setIdUsuario(id);
				u.setNombreUsuario(nombre.toUpperCase());
				u.setEmail(email.toUpperCase());
				u.setContraseña(password);

				Logic.Usuario.LogicUsuario.updateuserallfield(u);
				System.out.println();
				System.out.println(Model.Mensajes.GENERALCREADO);

			} catch (SQLException e) {
				System.err.println(Model.Mensajes.GENERALERROR);
			}
		}
	}

	
	public static List<Usuario> listar() {
		System.out.println(Model.Mensajes.LISTUSUARIO);
		Integer i = 0;
		try {
			list = Logic.Usuario.LogicUsuario.ListUsu();
			if (list.size() == 0) {
				System.out.println();
				System.out.println(Model.Mensajes.GENERALLISTNO);
			} else if (list.size() > 0) {

				System.out.println();
				for (Usuario u : list) {
					System.out.println((i + 1) + ". Nombre de usuario: " + u.getNombreUsuario()
							+ "\n   Email de usuario: " + u.getEmail());
					i++;
				}
			}
		} catch (SQLException e) {
			System.err.println(Model.Mensajes.GENERALERROR);
		}
		return list;

	}


	private static void errores(SQLException sqle, Integer codE) {
		String msg;
		switch (codE) {
		case 20001:
			msg = Model.Mensajes.CTRLERROR01;
			break;

		case 20002:
			msg = Model.Mensajes.CTRLERROR15;
			break;

		case 20003:
			msg = Model.Mensajes.CTRLERROR16;
			break;

		case 20004:
			msg = Model.Mensajes.CTRLERROR17;
			break;

		case 20005:
			msg = Model.Mensajes.CTRLERROR18;
			break;

		case 20006:
			msg = Model.Mensajes.CTRLERROR19;
			break;

		case 20007:
			msg = Model.Mensajes.CTRLERROR20;
			break;

		case 20008:
			msg = Model.Mensajes.CTRLERROR21;
			break;

		case 20009:
			msg = Model.Mensajes.CTRLERROR22;
			break;

		case 20010:
			msg = Model.Mensajes.CTRLERROR23;
			break;

		case 20011:
			msg = Model.Mensajes.CTRLERROR24;

			break;
		default:
			msg = sqle.getMessage();
		}
		System.err.println("El error es: " + msg);
	}

	public static Usuario pedirDatos() {
		Usuario u = new Usuario();

		do {
			nombre = Teclado.readString(Model.Mensajes.CTRLUSUARIONOMBRE);
			try {
				Logic.Usuario.LogicUsuario.compNombreUsuario(nombre);

			} catch (SQLException sqle) {

				codE = sqle.getErrorCode();

				errores(sqle, codE);

			}
		} while (codE != 0);

		do {
			System.out.println();
			email = Teclado.readString(Model.Mensajes.CTRLUSUARIOEMAIL);
			try {
				Logic.Usuario.LogicUsuario.compCorreoUsuario(email);
				System.out.println();
				codE = 0;
			} catch (SQLException sqle) {

				codE = sqle.getErrorCode();
				errores(sqle, codE);
			}
		} while (codE != 0);

		do {
			password = Teclado.readString(Model.Mensajes.CTRLUSUARIOPASSWORD);
			try {
				Logic.Usuario.LogicUsuario.compContraseña(password);

			} catch (SQLException sqle) {
				codE = 0;
				codE = sqle.getErrorCode();
				errores(sqle, codE);

			}
		} while (codE != 0);

		u.setNombreUsuario(nombre);
		u.setContraseña(password);
		u.setEmail(email);

		return u;
	}

	
	private static Integer sacarIndex() {
		Integer id;
		Integer index;
		do {
			System.out.println();
			index = Teclado.readInt(Model.Mensajes.GENERALPOSICION);
		} while (index > list.size() || index <= 0);

		id = list.get(index - 1).getIdUsuario();
		return id;
	}

}

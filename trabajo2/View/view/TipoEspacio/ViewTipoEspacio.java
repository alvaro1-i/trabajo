package view.Artista;

import java.sql.Connection;
import java.sql.DriverManager;

import until.Teclado;
import view.Usuario.ViewUsuario;

public class ViewArtistas {
	public static void main(String[] args) {
		int a=Teclado.readInt("seleccione su opcion en cuanto a los artistas disponibles ahora mismo:");
		

		int opc;

		do {
			mostrarOpcionesEmpleado();
			opc = Teclado.readInt(Model.Mensajes.VIEWFRASESGENERALESOPCION);
			switch (opc) {
			case 1:
			Controller.Artista.Artista_ctr.crear();
				break;
			case 2:

				Controller.Artista.Artista_ctr.borrar();
				break;
			case 3:
				mostrarUpdate();
				break;
			case 4:
				Controller.Artista.Artista_ctr.listar();
				break;

			}

			if (opc > 4) {
				System.err.println(Model.Mensajes.VIEWFRASESGENERALESOPCIONNOVALIDA);
			}

		} while (opc != 0);
		Controller.General.General_ctr.volver();

	}

	private static void mostrarOpcionesEmpleado() {
		System.out.println(Model.Mensajes.VIEWTIPOESPACIO);
		System.out.println(Model.Mensajes.VIEWTIPOESPACIOOPC01);
		System.out.println(Model.Mensajes.VIEWTIPOESPACIOOPC02);
		System.out.println(Model.Mensajes.VIEWTIPOESPACIOOPC03);
		System.out.println(Model.Mensajes.VIEWTIPOESPACIOOPC04);;

	}

	private static void mostrarUpdate() {

		int opc;
		do {
			mostrarOpcionesUpdate();
		  opc = Teclado.readInt(Model.Mensajes.VIEWFRASESGENERALESOPCION);
			switch (opc) {
			case 1:
				Controller.Artista.Artista_ctr.modificarNombre();
				break;
			case 2:
				Controller.Artista.Artista_ctr.modificarApellido();
				break;
		
			case 4:
			Controller.Artista.Artista_ctr.modificarTelefono();
				break;
			case 5:
				Controller.Artista.Artista_ctr.modificarDni();
				break;
			case 7:
				Controller.Artista.Artista_ctr.modificarCampos();
				break;
			}

			if (opc > 8) {
				System.err.println(Model.Mensajes.VIEWFRASESGENERALESOPCIONNOVALIDA);
			}
		} while (opc != 0);
		Controller.General.General_ctr.volver();

	}

	private static void mostrarOpcionesUpdate() {
		System.out.println(Model.Mensajes.VIEWARTISTAMENU);
		System.out.println(Model.Mensajes.VIEWARTISTAMODOPC01);
		System.out.println(Model.Mensajes.VIEWARTISTAMODOPC02);
		System.out.println(Model.Mensajes.VIEWARTISTAMODOPC04);
		System.out.println(Model.Mensajes.VIEWARTISTAMODOPC06);
		System.out.println(Model.Mensajes.VIEWARTISTAMODOPC09);

	}
}


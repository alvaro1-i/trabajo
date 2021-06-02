package view.general;

import until.Teclado;

public class ViewGeneral {

	public static void gestGeneral() {

		int opc;

		do {
			mostrarOpcionesMenu();
		opc = until.Teclado.readInt(Model.Mensajes.VIEWFRASESGENERALESOPCION);

			switch (opc) {
			case 1:
				view.Usuario.ViewUsuario.getUsuario();
				break;
			case 2:
				view.Artista.ViewArtistas.gestProducto();
				break;
			case 3:
				view.Proveedor.ViewProveedor.gestProveedor();
				break;
			case 4:
				view.Local.ViewLocal.getLocal();
				break;
			case 5:
				view.TipoEspacio.ViewTipoEspacio.getTipoEspacio();
				breaK;
	
				
		
			}

			if (opc > 12) {
				System.err.println(Model.Mensajes.VIEWFRASESGENERALESOPCIONNOVALIDA);
			}

		} while (opc != 0);
		Controller.General.General_ctr.salirPrograma();

	}

	private static void mostrarOpcionesMenu() {
		System.out.println(Model.Mensajes.VIEWGENERALMENU);
		System.out.println(Model.Mensajes.VIEWGENRALOPC01);
		System.out.println(Model.Mensajes.VIEWGENRALOPC02);
		System.out.println(Model.Mensajes.VIEWGENRALOPC03);
		System.out.println(Model.Mensajes.VIEWGENRALOPC06);
		System.out.println(Model.Mensajes.VIEWGENRALOPC07);
		System.out.println(Model.Mensajes.VIEWGENRALOPC08);
		System.out.println(Model.Mensajes.VIEWGENRALOPC09);
		
	}

}

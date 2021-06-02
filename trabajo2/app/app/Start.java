package app;

import view.general.ViewGeneral;

public class Start {

	public static void main(String[] args) {

		try {
			dbm.Conexion_sql.ProbarBBDD();
			Start application = new Start();
			application.init();
		} catch (Exception e) {
			System.err.println(Model.Mensajes.STARTERROR);
		}
	}

	private void init() {

		ViewGeneral.gestGeneral();

	}

}

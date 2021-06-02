package Model;

public class Tipo_espacio {
	String barra;
	String Mesas_y_sofa ;
	String Terraza;
	String ID;
	
	
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getBarra() {
		return barra;
	}
	public void setBarra(String barra) {
		this.barra = barra;
	}
	public String getMesas_y_sofa() {
		return Mesas_y_sofa;
	}
	public void setMesas_y_sofa(String mesas_y_sofa) {
		Mesas_y_sofa = mesas_y_sofa;
	}
	public String getTerraza() {
		return Terraza;
	}
	public void setTerraza(String terraza) {
		Terraza = terraza;
	}
	@Override
	public String toString() {
		return "Tipo_espacio [barra=" + barra + ", Mesas_y_sofa=" + Mesas_y_sofa + ", Terraza=" + Terraza + "]";
	}
	public Tipo_espacio(String barra, String mesas_y_sofa, String terraza) {
		super();
		this.barra = barra;
		Mesas_y_sofa = mesas_y_sofa;
		Terraza = terraza;
	}
	public Tipo_espacio() {
		super();
	}
	public Tipo_espacio(String barra, String mesas_y_sofa, String terraza, String iD) {
		super();
		this.barra = barra;
		Mesas_y_sofa = mesas_y_sofa;
		Terraza = terraza;
		ID = iD;
	}
	
	

}

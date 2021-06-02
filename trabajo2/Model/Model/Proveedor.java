package Model;

public class Proveedor {

	Integer idProveedor;
	String nombre;
	String direccion;
	String nif;
	

	public Proveedor() {
		super();
	}

	public Proveedor(Integer idProveedor, String nombre, String direccion) {
		setIdProveedor(idProveedor);
		setNombre(nombre);
		setDireccion(direccion);
	}
	

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nombre=" + nombre + ", direccion=" + direccion + ", nif="
				+ nif + "]";
	}

	public Proveedor(String string, String nombre, String direccion, String nif) {
		super();
		this.idProveedor = string;
		this.nombre = nombre;
		this.direccion = direccion;
		this.nif = nif;
	}

	

}

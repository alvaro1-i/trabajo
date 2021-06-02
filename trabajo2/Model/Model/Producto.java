package Model;

public class Producto {
	String nombre;
	String codigo_barras;
	String marca;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo_barras() {
		return codigo_barras;
	}
	public void setCodigo_barras(String codigo_barras) {
		this.codigo_barras = codigo_barras;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo_barras=" + codigo_barras + ", marca=" + marca + "]";
	}
	public Producto(String nombre, String codigo_barras, String marca) {
		super();
		this.nombre = nombre;
		this.codigo_barras = codigo_barras;
		this.marca = marca;
	}
	public Producto() {
		super();
	}
	
	

}

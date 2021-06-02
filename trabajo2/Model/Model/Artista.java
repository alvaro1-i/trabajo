package Model;

public class Artista {
	private Integer idArtista;
	private String nombre;
	private String apellido;
	private String Mail;
	private String DNI;
	private Integer telefono;
	
	
	
	public Artista() {
		super();
	}


	public Artista(Integer idArtista, String nombre, String apellido, Integer telefono,
			String Mail, String DNI) {
		setIdArtista(idArtista);
		setNombre(nombre);
		setApellido(apellido);
		setTelefono(telefono);
		setMail(Mail);
		setDNI(DNI);
		}
	
	public Artista( String nombre, String apellido, Integer telefono,
			String Mail, String DNI) {
		setNombre(nombre);
		setApellido(apellido);
		setTelefono(telefono);
		setMail(Mail);
		setDNI(DNI);
		}
	
	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public Integer getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(Integer idArtista2) {
		this.idArtista = idArtista2;
	}
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public Artista(String nombre, String apellido, String mail, String dNI) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		Mail = mail;
		DNI = dNI;
	}
	@Override
	public String toString() {
		return "Artista [nombre=" + nombre + ", apellido=" + apellido + ", Mail=" + Mail + ", DNI=" + DNI + "]";
	}
	
	

}

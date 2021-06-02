package Model;

public class Invitado {
	String IdInvitado;
	String nombre;
	String apellido;
	String mail;
    String dni;
	int telefono;
	
	
   public Invitado(String idInvitado, String nombre, String apellido, String mail, int telefono) {
		super();
		IdInvitado = idInvitado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
	}
	

	public Invitado(String nombre, String apellido, String mail, int telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
	}


	

	public Invitado(String idInvitado, String nombre, String apellido, String mail, String dni, int telefono) {
		super();
		IdInvitado = idInvitado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.dni = dni;
		this.telefono = telefono;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getIdInvitado() {
		return IdInvitado;
	}


	public void setIdInvitado(String idInvitado) {
		IdInvitado = idInvitado;
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
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Invitado(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
	}
	
	
	public Invitado() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Invitado [nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", telefono=" + telefono
				+ "]";
	}


	

}

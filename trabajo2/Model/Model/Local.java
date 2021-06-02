package Model;

public class Local {
	String nombre;
	String horarios;
	String lugar;
    Integer idLocal;
    Integer Telefono;
    
    

    
    
    
	public Integer getTelefono() {
		return Telefono;
	}
	public void setTelefono(Integer telefono) {
		Telefono = telefono;
	}
	public String getHorarios() {
		return horarios;
	}
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	public Integer getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(Integer id) {
		this.idLocal = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public Local(String nombre, String lugar) {
		super();
		this.nombre = nombre;
		this.lugar = lugar;
	}

	public Local(String nombre, String horarios, String lugar, String idLocal) {
		super();
		this.nombre = nombre;
		this.horarios = horarios;
		this.lugar = lugar;
		this.idLocal = idLocal;
	}
	
	
	@Override
	public String toString() {
		return "Local [nombre=" + nombre + ", horarios=" + horarios + ", lugar=" + lugar + ", idLocal=" + idLocal + "]";
	}
	public Local() {
		super();
	}
	

}

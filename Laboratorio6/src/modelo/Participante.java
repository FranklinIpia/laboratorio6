package modelo;

public class Participante implements Comparable<Participante> {

	
	private String nombre;
	private int id;
	private String apellido;
	private String avatar;
	private String correo;
	private String genero;
	
	private Participante anterior;
	private Participante siguiente;
	
	
	public Participante(int id,String nombre,String apellido,String avatar,String correo,String genero) {
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.avatar=avatar;
		this.correo=correo;
		this.genero=genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Participante getAnterior() {
		return anterior;
	}
	public void setAnterior(Participante anterior) {
		this.anterior = anterior;
	}
	public Participante getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Participante siguiente) {
		this.siguiente = siguiente;
	}
	@Override
	public int compareTo(Participante p1) {
		// TODO Auto-generated method stub
		if(this.id>p1.getId()) {
			return 1;
		}else if(this.id<p1.getId()) {
			return -1;
		}else {
			return 0;
		}
		
	}
	
	
	
	
	
}

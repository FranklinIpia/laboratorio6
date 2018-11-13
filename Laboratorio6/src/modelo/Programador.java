package modelo;

public class Programador implements Comparable<Programador> {

	
	private String nombre;
	private int id;
	private String apellido;
	private String avatar;
	private String correo;
	private String genero;
	
	private Programador hijoDerecho;
	private Programador hijoIzquierdo;
	
	


	public Programador(int id,String nombre,String apellido,String correo,String genero,String avatar) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.avatar=avatar;
		this.id=id;
		this.genero=genero;
		this.correo=correo;
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
	
	
	
	public Programador getHijoDerecho() {
		return hijoDerecho;
	}


	public void setHijoDerecho(Programador hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}


	public Programador getHijoIzquierdo() {
		return hijoIzquierdo;
	}


	public void setHijoIzquierdo(Programador hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	
	public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
	    if(hijoDerecho!=null) {
	        hijoDerecho.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
	    }
	    sb.append(prefix).append(isTail ? "└── " : "┌── ").append(nombre+"("+id+")").append("\n");
	    if(hijoIzquierdo!=null) {
	        hijoIzquierdo.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
	    }
	    return sb;
	}
	
	@Override
	public String toString() {
	    return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
	}
	
	
	
	


	@Override
	public int compareTo(Programador p2) {
		// TODO Auto-generated method stub
		if(this.id>p2.getId()) {
			return 1;
		}else if(this.id<p2.getId()) {
			return-1;
		}else {
			return 0;
		}
	
	}
	
}

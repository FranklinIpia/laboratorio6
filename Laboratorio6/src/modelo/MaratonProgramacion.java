package modelo;




public class MaratonProgramacion {


	private Programador raiz;
	private int totalProgramadores;
	
	private int contadorParticipantes;
	private Participante primerParticipante;
	
	public MaratonProgramacion() {

	}
	public int getTotalProgramadores() {
		return totalProgramadores;
	}


	public void setTotalProgramadores(int totalProgramadores) {
		this.totalProgramadores = totalProgramadores;
	}


	public int getContadorParticipantes() {
		return contadorParticipantes;
	}


	public void setContadorParticipantes(int contadorParticipantes) {
		this.contadorParticipantes = contadorParticipantes;
	}


	
	
	

	public Programador getRaiz() {
		return raiz;
	}


	public void setRaiz(Programador raiz) {
		this.raiz = raiz;
	}




	public Participante getPrimerParticipante() {
		return primerParticipante;
	}


	public void setPrimerParticipante(Participante primerParticipante) {
		this.primerParticipante = primerParticipante;
	}
	
	
	public void insertar(Programador nuevoProgramador,Programador raiz2) {
		
		//primerCao
		//Si la raiz es nula
		if(raiz2==null) {
			this.raiz=nuevoProgramador;
		}
	
		else {
			
			//Segundo caso
			//Si el nodo a insertar es mayor a la raiz
			if(raiz2.compareTo(nuevoProgramador)==-1) {
				if(raiz2.getHijoDerecho()==null) {
					raiz2.setHijoDerecho(nuevoProgramador);
					totalProgramadores++;
				}else {
					insertar(nuevoProgramador,raiz2.getHijoDerecho());
				}
			}
			else {
				
				if(raiz2.getHijoIzquierdo()==null) {
				raiz2.setHijoIzquierdo(nuevoProgramador);	
				totalProgramadores++;
				
				}else {
					
					insertar(nuevoProgramador, raiz2.getHijoIzquierdo());
				}
				
				
			}
			
			
		}
		
	
		
		
	}
	
	
public  void refrescar() {
	
}
	
	



public void agregarParticipanteRecursivo(Participante primerParticipante, Participante nuevParticipante) {
	
	if(this.primerParticipante==null) {
		this.primerParticipante=nuevParticipante;
	}else if(this.primerParticipante.getId()>nuevParticipante.getId()) {
		nuevParticipante.setSiguiente(primerParticipante);
	this.primerParticipante=nuevParticipante;
	}else {
		Participante actual=primerParticipante;
		if(actual.getId()<nuevParticipante.getId()) {
			if(actual.getSiguiente()==null) {
				actual.setSiguiente(nuevParticipante);
			contadorParticipantes++;
			}else if(actual.getSiguiente().getId()>nuevParticipante.getId()) {
				nuevParticipante.setSiguiente(actual.getSiguiente());
				actual.setSiguiente(nuevParticipante);
				contadorParticipantes++;
			}else {
				actual=actual.getSiguiente();
				agregarParticipanteRecursivo(actual,nuevParticipante);
			}
			
			
		}
		
		
		
	}


	
	
}
		
	
	
public Programador buscarProgramador(int id, Programador raiz) {
		Programador programadorEncontrado=null;
		if(raiz==null) {
			System.out.println("No existe el elemento buscado");
		}else{
			
			if(raiz.getId()==id) {
				return programadorEncontrado=raiz;
			}
			else {
				
				if( id>raiz.getId()) {
					return buscarProgramador(id,raiz.getHijoDerecho());
				}else {
					 return buscarProgramador(id,raiz.getHijoIzquierdo());
				}
				
				
			}
			
			
			
			
		}
		return programadorEncontrado;
	}
	
	
	
	public Participante buscarParticipante(int id, Participante primerParticipante) {
		Participante buscad=null;
		if(primerParticipante!=null) {
			
			if(primerParticipante.getId()==id) {
				buscad=primerParticipante;
				return buscad;
			}else {
				return buscarParticipante(id,primerParticipante.getSiguiente());
			}
		}
		
		return buscad;
	}
	
	
	
	public void mostrarProgramadores() {
		
		
		
		if(raiz==null) {
			System.out.println("No hay");
		}
		else {
			Programador actual=raiz;
			while(actual!=null) {
				
				System.out.println(actual.getId());
				actual=actual.getHijoDerecho();
			}
			
			
		}
		
		
		
	}
	
	
	
	
	public void mostrar() {
		
		if(primerParticipante==null) {
			System.out.println("No existe");
		}
		else {
			Participante actual=primerParticipante;
			while(actual!=null) {
				
				System.out.println(actual.getId());
				actual=actual.getSiguiente();
			}
			
			
		}
		
	}








	
	public String toString() {
		if (raiz!= null) {
			return raiz.toString();
		} else {
			return "";
		}
	}
	
	

	
}

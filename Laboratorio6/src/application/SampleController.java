package application;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.URL;
import java.security.SecureRandom;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.MaratonProgramacion;
import modelo.Participante;
import modelo.Programador;

public class SampleController {
	
	MaratonProgramacion m;
	@FXML
	private TextField txtTiempoTotal;
	
	@FXML
	private TextArea area;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtCorreo;
	@FXML
	private TextField txtApellido;
	@FXML
	private TextField txtGenero;
	@FXML
	private ImageView imagen;
	@FXML
	private Button btnCargar;
	
	@FXML
	private Button buscarProgramador;
	
	@FXML
	private Button buscarPartipante;
	
	@FXML
	private TextField txtIdProgramador;
	
	@FXML
	private TextField txtIdParticipante;
	
	@FXML
	private TextField txtRutaArchivo;
	
	@FXML
	private TextField txtTiempoBusquedaProgramador;
	@FXML
	private TextField txtTiempoBusquedaPariticpante;
	@FXML
	private TextField txtSeEncontroProgramador;
	@FXML
	private TextField txtSeEncontroParti;
	
	
	@FXML
	private Button btnDatos;
	
	public SampleController() {
		area= new TextArea();
		txtTiempoTotal= new TextField();

		m=new MaratonProgramacion();
		

		
	
		
	}
	
	
	
	public void initialize() {
		URL pokemon1= getClass().getResource("/MaratonProgramacion/anonimo.jpg");
	    Image image = new Image(pokemon1.toString());
	    imagen.setImage(image);
	 
	}
	
	
	public void cargarArchivo() {

		JFileChooser buscador= new JFileChooser("./data");
		buscador.showOpenDialog(buscador);
//		FileInputStream entrada=null;
//		DataInputStream obj=null;	
		
             try {
            	
     			String path= buscador.getSelectedFile().getAbsolutePath();
     			System.out.println(path);
     			txtRutaArchivo.setText(path);
     			File file = new File (path);
			FileReader reader = new FileReader(file); //Se prepara para la lectura del archivo
			BufferedReader br = new BufferedReader(reader); //Se carga en el buffer para su manipulación
			String line = "";
			long t1 = System.currentTimeMillis();
			System.out.println("Tiempo 0: " + t1/1000);
			if(!path.equals("C:\\Users\\Autorizado\\eclipse-workspace\\Laboratorio6\\data\\MOCK_DATA.txt")&&!path.equals("C:\\Users\\Autorizado\\eclipse-workspace\\Laboratorio6\\data\\MOCK_DAT19999.txt")&&!path.equals("C:\\Users\\Autorizado\\eclipse-workspace\\Laboratorio6\\data\\MOCK_DAT50000.txt")) {
			while((line = br.readLine()) != null){ //Se leen las lineas hasta el final del documento
				String arreglo[]=line.split(",");
				int id= Integer.parseInt(arreglo[0]);
				String nombre=arreglo[1];
				String apellido=arreglo[2];
				String correo=arreglo[3];
				String genero=arreglo[4];
				String rutaImagen=arreglo[5];
				 Programador porgramador= new Programador(id,nombre,apellido,correo,genero,rutaImagen);
				 m.insertar(porgramador, m.getRaiz());
			}
			
			}else {	
				while((line = br.readLine()) != null){ //Se leen las lineas hasta el final del documento
					String arreglo[]=line.split(",");
					String id= arreglo[0];
//					System.out.println(id);
				
					
					int id1=0;
					int id2=0;
	                 try {
	                	 String arregloId[]=id.split("-");
	                	 if(arregloId[0]!=null) {
	    					 id1=Integer.parseInt(arregloId[0]);
	    	
	    					}
	    					if(arregloId[1]!=null) {
	    					id2=Integer.parseInt(arregloId[1]);

	    					}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage()+"jjjjjj");
					}finally {
						int idTotal=id1+id2;
						String nombre=arreglo[1];
						String apellido=arreglo[2];
						String correo=arreglo[3];
						String genero=arreglo[4];
						String rutaImagen=arreglo[5];
						 Programador porgramador= new Programador(idTotal,nombre,apellido,correo,genero,rutaImagen);
						 m.insertar(porgramador, m.getRaiz());
			
					}
				
				}
				
			}
			br.close();
			
			
	
		System.out.println("Pariticpantes totales: " + m.getContadorParticipantes());
		System.out.println("Total de programadores"+m.getTotalProgramadores());
			
			long t2 = System.currentTimeMillis();
			txtTiempoTotal.setText(((t2-t1)/1000) +" s");
			System.out.println("Tiempo total: " + (t2-t1)/1000);
			crearParticipantes() ;

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.getMessage();
		}
             
				
		
	}
	
	public void leerLineas(BufferedReader bff) {
		try {
			String line = "";

			if((line=bff.readLine())!=null) {
				String arreglo[]=line.split(",");
				int id= Integer.parseInt(arreglo[0]);
				String nombre=arreglo[1];
				String apellido=arreglo[2];
				String correo=arreglo[3];
				String genero=arreglo[4];
				String rutaImagen=arreglo[5];
				 Programador porgramador= new Programador(id,nombre,apellido,correo,genero,rutaImagen);
				 m.insertar(porgramador, m.getRaiz());
				 refrescar();
				 leerLineas(bff);
				
			}
//			bff.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	
	
		
	}
	
	
	
	public void buscarProgramador() {
//		crearParticipantes();
		if(txtIdProgramador.getText()!=null) {
		int idBuscar= Integer.parseInt(txtIdProgramador.getText());
		long t1 = System.currentTimeMillis();
		System.out.println("Tiempo 0: " + t1/1000);
		Programador programadorEncontrado=m.buscarProgramador(idBuscar, m.getRaiz());
		long t2 = System.currentTimeMillis();
		int tiempoBusqueda= (int) ((t2-t1)/1000);
		txtTiempoBusquedaProgramador.setText(tiempoBusqueda+"");
		System.out.println("Tiempo total: " + (t2-t1)/1000);
		if(programadorEncontrado==null) {
			txtSeEncontroProgramador.setText("No se encontro el programador");
			
		}else {
			txtTiempoBusquedaProgramador.setText(tiempoBusqueda+"");
			txtSeEncontroProgramador.setText("Se encontro satisfactoriamente");
			System.out.println("El que bsucas" +  programadorEncontrado.getId());
		}
		
//		m.mostrar();
		System.out.println("Total participantes"+ m.getContadorParticipantes());
		btnDatos.setOnAction(new EventHandler<ActionEvent>() {
			
			
			@Override
			public void handle(ActionEvent a) {
				// TODO Auto-generated method stub
				txtId.setText(programadorEncontrado.getId()+"");
				txtApellido.setText(programadorEncontrado.getApellido());
				txtCorreo.setText(programadorEncontrado.getCorreo());
				txtGenero.setText(programadorEncontrado.getGenero());
				txtNombre.setText(programadorEncontrado.getNombre());
//				URL avatar= getClass().getResource(n.getAvatar());
				  Image image = new Image(programadorEncontrado.getAvatar());
				    imagen.setImage(image);
			}
		});
		}	
	}
	
	
	public void buscarParticipante() {
		if(txtIdParticipante.getText()!=null) {
	int idParticipante= Integer.parseInt(txtIdParticipante.getText());
	long t1 = System.currentTimeMillis();
	System.out.println("Tiempo 0: " + t1/1000);
	Participante parti= m.buscarParticipante(idParticipante, m.getPrimerParticipante());
	long t2 = System.currentTimeMillis();
	int tiempoBusqueda= (int) ((t2-t1)/1000);
	txtTiempoBusquedaPariticpante.setText(tiempoBusqueda+"");
	if(parti==null) {
		txtSeEncontroParti.setText("No se puedo encontrar el Participante");
	}else {
		txtSeEncontroParti.setText("Se encontro el participante satisfactoriamente");
	}
	
	
	
	btnDatos.setOnAction(new EventHandler<ActionEvent>() {
		
		@Override
		public void handle(ActionEvent a) {
			// TODO Auto-generated method stub
			txtApellido.setText(parti.getApellido());
			txtNombre.setText(parti.getNombre());
			txtCorreo.setText(parti.getCorreo());
			txtGenero.setText(parti.getCorreo());
			txtId.setText(parti.getId()+"");
			Image image = new Image(parti.getAvatar());
		    imagen.setImage(image);
			
			
			
		}
	});
	
		}
	}
	
	public void crearParticipantes() {
		try {
		if(m.getContadorParticipantes()<m.getTotalProgramadores()/2) {
			
			SecureRandom ranm= new SecureRandom();
			int valor= 1+ ranm.nextInt((m.getTotalProgramadores()));
			Programador programador= m.buscarProgramador(valor,m.getRaiz());
			if(programador==null) {
				crearParticipantes();
			}else {
				//Mirar si ya existe un participante con el mismo id
				Participante buscado=m.buscarParticipante(programador.getId(), m.getPrimerParticipante());
				if(buscado==null) {
					System.out.println("Encontro");
					Participante nuevo= new Participante(programador.getId(), programador.getNombre(), programador.getApellido(), programador.getAvatar(), programador.getCorreo(), programador.getGenero());
			m.agregarParticipanteRecursivo( m.getPrimerParticipante(),nuevo);
//				m.setContadorParticipantes(m.getContadorParticipantes()+1);
					crearParticipantes();
				}else {
					crearParticipantes();
				}
			}
			
			
		}
		}catch (Exception e) {
			System.out.println(e.getMessage()+"Excepcion");// TODO: handle exception
		}
	}
	

	
	public void refrescar() {
		area.setText(m.toString());
	}
	
	
	
	
}

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.MaratonProgramacion;
import modelo.Participante;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static MaratonProgramacion mara= new MaratonProgramacion();
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("BannerMaraton.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		Participante nuevo= new Participante(4, "userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet");
	Participante nuev2o= new Participante(3, "userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet");
		Participante nuev2= new Participante(7, "userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet");
		Participante nuev23o= new Participante(0, "userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet");
//		Participante nuev00o= new Participante(1, "userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet");
		Participante nuevo22= new Participante(9, "userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet"," userAgentStylesheet");
//      System.out.println("aaaa");
//		mara.insertarListaSimple(nuevo, mara.getPrimerParticipante());
//		mara.insertarListaSimple(nuevo22, mara.getPrimerParticipante());
//		mara.insertarListaSimple(nuev2, mara.getPrimerParticipante());
//		mara.insertarListaSimple(nuev00o, mara.getPrimerParticipante());
//		mara.insertarListaSimple(nuev2o, mara.getPrimerParticipante());
//		mara.mostrar();
	}
}

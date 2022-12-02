package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Child;

public class Main extends Application{
	
	public static final String URL= "http://192.168.43.232:8080/Server/api/";
	public static final String children_URL="children/";
	public static final String educator_URL="";
	public static ArrayList<String> listaVaspitaca = new ArrayList<String>();//lista u koju se dodaju vaspitaci kad se kreiraju(tacnije ime i prezime vaspitaca String)
	public static ArrayList<String> listaGrupa = new ArrayList<String>();//lista u koju se dodaju grupe kad se kreiraju(tacnije naziv grupe tipa String)
	public static ArrayList<Child> listChildren = new ArrayList<Child>();
	public static ArrayList<String> listaDjece = new ArrayList<String>();//lista u koju se dodaju djeca kad se kreiraju(tacnije ime i prezime djeteta tipa String)
	@Override
	public void start(Stage stage)  {
		// TODO Auto-generated method stub
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
			stage.setScene(scene);
			stage.show();

		}catch(Exception ex) {
			
		}

	}
	
	public static void main(String[] args) {
		
		listaGrupa.add("grupa2");//obrisati ovo poslije
		listaGrupa.add("grupa3");//obrisati ovo poslije
		listaVaspitaca.add("Vaspitac");//i ovo, samo za probu sluzi
		listaDjece.add("Dijete"); //  ovo, samo za probu sluzi
	//	listChildren.add(new Child("Ime", "Prezime", null, null, null, null, null,null,null,null,null,null,null,null));
		try {
			launch(args);
		}catch(Exception ex) {
			
		}
		
		
	}

}

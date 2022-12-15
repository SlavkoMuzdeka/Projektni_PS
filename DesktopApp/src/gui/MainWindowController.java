package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainWindowController implements Initializable {

	public static MainWindowController instance = null;
	
	
	
	public static MainWindowController getInstance() {
		
		if (instance == null) {

			return new MainWindowController();
		}
		return instance;
	}


	@FXML
	public GridPane mainPane;

	@FXML
	private Pane PaneLogo; //dobro

	@FXML
	private Button btnAddChild;  //dobroo



	

	@FXML
	private Button btnChildrenRecords;  //dobroo

	@FXML
	private Button btnFinance;  //dobro

	@FXML
	private Button btnSignOut;   //dobor

	@FXML
	private Button btnEducators;   //dobro

	@FXML
	private Button btnKindergarten;  //dobro


    @FXML
    private Button btnChildEvidencyPresence;



	@FXML
	private ImageView imgVUser;

	@FXML
	private Label lblLogo;

	@FXML
	private Label lblWindowName;

	



	@FXML
	private Pane paneCurrentUser;

	@FXML
	private Pane paneHorizontal;

	@FXML
	private Pane paneHorizontal1;

	@FXML
	private Pane paneVBox;  //dobro

	@FXML
	private Pane paneKindergarten;

	@FXML
	private VBox vBox;

	@FXML
	private VBox vBoxUser;
	
	@FXML 
	private ScrollPane scrollPane;

    @FXML
    public BorderPane borderPaneMainPane;
    

    public BorderPane getBorderPaneMainPane() {
		return borderPaneMainPane;
	}

	public void setBorderPaneMainPane(BorderPane borderPaneMainPane) {
		this.borderPaneMainPane = borderPaneMainPane;
	}


	@FXML
    private AnchorPane AnchorPanee;
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
		
		try {
			GridPane pane = FXMLLoader.load(getClass().getResource("GroupsWindow.fxml"));
			borderPaneMainPane.setCenter(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	//	listViewMainWindow.getItems().addAll(Main.listaGrupa);

		/*mainPane.prefWidthProperty().bind(anchorPane.widthProperty());

		paneHorizontal.prefWidthProperty().bind(mainPane.widthProperty());
		paneKindergarten.prefWidthProperty().bind(mainPane.widthProperty());
		paneKindergarten.prefHeightProperty().bind(mainPane.heightProperty());
		scrollPane.prefWidthProperty().bind(mainPane.widthProperty());
		scrollPane.prefHeightProperty().bind(mainPane.heightProperty());*/

		/*
		 * anchorPane.widthProperty().addListener((obs, oldVal, newVal)->{
		 * System.out.println("--------------" + obs.getClass());
		 * if(newVal.doubleValue() > oldVal.doubleValue())
		 * mainPane.setPrefWidth(mainPane.getWidth() + (newVal.doubleValue() -
		 * oldVal.doubleValue()) ); // btnAddGroup.setLayoutX(btnAddGroup.getLayoutX() +
		 * 100.0); //btnAddGroup.setTranslateX(btnAddGroup.getTranslateX() + 3.0);
		 * //btnAddGroup.setScaleX(btnAddGroup.getScaleX() + 1.0);
		 * 
		 * // if(newVal.doubleValue() < oldVal.doubleValue())
		 * //btnAddGroup.setTranslateX(btnAddGroup.getTranslateX() - 3.0); });
		 */
	}

	 @FXML
	    void btnChildEvidencyPresenceClick(ActionEvent event) {

		 
		 try {
				GridPane pane = FXMLLoader.load(getClass().getResource("ChildEvidencyOfPresenceWindow.fxml"));
				borderPaneMainPane.setCenter(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	    }


	@FXML
	void btnEducatorsClick(ActionEvent event) {

		try {
			GridPane pane = FXMLLoader.load(getClass().getResource("EducatorsWindow.fxml"));
			borderPaneMainPane.setCenter(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void btnKindergartenClick(ActionEvent event) {

		try {
			GridPane pane = FXMLLoader.load(getClass().getResource("GroupsWindow.fxml"));
			borderPaneMainPane.setCenter(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnFinanceClick(ActionEvent event) {
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("FinanceWindow.fxml"));
			borderPaneMainPane.setCenter(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnAddChildClick(ActionEvent event) {
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("AddChildWindow.fxml"));
			borderPaneMainPane.setCenter(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void btnChildrenRecordsClick(ActionEvent event) {
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("ChildrenRecordsWindow.fxml"));
			borderPaneMainPane.setCenter(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void btnShowAccountClick(ActionEvent event) {
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("ShowAccountWindow.fxml"));
			borderPaneMainPane.setCenter(pane);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	
    @FXML
    void btnSignOutClick(ActionEvent event) {

    	CustomizedAlert ca = new CustomizedAlert(AlertType.CONFIRMATION,  "Da li ste sigurni da se želite odjaviti?","Odjava");
		
    	 Optional<ButtonType> option = ca.showAndWait();
    	 if(option.get() ==  ButtonType.YES) {
    		 Stage s = (Stage)(((Node) event.getSource()).getScene().getWindow());
 			s.close();
 			Stage stage = new Stage();
 			FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInWindow.fxml"));
			Parent root;
			try {
				root = loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
				stage.setScene(scene);
				
				stage.getIcons().add(new Image("./icons/icon.png"));
				
				stage.setTitle("e-Vrtic");
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    		 
    	 }
    }

}

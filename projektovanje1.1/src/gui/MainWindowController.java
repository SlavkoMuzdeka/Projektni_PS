package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainWindowController implements Initializable{

	
    @FXML
    public  Pane mainPane;

    @FXML
    private Pane PaneLogo;

    @FXML
    private Button btnAddChild;

    @FXML
    private Button btnAddGroup;

    @FXML
    private Button btnAddEducator;

    @FXML
    private Button btnChildrenRecords;

    @FXML
    private Button btnFinance;

    @FXML
    private Button btnSignOut;

    @FXML
    private Button btnEducators;

    @FXML
    private Button btnKindergarten;

    @FXML
    private HBox hBoxHorizontalEducators;

    @FXML
    private HBox hBoxEducators;

    @FXML
    private HBox hBoxKindergarten;

    @FXML
    private HBox hBoxKindergartenHorizontal;

    @FXML
    private ImageView imgVUser;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblWindowName;

    @FXML
    private Label lblWindowName1;

    @FXML
    private ListView<String> listViewEducatorsWindow;

    @FXML
    private ListView<String> listViewMainWindow;

    @FXML
    private Pane paneCurrentUser;

    @FXML
    private Pane paneHorizontal;

    @FXML
    private Pane paneHorizontal1;

    @FXML
    private Pane paneVBox;

    @FXML
    private Pane paneKindergarten; 

    @FXML
    private VBox vBox;

    @FXML
    private VBox vBoxUser;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		listViewMainWindow.getItems().addAll(Main.listaGrupa);
		
		
		
	}
	
	   @FXML
	    void btnAddGroupClick(ActionEvent event) {
		   
		   try {
				Pane pane = FXMLLoader.load	(getClass().getResource("CreateGroupWindow.fxml"));
				mainPane.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	    }
	   
	   @FXML
	    void btnEducatorsClick(ActionEvent event) {
		  	   
		     try {
				Pane pane = FXMLLoader.load	(getClass().getResource("EducatorsWindow.fxml"));
				mainPane.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		   
		   
	    }

	   @FXML
	    void btnKindergartenClick(ActionEvent event) { 
		   
		   
		  	Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
				Scene scene = new Scene(root);
				Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	   @FXML
	    void btnFinanceClick(ActionEvent event) {
		   try {
				Pane pane = FXMLLoader.load	(getClass().getResource("FinanceWindow.fxml"));
				mainPane.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   @FXML
	    void btnAddChildClick(ActionEvent event) {
		   try {
				Pane pane = FXMLLoader.load	(getClass().getResource("AddChildWindow.fxml"));
				mainPane.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	    }
	   
	   @FXML
	   void btnChildrenRecordsClick(ActionEvent event) {
		   try {
				Pane pane = FXMLLoader.load	(getClass().getResource("ChildrenRecordsWindow.fxml"));
				mainPane.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	
	   }
	   
	   
	   @FXML
	   void btnShowAccountClick(ActionEvent event) {
		   try {
				Pane pane = FXMLLoader.load	(getClass().getResource("ShowAccountWindow.fxml"));
				mainPane.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
	   }
	    @FXML
	    void btnAddEducatorsClick(ActionEvent event) {
	    	   Parent root;
	   		try {
	   			root = FXMLLoader.load(getClass().getResource("AddEducatorWindow.fxml"));
	   			Scene scene = new Scene(root);
	   			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   			scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
	   			stage.setScene(scene);
	   			stage.show();
	   		} catch (IOException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		}
	    }
	   @FXML 
	   public void handleMouseClick(MouseEvent arg0) {
	//	    System.out.println("clicked on " + arg0.getSource()+ "----------" + listViewMainWindow.getSelectionModel().getSelectedItem()); //listViewMainWindow.getSelectionModel().getSelectedItem() daje ime grupe
		    if(listViewMainWindow.getSelectionModel().getSelectedItem()!=null) {
		    	Parent root;
		    	try {
					root = FXMLLoader.load(getClass().getResource("ShowGroupWindow.fxml"));
					Scene scene = new Scene(root);
					Stage stage = (Stage)((Node)arg0.getSource()).getScene().getWindow();
					scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
					stage.setScene(scene);
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		
		}
}

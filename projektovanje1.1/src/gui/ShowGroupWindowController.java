package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ShowGroupWindowController implements Initializable{


    @FXML
    private AnchorPane paneShowGroup;
	
	Button btnShow = new Button("Prikaži");
	Button btnDelete = new Button("Obriši");
    @FXML
    private ListView<String> listViewListEducators;
    @FXML
    private ListView<String> listViewListChildren;

    @FXML
    private Button btnActivity;

    @FXML
    private Button btnBackWindow;

    @FXML
    private Button btnAddChild;

    @FXML
    private AnchorPane btnAddChildToGroup;

    @FXML
    private Button btnAddEducator;

    @FXML
    private Button btnDeleteGroup;

    @FXML
    private Label lblNumberOfGroupMembers;

    @FXML
    private Label lblGroupName;

    @FXML
    private Label lblLogo;


    @FXML
    private Pane paneHorizontal;

    
    static class Cell extends ListCell<String> {  
        HBox hbox = new HBox();
    	 Button button = new Button("Ukloni iz grupe");
    	 Label label = new Label("");
    	 Pane pane = new Pane();
    	 
    	 
        
        public Cell() {
        	super();
        	button.setStyle("-fx-background-color: #ffe6ff");
        	hbox.getChildren().addAll(label,pane,button);
        	hbox.setHgrow(pane, Priority.ALWAYS);
        }

		@Override
		public void updateItem(final String item, boolean empty) {
			super.updateItem(item, empty);
			setText(null);
			setGraphic(null);
			if (item != null && !empty) {
				label.setText(item);
				setGraphic(hbox);
			}

		}
               
        }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listViewListEducators.getItems().addAll(Main.listaVaspitaca);
		listViewListEducators.setCellFactory(param -> new Cell());
		listViewListChildren.getItems().addAll(Main.listaDjece);
		listViewListChildren.setCellFactory(param -> new Cell());
		
	
		
		

	}
	
	   @FXML
	   void btnBackWindowClick(ActionEvent event) {
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
	    void btnAddChildClick(ActionEvent event) {
try {
	    		
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AddChildInGroup.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();

			}catch(Exception ex) {
				
			}
	    }

	    @FXML
	    void btnAddEducatorClick(ActionEvent event) {
	    	try {
	    		
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEducatorInGroupWindow.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();

			}catch(Exception ex) {
				
			}
	    }

	    @FXML
	    void btnDeleteGroupClick(ActionEvent event) {
 
	    	//napraviti mini dialog da se pita da li ste sigurni da li zelite izbrisati grupu
	    }
	    
	    @FXML
	    void btnActivityClick(ActionEvent event) {

	    	   try {
					Pane pane = FXMLLoader.load	(getClass().getResource("GroupActivityWindow.fxml"));
					paneShowGroup.getChildren().setAll(pane);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
}

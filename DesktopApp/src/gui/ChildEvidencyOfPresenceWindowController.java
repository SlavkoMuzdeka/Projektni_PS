package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ChildEvidencyOfPresenceWindowController implements Initializable{


    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnSaveChanges;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblWindowName;

    @FXML
    private ListView<String> listViewChildEvidencyWindow;

    @FXML
    private GridPane paneHorizontal;
    
    @FXML
    private GridPane paneEvidencyOfPresence;
    
	static class Cell extends ListCell<String> {  
        HBox hbox = new HBox();
    	CheckBox cbox = new CheckBox();
    	 Label label = new Label("");
    	 Pane pane = new Pane();
    	 
    	 
        
        public Cell() {
        	super();
        	cbox.setStyle("-fx-background-color: #ffe6ff");
        	hbox.getChildren().addAll(label,pane,cbox);
        	hbox.setHgrow(pane, Priority.ALWAYS);
        }
        @Override  
        public void updateItem(final String item, boolean empty) {  
        	super.updateItem(item,empty);
        	setText(null);
        	setGraphic(null);
        	if(item != null && !empty) {
        		label.setText(item);
        		setGraphic(hbox);
        	}
       
    }
               
        }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		listViewChildEvidencyWindow.getItems().add("Dijete");
		listViewChildEvidencyWindow.setCellFactory(param -> new Cell());
		
	}
	
    @FXML
    void btnRefreshClick(ActionEvent event) {

    }

    @FXML
    void btnSaveChangesClick(ActionEvent event) {

    }

    @FXML
    void listCellClicked(MouseEvent event) {
    
		
		 if(listViewChildEvidencyWindow.getSelectionModel().getSelectedItem()!=null) {
	    	 try {
					Pane pane = FXMLLoader.load	(getClass().getResource("ShowChildEvidencyOfPresenceWindow.fxml"));
					paneEvidencyOfPresence.getChildren().setAll(pane);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }

    }


	
}

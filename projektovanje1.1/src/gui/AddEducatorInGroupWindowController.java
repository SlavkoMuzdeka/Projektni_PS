package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.ShowGroupWindowController.Cell;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class AddEducatorInGroupWindowController implements Initializable{


    @FXML
    private ListView<String> ListViewEducators;
    @FXML
    private Button btnAddEducators;

    @FXML
    private Pane paneHorizontalListChildren;

    @FXML
    void btnAddEducatorsClick(ActionEvent event) {

    }
	
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
		
    	ListViewEducators.getItems().addAll(Main.listaVaspitaca);
    	ListViewEducators.setCellFactory(param -> new Cell());
		
	}
}
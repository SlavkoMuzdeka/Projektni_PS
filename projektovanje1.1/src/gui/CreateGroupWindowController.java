package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gui.AddChildInGroupController.Cell;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class CreateGroupWindowController implements Initializable{

    @FXML
    private ComboBox<Integer> cmbBoxNumberOfGroupMembers;
    
    @FXML
    private ListView<String> listViewListChildren;

    @FXML
    private ListView<String> listViewListEducators;

    @FXML
    private Button btnCreateGroup;

    @FXML
    private TextField txtFieldGroupName;
    
  
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
		
		listViewListChildren.getItems().addAll(Main.listaDjece);
		listViewListChildren.setCellFactory(param -> new Cell());
		listViewListEducators.getItems().addAll(Main.listaVaspitaca);
		listViewListEducators.setCellFactory(param -> new Cell());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i<50;i++)
			list.add(i);
			
		cmbBoxNumberOfGroupMembers.getItems().addAll(list);
	}
    
	
    @FXML
    void btnCreateGroupClick(ActionEvent event) {
    	
    
    	
    }
    
}

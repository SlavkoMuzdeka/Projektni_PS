package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import model.Child;

public class AddChildInGroupController implements Initializable {

	private static ArrayList<Child> listChildrenAddingInGroup = new ArrayList<Child>();
    @FXML
    private Button btnAddChildren;

    @FXML
    private Pane paneHorizontal;

    @FXML
    private ListView<String> ListViewChildren;
	
    static class Cell extends ListCell<String> {  
        HBox hbox = new HBox();
    	CheckBox cbox = new CheckBox();
    	 Label label = new Label("");
    	 Pane pane = new Pane();
    	 
    	 
        
        public Cell() {
        	super();
        	cbox.setStyle("-fx-background-color: #ffe6ff");
        	cbox.setOnAction(e ->{
        		
        		if(cbox.isSelected()) {
        		
        			listChildrenAddingInGroup.add(new Child()); // Child child = getItem();
        			//ako je stavljena kvacica kupiti dijete
        		}else {
        			
        		}
        			});
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
  		
   
    	ListViewChildren.getItems().add("Dijete2");
    	ListViewChildren.getItems().add("Dijete3");

    	ListViewChildren.setCellFactory(param -> new Cell());
  		
  	}

    @FXML
    void btnAddChildrenClick(ActionEvent event) {

    	
    	//saljemo listu servisu
    	listChildrenAddingInGroup.removeAll(listChildrenAddingInGroup);//iz liste obrisemo sve dodano
    	
    	
    }
}


package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EducatorsWindowController implements Initializable{


    @FXML
    private AnchorPane paneEducators;

    @FXML
    private ListView<String> listViewEducatorsWindow;

    @FXML
    private Button btnAddEducator;

    @FXML
    private HBox hBoxHorizontalEducators;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblWindowName;

    @FXML
    private Pane paneHorizontal;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		listViewEducatorsWindow.getItems().addAll(Main.listaVaspitaca);
		
	}
    @FXML
    void btnAddEducatorClick(ActionEvent event) {
 
    	  try {
				Pane pane = FXMLLoader.load	(getClass().getResource("AddEducatorWindow.fxml"));
				paneEducators.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
    	
    }
    @FXML
    void listCellClicked(MouseEvent event) {
//	    System.out.println("clicked on " + event.getSource()+ "----------" + listViewEducatorsWindow.getSelectionModel().getSelectedItem()); //listViewEducatorsWindow.getSelectionModel().getSelectedItem() daje ime grupe
		    if(listViewEducatorsWindow.getSelectionModel().getSelectedItem()!=null) {
		    	 try {
						Pane pane = FXMLLoader.load	(getClass().getResource("ShowEducatorWindow.fxml"));
						paneEducators.getChildren().setAll(pane);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    }
    }
  
  
}

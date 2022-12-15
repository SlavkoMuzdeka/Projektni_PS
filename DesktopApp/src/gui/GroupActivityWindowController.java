package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Activity;



public class GroupActivityWindowController {
	
	   @FXML
	    private Button btnBackWindow;

	    @FXML
	    private Button btnAddActivity;

	    @FXML
	    private Button btnHome;

	    @FXML
	    private ComboBox<?> comboBoxPeriod;

	    @FXML
	    private DatePicker datePickerDateActivity;

	    @FXML
	    private Label lblGroupName;

	    @FXML
	    private Label lblLogo;

	    @FXML
	    private AnchorPane paneGroupActivity;

	    @FXML
	    private Pane paneHorizontal;

	    @FXML
	    private TableView<?> tableViewActivity;

	    @FXML
	    private TableColumn<?, ?> tableColumnDate;

	    @FXML
	    private TableColumn<?, ?> tableColumnNameAcitivity;

	    @FXML
	    private TableColumn<?, ?> tableColumnDescription;

	    @FXML
	    private TableColumn<?, ?> tableColumnPeriod;

	    @FXML
	    private TextArea textFieldDescriptionAcitivity;

	    @FXML
	    private TextField textFieldNameAcitivity;
	  
	    
	    @FXML
	    void btnAddActivityClick(ActionEvent event) {
	    
	    	//dodati uslov ako je nesto prazno da ne moze
	    	
	    	Activity a = new Activity();
	    	a.setName(textFieldNameAcitivity.getText());
	    	a.setDate(datePickerDateActivity.getValue());
	    	a.setDescription(textFieldDescriptionAcitivity.getText());
	    	
	    	//proslijediti servisu
	    	
	    }
	    
	 
	@FXML
	    void btnBackWindowClick(ActionEvent event) {

		 try {
			 
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowGroupWindow.fxml"));
				Parent root = loader.load();
				Stage s = (Stage) (((Node) event.getSource()).getScene().getWindow());
				s.getScene().setRoot(root);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	    }
	    @FXML
	    void btnHomeClick(ActionEvent event) {

			try {
				
				 FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
					Parent root = loader.load();
					Stage s = (Stage) (((Node) event.getSource()).getScene().getWindow());
					s.getScene().setRoot(root);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}

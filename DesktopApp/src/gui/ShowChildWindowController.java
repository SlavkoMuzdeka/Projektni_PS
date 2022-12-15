package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ShowChildWindowController {

    @FXML
    private Button btnSaveChanges;
    
    @FXML
    private Button btnEditChild;
    
    @FXML
    private TextArea txtAreaNote;

    @FXML
    private TextField txtFieldCity;

    @FXML
    private TextField txtFieldDateOfBirth;

    @FXML
    private TextField txtFieldFathersName;

    @FXML
    private TextField txtFieldFathersPhoneNumber;

    @FXML
    private TextField txtFieldHeight;

    @FXML
    private TextField txtFieldMothersName;

    @FXML
    private TextField txtFieldMothersPhoneNumber;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldNumber;

    @FXML
    private TextField txtFieldStreet;

    @FXML
    private TextField txtFieldSurname;

    @FXML
    private TextField txtFieldUID;

    @FXML
    private TextField txtFieldWeight;
    
    @FXML
    private Pane paneWithFields;

    @FXML
    void btnSaveChangesClick(ActionEvent event) {

    }
    
    @FXML
    void btnEditChildClick(ActionEvent event) {

    	txtAreaNote.setEditable(true);
    	txtFieldCity.setEditable(true);
    	txtFieldDateOfBirth.setEditable(true);
    	txtFieldFathersName.setEditable(true);
    	txtFieldFathersPhoneNumber.setEditable(true);
    	txtFieldHeight.setEditable(true);
    	txtFieldMothersName.setEditable(true);
    	txtFieldMothersPhoneNumber.setEditable(true);
    	txtFieldName.setEditable(true);
    	txtFieldNumber.setEditable(true);
    	txtFieldStreet.setEditable(true);
    	txtFieldSurname.setEditable(true);
    	txtFieldUID.setEditable(true);
    	txtFieldWeight.setEditable(true); 	
    }
}

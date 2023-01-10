package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Address;
import model.Child;
import model.Note;
import service.ChildService;

public class ShowChildWindowController implements Initializable {


	
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
    
    private String id;
    
    ChildService childService = ChildService.getInstance();

    @FXML
    void btnSaveChangesClick(ActionEvent event) {
    	
    	Child child = new Child();
    	child.setId(id);
		child.setName(txtFieldName.getText());
		child.setSurname(txtFieldSurname.getText());
		child.setUid(txtFieldUID.getText());
		child.setFatherName(txtFieldFathersName.getText());
		child.setMotherName(txtFieldMothersName.getText());
		child.setDateOfBirth(txtFieldDateOfBirth.getText());
		child.setFatherPhoneNumber(txtFieldFathersPhoneNumber.getText());
		child.setMotherPhoneNumber(txtFieldMothersPhoneNumber.getText());
		child.setHeight(txtFieldHeight.getText());
		child.setWeight(txtFieldWeight.getText());
		child.setAddress(new Address(txtFieldCity.getText(), txtFieldStreet.getText(), txtFieldNumber.getText()));
		child.setNote(new Note(txtAreaNote.getText()));
		
		
		childService.edit(child);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void setFields(Child child) {
		
		id = child.getId();
		txtFieldName.setText(child.getName());
		txtFieldSurname.setText(child.getSurname());
		txtFieldDateOfBirth.setText(child.getDateOfBirth());
		txtFieldFathersName.setText(child.getFatherName());
		txtFieldMothersName.setText(child.getMotherName());
		txtFieldMothersPhoneNumber.setText(child.getMotherPhoneNumber());
		txtFieldFathersPhoneNumber.setText(child.getFatherPhoneNumber());
		txtFieldHeight.setText(child.getHeight());
		txtFieldWeight.setText(child.getWeight());
		txtFieldUID.setText(child.getUid());
        txtFieldCity.setText(child.getAddress().getCity());
        txtFieldStreet.setText(child.getAddress().getStreet());
        txtFieldNumber.setText(child.getAddress().getNumber());
        txtAreaNote.setText(child.getNote().getDescription());
	}
}

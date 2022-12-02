package gui;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Address;
import model.Educator;
import service.EducatorService;
import javafx.scene.Node;

public class AddEducatorWindowController {
	
	
	 @FXML
	    private Button btnAddHygieneTest;

	    @FXML
	    private Button btnAddMedicalClearance;

	    @FXML
	    private Button btnCreateEducatorAccount;

	    @FXML
	    private DatePicker datePickerDateOfBirth;

	    @FXML
	    private Label lblLogo;

	    @FXML
	    private Label lblWindowName;

	    @FXML
	    private Pane paneHorizontal;

	    @FXML
	    private TextField textFieldNumber;

	    @FXML
	    private TextField textFieldCity;

	    @FXML
	    private TextField textFieldName;

	    @FXML
	    private TextField textFieldUID;

	    @FXML
	    private TextField textFieldSurname;

	    @FXML
	    private TextField textFieldStreet;

	@FXML
	void btnCreateEducatorAccountClick(ActionEvent event) {
		
		if(textFieldName.getText() != null && textFieldSurname.getText() != null && textFieldUID.getText() != null && datePickerDateOfBirth.getValue() != null && 
				textFieldCity.getText() != null && textFieldStreet.getText() != null && textFieldNumber.getText() != null && textFieldUID.getText().length()!= 13) {
			
			Educator educator= new Educator();
			educator.setName(textFieldName.getText());
			educator.setSurname(textFieldSurname.getText());
			educator.setUid(textFieldUID.getText());
			educator.setDateOfBirth(datePickerDateOfBirth.getValue().toString());
			Address address = new Address( textFieldCity.getText(),textFieldStreet.getText(), textFieldNumber.getText());
			educator.setAddress(address);
			
			//ljekarsko i higijensko (i u if njih ako treba)
			EducatorService educatorService = EducatorService.getInstance();
			educatorService.addOne(educator);
		}else {
			//prozorcic da nije moguce kreirati vaspitaca
		}

	}

	@FXML
	void btnAddHygieneTestClick(ActionEvent event) {
		Stage stage = new Stage();
		FileChooser file = new FileChooser();
		file.setTitle("Open File");
		file.showOpenDialog(stage);
	}

	@FXML
	void btnAddMedicalClearanceClick(ActionEvent event) {
		Stage stage = new Stage();
		FileChooser file = new FileChooser();
		file.setTitle("Open File");
		file.showOpenDialog(stage);
	}

}

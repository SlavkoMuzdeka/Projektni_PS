package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Address;
import model.Child;
import model.Note;
import service.ChildService;

public class AddChildWindowController {

    @FXML
    private Button btnAddMedicalClearance;

    @FXML
    private Button btnCreateChildAccount;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private HBox hBoxHorizontalEducators;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblWindowName;

    @FXML
    private Pane paneHorizontal;

    @FXML
    private TextArea textAreaRemark;

    @FXML
    private TextField textFieldNumber;

    @FXML
    private TextField textFieldMotherPhoneNumber;

    @FXML
    private TextField textFieldFatherPhoneNumber;

    @FXML
    private TextField textFieldCity;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldMotherName;

    @FXML
    private TextField textFieldFatherName;

    @FXML
    private TextField textFieldUID;

    @FXML
    private TextField textFieldSurname;

    @FXML
    private TextField textFieldWeight;

    @FXML
    private TextField textFieldStreet;

    @FXML
    private TextField textFieldHeight;
	
	@FXML
	void btnAddMedicalClearanceClick(ActionEvent event) {
		Stage stage = new Stage();
		FileChooser file = new FileChooser();
		file.setTitle("Open File");
		file.showOpenDialog(stage);
	}
	
	@FXML
	void btnCreateChildAccountClick(ActionEvent event) {
		if(textFieldName.getText() != null && textFieldSurname.getText() != null && textFieldUID.getText() != null && textFieldFatherName.getText() != null &&
				textFieldMotherName.getText() != null && dateOfBirth.getValue() != null && textFieldFatherPhoneNumber.getText() != null &&
				textFieldMotherPhoneNumber.getText() != null && textFieldHeight.getText() != null && textFieldWeight.getText() != null
				&& textFieldCity.getText() != null && textFieldStreet.getText() != null && textFieldNumber.getText() != null) {
			
			Child child = new Child();
			child.setName(textFieldName.getText());
			child.setSurname(textFieldSurname.getText());
			child.setUid(textFieldUID.getText());
			child.setFatherName(textFieldFatherName.getText());
			child.setMotherName(textFieldMotherName.getText());
			child.setDateOfBirth(dateOfBirth.getValue().toString());
			child.setFatherPhoneNumber(textFieldFatherPhoneNumber.getText());
			child.setMotherPhoneNumber(textFieldMotherPhoneNumber.getText());
			child.setHeight(textFieldHeight.getText());
			child.setWeight(textFieldWeight.getText());
			child.setAddress(new Address(textFieldCity.getText(), textFieldStreet.getText(), textFieldNumber.getText()));
			child.setNote(new Note(textAreaRemark.getText()));
			
			//pozivamo metodu iz service
			ChildService.addChild(child);
			clearFields();
		}else {
			showAlert();
		}
	}
	
	/**
	 *  Pomocna funkcija koja prikazuje dijalog da vrijednost svih polja moraju biti popunjenja
	 *  da bi se nalog djeteta mogao kreirati
	 */
	private void showAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Pokušajte ponovo");
		alert.setHeaderText(null);
		alert.setContentText("Sva polja moraju biti popunjena.");
		alert.show();
	}
	
	/**
	 * Pomocna funckija koja resetuje vrijednost svih polja u slucaju da je nalog djeteta uspjesno kreiran
	 */
	private void clearFields() {
		textFieldName.setText("");
		textFieldSurname.setText("");
		textFieldUID.setText("");
		textFieldFatherName.setText("");
		textFieldMotherName.setText("");
		textFieldCity.setText("");
		textFieldStreet.setText("");
		textFieldNumber.setText("");
		textFieldFatherPhoneNumber.setText("");
		textFieldMotherPhoneNumber.setText("");
		textFieldHeight.setText("");
		textFieldWeight.setText("");
	}
	
}

package gui;

import java.io.*;
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
import model.MedicalClearance;
import model.Note;
import service.ChildService;

public class AddChildWindowController {

    @FXML private Button btnAddMedicalClearance;

    @FXML private Button btnCreateChildAccount;

    @FXML private DatePicker dateOfBirth;

    @FXML private HBox hBoxHorizontalEducators;

    @FXML private Label lblLogo;

    @FXML private Label lblWindowName;

    @FXML private Pane paneHorizontal;

    @FXML private TextArea textAreaRemark;

    @FXML private TextField textFieldNumber;

    @FXML private TextField textFieldMotherPhoneNumber;

    @FXML private TextField textFieldFatherPhoneNumber;

    @FXML private TextField textFieldCity;

    @FXML private TextField textFieldName;

    @FXML private TextField textFieldMotherName;

    @FXML private TextField textFieldFatherName;

    @FXML private TextField textFieldUID;

    @FXML private TextField textFieldSurname;

    @FXML private TextField textFieldWeight;

    @FXML private TextField textFieldStreet;

    @FXML private TextField textFieldHeight;
    
    private byte[] data;//Promjenljiva koja cuva bajte dokumenta ljekarskog uvjerenja
    
    private ChildService childServiceInstance;
	
	@FXML
	void btnAddMedicalClearanceClick(ActionEvent event) {
		Stage stage = new Stage();
		FileChooser fc = new FileChooser();
		fc.setTitle("Open File");
		File file = fc.showOpenDialog(stage);
		if(!file.getName().endsWith(".pdf")) {
			showAlert(AlertType.ERROR, "Poku�ajte ponovo", "Dokument ljekarskog uvjerenja mora biti sa ekstenzijom .pdfg");
		}else {
			try {
				InputStream is = new FileInputStream(file);
				data = new byte[(int)file.length()];
				is.read(data);
				is.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
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
			
			if(data == null) {
				showAlert(AlertType.ERROR, "Poku�ajte ponovo", "Niste unijeli ljekarsko uvjerenje.");
			}else {
				
				MedicalClearance medicalClearance = new MedicalClearance();
				medicalClearance.setFile(data);
				child.setMedicalClearance(medicalClearance);
				childServiceInstance = ChildService.getInstance();
				childServiceInstance.addOne(child);
				clearFields();
			}
		}else {
			showAlert(AlertType.ERROR, "Poku�ajte ponovo", "Sva polja moraju biti popunjena.");
		}
	}
	
	/**
	 *  Pomocna funkcija koja prikazuje dijalog da vrijednost svih polja moraju biti popunjenja
	 *  da bi se nalog djeteta mogao kreirati
	 */
	public void showAlert(Alert.AlertType alertType, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
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
package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
    private byte[] data;
    
    private ChildService childServiceInstance;
	
	@FXML
	void btnAddMedicalClearanceClick(ActionEvent event) {
		Stage stage = new Stage();
		FileChooser fc = new FileChooser();
		fc.setTitle("Open File");
		
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fc.getExtensionFilters().add(extFilter);
        File file = fc.showOpenDialog(stage);

	
			try {
				InputStream is = new FileInputStream(file);
				data = new byte[(int)file.length()];
				is.read(data);
				is.close();
			}catch(Exception ex) {
				ex.printStackTrace();
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
			//pozivamo metodu iz service
	//		ChildService.addChild(child);
			
			if(data == null) {
				CustomizedAlert ca = new CustomizedAlert(AlertType.WARNING,"Niste unijeli ljekarsko uvjerenje","");
			ca.show();
			}else {
				
				MedicalClearance medicalClearance = new MedicalClearance();
				medicalClearance.setFile(data);
				child.setMedicalClearance(medicalClearance);
				childServiceInstance = ChildService.getInstance();
				childServiceInstance.addOne(child);
				clearFields();
			}
		}else {
			
			CustomizedAlert ca = new CustomizedAlert(AlertType.WARNING,"Nije moguće kreiranje, neko od polja nije pravilno popunjeno","Nije moguće kreiranje");
			ca.show();
			
			System.out.println("Nije moguce kreiranje");
			//kreirati funkciju koja ce prikazivati dijalog da dijete nije moguce kreirati
		}
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

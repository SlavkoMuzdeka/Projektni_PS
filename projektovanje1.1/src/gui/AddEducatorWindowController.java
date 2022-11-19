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

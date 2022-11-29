package gui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddChildWindowController {

    @FXML
    private Button btnAddMedicalClearance;

    @FXML
    private Button btnCreateChildAccount;

    @FXML
    private DatePicker DateOfBirth;

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
		 
		
	}
	
}
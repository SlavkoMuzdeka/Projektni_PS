package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Child;
import model.Educator;

public class ShowEducatorWindowController implements Initializable {

	  @FXML
	    private ImageView ProfilePicture;

	    @FXML
	    private HBox hBoxHorizontalEducators;
	 
	    @FXML
	    private Label lblLogo;

	    @FXML
	    private DatePicker dateOfBirth;

	    @FXML
	    private Pane paneHorizontal;
	    
	    @FXML
	    private TextField txtFieldCity;

	    @FXML
	    private TextField txtFieldNameAndSurname;

	    @FXML
	    private TextField txtFieldNumber;

	    @FXML
	    private TextField txtFieldStreet;

	    @FXML
	    private TextField txtFieldUID;
	    
	    private String id;
	    
		public void setFields(Educator educator) {
			
			id = educator.getId();
			txtFieldNameAndSurname.setText(educator.getName() + " " + educator.getSurname());
		//	dateOfBirth.setValue((LocalDate)(educator.getDateOfBirth()));  ovo ne moze
			txtFieldUID.setText(educator.getUid());
	        txtFieldCity.setText(educator.getAddress().getCity());
	        txtFieldStreet.setText(educator.getAddress().getStreet());
	        txtFieldNumber.setText(educator.getAddress().getNumber());
		}


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
	    
	
}

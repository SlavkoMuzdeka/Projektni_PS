package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Account;
import model.Person;

public class ShowAccountWindowController implements Initializable{

	
    @FXML
    private ImageView ProfilePicture;

    @FXML
    private HBox hBoxHorizontalEducators;

    @FXML
    private Label lblNumber;

    @FXML
    private Label lblDateOfBirth;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblNameAndSurname;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblStreet;

    @FXML
    private Label lblWindowName;

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
    private TextField txtFieldUserName;
    
    @FXML
    private DatePicker dateOfBirth;

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    
	public void setFields(Account account) {
		
		txtFieldNameAndSurname.setText(account.getName() + " " + account.getSurname());
		txtFieldUserName.setText(account.getUsername());
		txtFieldCity.setText(account.getAddress().getCity());
		txtFieldStreet.setText(account.getAddress().getStreet());
		txtFieldNumber.setText(account.getAddress().getNumber());
		
	}
    
	
}

package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Account;
import model.Administrator;
import model.Educator;
import service.LogInService;

public class LogInWindowController {


	
    @FXML
    private AnchorPane pane;

    @FXML
    private Button btnLogIn;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField txtFieldUserName;

   

    @FXML
    void btnLogInClick(ActionEvent event) {

    	LogInService logInService = LogInService.getInstance();
   // 	Object object =logInService.checkCredentials(txtFieldUserName.getText(), passwordField.getText());
    	
//    	if (object instanceof Account) {
   		
 //   		Account account = (Account)object;
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml")); 
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
			Stage stage = new Stage();
			stage.setMinWidth(1400);
			stage.setScene(scene);
			stage.getIcons().add(new Image("./icons/icon.png"));
			stage.setTitle("e-Vrtic");
			
//			if(!account.isAdministrator()) {
	    		MainWindowController controller = loader.getController();
	    		controller.setButtonsToFalse();
//			}	
			stage.show();
			Stage s = (Stage)(((Node) event.getSource()).getScene().getWindow());
			s.close();

		}catch(Exception ex) {
			
		}
    	
 //   }else {
    	//neuspjesna prijava
   // }
    	
    }
}

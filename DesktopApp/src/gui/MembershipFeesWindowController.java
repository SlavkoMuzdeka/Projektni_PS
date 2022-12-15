package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MembershipFeesWindowController {

	   @FXML
	    private AnchorPane PaneFinance;

	   
	    @FXML
	    private Button btnRefresh;

	    @FXML
	    private Button btnSearchChild;
	    @FXML
	    private HBox hBoxHorizontalEducators;

	    @FXML
	    private Label lblLogo;

	    @FXML
	    private Label lblWindowName;

	    @FXML
	    private Pane paneHorizontal;

	    @FXML
	    private TableColumn<?, ?> tableColumnDate;

	    @FXML
	    private TableColumn<?, ?> tableColumnName;

	    @FXML
	    private TableColumn<?, ?> tableColumnAmount;

	    @FXML
	    private TableColumn<?, ?> tableColumnMonth;

	    @FXML
	    private TableColumn<?, ?> tableColumnPaid;

	    @FXML
	    private TableColumn<?, ?> tableColumnSurname;
	    
	    @FXML
	    private TableColumn<?, ?> tableColumnService;

	    @FXML
	    private TableView<?> tableViewDebts;
	    

	    @FXML
	    private TextField txtFieldSearch;
	    
	    @FXML
	    void btnRefreshClick(ActionEvent event) {

	    }

	    @FXML
	    void btnSearchChildClick(ActionEvent event) {

	    	String search = txtFieldSearch.getText(); // poslati servisu da trazi i na klik butttona prikazati pronadjene
	    	
	    }
	
}

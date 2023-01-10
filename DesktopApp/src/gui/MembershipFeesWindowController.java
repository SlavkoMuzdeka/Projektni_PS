package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Bill;
import model.Child;
import model.Membership;
import service.MembershipFeesService;
import service.MonthlyExpensesService;

public class MembershipFeesWindowController implements Initializable {

		private MembershipFeesService membershipFeesService = MembershipFeesService.getInstance();
	
		private ObservableList<Membership> memberships= FXCollections.observableArrayList();
		
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
	    private TableColumn<Membership, String> tableColumnDate;

	    @FXML
	    private TableColumn<Membership, Child> tableColumnName;

	    @FXML
	    private TableColumn<Membership, String> tableColumnAmount;

	    @FXML
	    private TableColumn<Membership, String> tableColumnMonth;

	    @FXML
	    private TableColumn<Membership, String> tableColumnPaid;

	    @FXML
	    private TableColumn<Membership, String> tableColumnSurname;
	    
	    @FXML
	    private TableColumn<Membership, String> tableColumnService;

	    @FXML
	    private TableView<Membership> tableViewDebts;
	    

	    @FXML
	    private TextField txtFieldSearch;
	    
	    @FXML
	    void btnRefreshClick(ActionEvent event) {

	    }

	    @FXML
	    void btnSearchChildClick(ActionEvent event) {

	    	String search = txtFieldSearch.getText(); // poslati servisu da trazi i na klik butttona prikazati pronadjene
	    	
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			//memberships.addAll((ArrayList<Membership>) membershipFeesService.getAll(""));
			Membership membership= new Membership();
			membership.setAmount(2);
			membership.setPaid(false);
			membership.setPaymentDate("12.12.2003");
			Child ch= new Child(); ch.setName("Janko"); ch.setSurname("Jankovic");
			membership.setChild(ch);
			memberships.add(membership);
			
			tableColumnName.setCellValueFactory(new PropertyValueFactory<Membership,Child>("child"));
			tableColumnService.setCellValueFactory(new PropertyValueFactory<Membership, String>("serviceType"));
			tableColumnPaid.setCellValueFactory(new PropertyValueFactory<Membership, String>("paid"));
			tableColumnAmount.setCellValueFactory(new PropertyValueFactory<Membership, String>("amount"));
			tableColumnDate.setCellValueFactory(new PropertyValueFactory<Membership, String>("paymentDate"));
			tableViewDebts.setItems(memberships);
		}
	
}

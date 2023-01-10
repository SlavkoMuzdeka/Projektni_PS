package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Bill;
import service.MonthlyExpensesService;

public class MonthlyExpensesWindowController implements Initializable {

	private MonthlyExpensesService monthlyExpensesService = MonthlyExpensesService.getInstance();
	
	private ObservableList<Bill> bills= FXCollections.observableArrayList();

    @FXML
    private AnchorPane PaneFinance;

    @FXML
    private ComboBox<String> comboBoxPaid;

    @FXML
    private DatePicker datePickerDateBill;
    
    @FXML
    private Button btnAddBill;

    @FXML
    private HBox hBoxHorizontalEducators;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblWindowName;

    @FXML
    private Pane paneHorizontal;

    @FXML
    private TableColumn<Bill, String> tableColumnBillNumber;

    @FXML
    private TableColumn<Bill, String> tableColumnDate;

    @FXML
    private TableColumn<Bill, String> tableColumnAmount;

    @FXML
    private TableColumn<Bill, String> tableColumnPaid;

    @FXML
    private TableColumn<Bill, String> tableColumnBillType;

    @FXML
    private TableView<Bill> tableViewBills;

    @FXML
    private TextField textFieldAmountType;

    @FXML
    private TextField textFieldBillType;
      
    @FXML
    void btnAddBillClick(MouseEvent event) {
    	
    	Bill bill = new Bill();
    	bill.setBillType(textFieldBillType.getText());
    	bill.setAmount(Integer.valueOf(textFieldAmountType.getText()));
    	bill.setDate(datePickerDateBill.getValue().toString());
    	bill.setPaid(Boolean.valueOf(comboBoxPaid.getValue()));
    	
    	//monthlyExpensesService.addOne(bill);
    	
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//bills.addAll( (ArrayList<Bill>)monthlyExpensesService.getAll(""));
		
		Bill bill1 = new Bill();
		bill1.setBillNumber("1");
		bill1.setBillType("tt1");
		bill1.setAmount(3);
		bill1.setDate("12.12.2012");
		bill1.setPaid(true);
		bills.add(bill1);
		Bill bill2 = new Bill();
		bill2.setBillNumber("1");
		bill2.setBillType("tt1");
		bill2.setAmount(3);
		bill2.setDate("12.12.2012");
		bill2.setPaid(true);
		bills.add(bill2);
		tableColumnBillNumber.setCellValueFactory( new PropertyValueFactory<Bill, String>("billNumber"));
		tableColumnBillType.setCellValueFactory( new PropertyValueFactory<Bill, String>("billType"));
		tableColumnAmount.setCellValueFactory( new PropertyValueFactory<Bill, String>("amount"));
		tableColumnDate.setCellValueFactory(new PropertyValueFactory<Bill,String>("date"));
		tableColumnPaid.setCellValueFactory(new PropertyValueFactory<Bill, String>("paid"));
		tableViewBills.setItems(bills);
		
		
	}
	


}

package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MonthlyExpensesWindowController {


    @FXML
    private AnchorPane PaneFinance;

    @FXML
    private ComboBox<?> comboBoxPaid;

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
    private TableColumn<?, ?> tableColumnBillNumber;

    @FXML
    private TableColumn<?, ?> tableColumnDate;

    @FXML
    private TableColumn<?, ?> tableColumnAmount;

    @FXML
    private TableColumn<?, ?> tableColumnPaid;

    @FXML
    private TableColumn<?, ?> tableColumnBillType;

    @FXML
    private TableView<?> tableViewBills;

    @FXML
    private TextField textFieldAmountType;

    @FXML
    private TextField textFieldBillType;
      
    @FXML
    void btnAddBillClick(MouseEvent event) {
    	
    }

}

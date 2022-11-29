package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MembershipFeesWindowController {

	   @FXML
	    private AnchorPane PaneFinance;

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
	    private TableView<?> tableViewDebts;
	
}

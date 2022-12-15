package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FinanceWindowController implements Initializable {

	ArrayList<String> listButtons = new ArrayList<String>();
	

	
    @FXML
    private GridPane PaneFinance;

	@FXML
	private ListView<String> listViewFinance;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		listButtons.add("Evidencija o mjesečnim troškovima");
		listButtons.add("Pregled dugovanja za svu djecu");
		listViewFinance.getItems().addAll(listButtons);

	}

	@FXML
	void listViewFinanceClick(MouseEvent event) {
		System.out.println(listViewFinance.getSelectionModel().getSelectedItem());
		if (listViewFinance.getSelectionModel().getSelectedItem().toString()
				.equals("Evidencija o mjesečnim troškovima")) {
			
		
			try {
				GridPane pane = FXMLLoader.load(getClass().getResource("MonthlyExpensesWindow.fxml"));
				PaneFinance.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
			
		} else if (listViewFinance.getSelectionModel().getSelectedItem().toString()
				.equals("Pregled dugovanja za svu djecu")) {
			System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
			

			try {
				GridPane pane = FXMLLoader.load(getClass().getResource("MembershipFeesWindow.fxml"));
				PaneFinance.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	}
}

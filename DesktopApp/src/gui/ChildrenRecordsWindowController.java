package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import model.Child;
import service.ChildService;

public class ChildrenRecordsWindowController implements Initializable {

	private ArrayList<Child> childrenList = new ArrayList<Child>();
	private static ChildService chdService = ChildService.getInstance();

	@FXML
	private GridPane paneChildrenRecords;

	@FXML
	private HBox hBoxHorizontalEducators;

	@FXML
	private Label lblLogo;

	@FXML
	private Label lblWindowName;

	@FXML
	private Pane paneHorizontal;

	@FXML
	private Button btnSearchChild;

	@FXML
	private Button btnRefresh;

	@FXML
	private Button btnAddChild;

	@FXML
	private ListView<Child> listViewChildrenRecordsWindow; // prepraviti da je genericki tip Child

	@FXML
	private TextField txtFieldSearchChild;

	static class Cell extends ListCell<Child> {
		HBox hbox = new HBox();
		Button button = new Button("Ukloni");
		Label label = new Label("");
		Pane pane = new Pane();

		public Cell() {
			super();
			button.setStyle("-fx-background-color: #ffe6ff");
			button.setOnAction(event -> {

				CustomizedAlert ca = new CustomizedAlert(AlertType.CONFIRMATION, "",
						"Da li ste sigurni da želite obrisati dijete?");
			
				Optional<ButtonType> option = ca.showAndWait();
				if (option.get() == ButtonType.YES) {

					Child child = getItem();
					chdService.delete(child.getId());
				}

				System.out.println(getItem());

			});
			hbox.getChildren().addAll(label, pane, button);
			hbox.setHgrow(pane, Priority.ALWAYS);
		}

		@Override
		public void updateItem(final Child item, boolean empty) {
			super.updateItem(item, empty);
			setText(null);
			setGraphic(null);
			if (item != null && !empty) {
				label.setText(item.getName() + " " + item.getSurname());
				setGraphic(hbox);
			}

		}

	}

	@FXML
	void btnSearchChildClick(ActionEvent event) {

		String searchField = txtFieldSearchChild.getText();// ovo ubaciti u metodu za pretragu a an klik buttona da se
															// prikazu dejca sa tim imenom ili prezimenom

	}

	@FXML
	void listCellClicked(MouseEvent event) {
		if (listViewChildrenRecordsWindow.getSelectionModel().getSelectedItem() != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowChildWindow.fxml"));
				Pane pane = loader.load();
				ShowChildWindowController controller = loader.getController();
				controller.setFields(listViewChildrenRecordsWindow.getSelectionModel().getSelectedItem());
				
				paneChildrenRecords.getChildren().setAll(pane);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	void btnRefreshClick(ActionEvent event) {
		//vidjeti da li ce se imati potrebe za ovim
	}

	@FXML
	void btnAddChildClick(ActionEvent event) {

		try {
			Pane pane = FXMLLoader.load(getClass().getResource("AddChildWindow.fxml"));
			paneChildrenRecords.getChildren().setAll(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		listViewChildrenRecordsWindow.setCellFactory(param -> new Cell());
		childrenList.addAll((ArrayList<Child>) chdService.getAll(""));
		listViewChildrenRecordsWindow.getItems().addAll(childrenList);
		// dodati da pomocu metode iz servisa dobijem svu djecu i ubacim u listu
		/*
		 * for(int i = 0; i<20;i++) { listViewChildrenRecordsWindow.getItems().add(new
		 * Child());
		 * 
		 * }
		 */

	}

}

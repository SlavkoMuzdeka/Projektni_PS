package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import model.Child;
import model.Educator;
import javafx.scene.Node;

public class ShowGroupWindowController implements Initializable {

	@FXML
	private AnchorPane paneShowGroup;

	Button btnShow = new Button("PrikaЕѕi");
	Button btnDelete = new Button("ObriЕЎi");
	@FXML
	private ListView<Educator> listViewListEducators;
	@FXML
	private ListView<Child> listViewListChildren;

    @FXML
    private TextField txtFieldSearchMember;
	@FXML
	private Button btnActivity;

	@FXML
	private Button btnBackWindow;

	@FXML
	private Button btnAddChild;

	@FXML
	private AnchorPane btnAddChildToGroup;

	@FXML
	private Button btnAddEducator;

	@FXML
	private Button btnDeleteGroup;
	
    @FXML
    private Button btnSearchMember;

    @FXML
    private Button btnSaveChanges;

	@FXML
	private Label lblNumberOfGroupMembers;

	@FXML
	private Label lblGroupName;

	@FXML
	private Label lblLogo;

	@FXML
	private Pane paneHorizontal;

	static class CellEducator extends ListCell<Educator> {
		HBox hbox = new HBox();
		Button button = new Button("Ukloni iz grupe");
		Label label = new Label("");
		Pane pane = new Pane();

		public CellEducator() {
			super();
			button.setStyle("-fx-background-color: #ffe6ff");
			button.setOnAction(event -> {
				

				CustomizedAlert ca = new CustomizedAlert(AlertType.CONFIRMATION, "",
						"Da li ste sigurni da želite obrisati vaspitača?");
				ca.show();
				Optional<ButtonType> option = ca.showAndWait();
				if (option.get() == ButtonType.YES) {

					Educator educator = getItem();
					// pozvati metodu za brisanje
				}
		
				System.out.println(getItem());

			});
			hbox.getChildren().addAll(label, pane, button);
			hbox.setHgrow(pane, Priority.ALWAYS);

		}

		@Override
		public void updateItem(final Educator item, boolean empty) {
			super.updateItem(item, empty);
			setText(null);
			setGraphic(null);
			if (item != null && !empty) {
				label.setText(item.getName() + " " + item.getName());
				setGraphic(hbox);
			}

		}

	}

	static class CellChild extends ListCell<Child> {
		HBox hbox = new HBox();
		Button button = new Button("Ukloni iz grupe");
		Label label = new Label("");
		Pane pane = new Pane();

		public CellChild() {
			super();
			button.setStyle("-fx-background-color: #ffe6ff");
			button.setOnAction(event -> {


				CustomizedAlert ca = new CustomizedAlert(AlertType.CONFIRMATION, "",
						"Da li ste sigurni da želite obrisati dijete?");
				ca.show();
				Optional<ButtonType> option = ca.showAndWait();
				if (option.get() == ButtonType.YES) {

					Child child = getItem();
					// pozvati metodu za brisanje
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
				label.setText(item.getName() + " " + item.getName());
				setGraphic(hbox);
			}

		}

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		listViewListEducators.getItems().addAll(Main.listaVaspitaca);
		listViewListEducators.setCellFactory(param -> new CellEducator());
//		listViewListChildren.getItems().addAll(Main.listaDjece);
		listViewListChildren.setCellFactory(param -> new CellChild());

	}

	@FXML
	void btnBackWindowClick(ActionEvent event) {
		try {
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
				Parent root = loader.load();
				Stage s = (Stage) (((Node) event.getSource()).getScene().getWindow());
				s.getScene().setRoot(root);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void btnAddChildClick(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddChildInGroup.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		} catch (Exception ex) {

		}
	}

	@FXML
	void btnAddEducatorClick(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEducatorInGroupWindow.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();

		} catch (Exception ex) {

		}
	}

	@FXML
	void btnActivityClick(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupActivityWindow.fxml"));
			Parent root = loader.load();
			Stage s = (Stage) (((Node) event.getSource()).getScene().getWindow());
			s.getScene().setRoot(root);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
    @FXML
    void btnSearchMemberClick(ActionEvent event) {

    }
    

    @FXML
    void btnSaveChangesClick(ActionEvent event) {

    }
}

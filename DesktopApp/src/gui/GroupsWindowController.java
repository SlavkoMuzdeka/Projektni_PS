package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import model.Child;
import model.Group;
import service.GroupService;

public class GroupsWindowController implements Initializable {

	private ArrayList<Group> groups = new ArrayList<>();
	private static GroupService groupService = GroupService.getInstance();
	
	@FXML
	private GridPane GridPaneGroups;

	@FXML
	private Button btnAddGroup;

	@FXML
	private Label labelWindowName;
	
    @FXML
    private Button btnRefresh;

	@FXML
	private ListView<Group> listViewGroups;

	@FXML
	private GridPane paneHorizontal;
	
    static class Cell extends ListCell<Group> {  
        HBox hbox = new HBox();
    	 Button button = new Button("Ukloni");
    	 Label label = new Label("");
    	 Pane pane = new Pane();
    	 
    	 
        
        public Cell() {
        	super();
        	button.setStyle("-fx-background-color: #ffe6ff");
        	button.setOnAction(event -> {
        		
        		CustomizedAlert ca = new CustomizedAlert(AlertType.CONFIRMATION,  "Da li ste sigurni da Å¾elite ukloniti grupu?","Uklanjanje Ä�lana");
				
				 Optional<ButtonType> option = ca.showAndWait();
		    	 if(option.get() ==  ButtonType.YES) {
		 
		    		 Group group = getItem();
		    		 groupService.delete(group.getId());
		    	 }
        		
				System.out.println(getItem());

			});
        	hbox.getChildren().addAll(label,pane,button);
        	hbox.setHgrow(pane, Priority.ALWAYS);
        	
        }

		@Override
		public void updateItem(final Group item, boolean empty) {
			super.updateItem(item, empty);
			setText(null);
			setGraphic(null);
			if (item != null && !empty) {
				label.setText(item.getName());
				setGraphic(hbox);
			}

		}
               
        }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		listViewGroups.setCellFactory(param -> new Cell());
		//groups.addAll( (ArrayList<Group>)groupService.getAll(""));
		Group grupa = new Group();
		grupa.setName("grupa1");
		groups.add(grupa);
		listViewGroups.getItems().addAll(groups);
		//listViewGroups.getItems().add("Grupa");

	}

	@FXML
	void btnAddGroupClick(ActionEvent event) {
		
		
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateGroupWindow.fxml")); 
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void handleMouseClick(MouseEvent event) {

		if (listViewGroups.getSelectionModel().getSelectedItem() != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowGroupWindow.fxml"));
				Parent root = loader.load();
				Stage s = (Stage) (((Node) event.getSource()).getScene().getWindow());
				s.getScene().setRoot(root);
			} catch (IOException e) {
				
				e.printStackTrace();
			}

		}

	}

    @FXML
    void btnRefreshClick(ActionEvent event) {

    }


}

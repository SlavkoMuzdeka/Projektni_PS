package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import model.ArrivalAndDeparatureTime;
import model.Child;
import service.ArrivalAndDepartureTimeService;
import service.ChildService;
import service.ChildrenRecordsService;

public class ChildEvidencyOfPresenceWindowController implements Initializable{

	private ArrayList<Child> childrenList = new ArrayList<Child>();
	private static ChildrenRecordsService chdService = ChildrenRecordsService.getInstance();
	
    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnSaveChanges;

    @FXML
    private Label lblLogo;

    @FXML
    private Label lblWindowName;

    @FXML
    private ListView<Child> listViewChildEvidencyWindow;

    @FXML
    private GridPane paneHorizontal;
    
    @FXML
    private GridPane paneEvidencyOfPresence;
    
    
	static class Cell extends ListCell<Child> {  
        HBox hbox = new HBox();
    	CheckBox cbox = new CheckBox();
    	 Label label = new Label("");
    	 Pane pane = new Pane();
    	 
    	 
        
        public Cell() {
        	super();
        	cbox.setStyle("-fx-background-color: #ffe6ff");
        	cbox.setOnAction(e-> {
        		if(cbox.isSelected()) {
        			getItem().setIsHere(true);
        		} else {
        			getItem().setIsHere(false);
        		}
        	});
        	hbox.getChildren().addAll(label,pane,cbox);
        	hbox.setHgrow(pane, Priority.ALWAYS);
        }
        @Override  
        public void updateItem(final Child item, boolean empty) {  
        	super.updateItem(item,empty);
        	setText(null);
        	setGraphic(null);
        	if(item != null && !empty) {
        		if(item.getIsHere()) {
        			cbox.setSelected(true);
        		}
        		label.setText(item.getName() + " " + item.getSurname());
        		setGraphic(hbox);
        	}
        	
        	
    }
               
        }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//listViewChildEvidencyWindow.getItems().add("Dijete");
		listViewChildEvidencyWindow.setCellFactory(param -> new Cell());
		Child child1 = new Child();
		child1.setName("Marko");
		child1.setSurname("Markovic");
		Child child2 = new Child();
		child2.setName("Janko");
		child2.setSurname("Markovic");
		child1.setIsHere(true);
		Child child3 = new Child();
		child3.setName("Ranko");
		child3.setSurname("Markovic");
		child3.setIsHere(true);
		child2.setIsHere(false);
		childrenList.add(child3);
		childrenList.add(child2);
		childrenList.add(child1);
		//listViewChildEvidencyWindow.getItems().add(child1);
		//listViewChildEvidencyWindow.setCellFactory(param -> new Cell());
		//childrenList.addAll((ArrayList<Child>) chdService.getAll(""));
		
		for(Child child:childrenList) {
			
			listViewChildEvidencyWindow.getItems().add(child);
			
		}
		//listViewChildEvidencyWindow.getItems().addAll(childrenList);
		
	}
	
    @FXML
    void btnRefreshClick(ActionEvent event) {

    }

    @FXML
    void btnSaveChangesClick(ActionEvent event) {
    	
     //	chdService.addAll(childrenList);
    	
    		for(Child child: childrenList) {
    			System.out.println(child.getName() + child.getIsHere());
    		}
    	
    }

    @FXML
    void listCellClicked(MouseEvent event) {
    
		
		 if(listViewChildEvidencyWindow.getSelectionModel().getSelectedItem()!=null) {
	    	 try {
	    		 	//ArrivalAndDepartureTimeService service = ArrivalAndDepartureTimeService.getInstance();
	    		 	//ArrayList<ArrivalAndDeparatureTime> times= service.getArrivalAndDepartureTime(listViewChildEvidencyWindow.getSelectionModel().getSelectedItem().getId());
				
	    		 	ArrayList<ArrivalAndDeparatureTime> times = new ArrayList<>();
	    		 	ArrivalAndDeparatureTime time = new ArrivalAndDeparatureTime();
	    		 	time.setRecordedTime("12:12:2021 9:15");
	    		 	time.setType(true);
	    		 	times.add(time);
	    		 	ArrivalAndDeparatureTime time2 = new ArrivalAndDeparatureTime();
	    		 	time2.setRecordedTime("12:12:2021 15:15");
	    		 	time2.setType(false);
	    		 	times.add(time2);
	    		 	
	    		 
	    		 	FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowChildEvidencyOfPresenceWindow.fxml"));
	    			Pane pane = loader.load();
	    			ShowChildEvidencyOfPresenceWindowController controller = loader.getController();
	    			controller.setTimesInTable(times);
					paneEvidencyOfPresence.getChildren().setAll(pane);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }

    }


	
}

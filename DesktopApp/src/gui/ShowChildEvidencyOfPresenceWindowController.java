package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.ArrivalAndDeparatureTime;
import model.Child;
import model.Membership;

public class ShowChildEvidencyOfPresenceWindowController implements Initializable {
	
	    @FXML
	    private Label logo;

	    @FXML
	    private Label windowName;
	    
	    @FXML
	    private GridPane paneHorizontal;
	    
	    @FXML
	    private TableColumn<ArrivalAndDeparatureTime, String> tableColumnArrivalTime;

	    @FXML
	    private TableColumn<ArrivalAndDeparatureTime, String> tableColumnDepartureTime;

	    @FXML
	    private TableView<ArrivalAndDeparatureTime> tableViewEvidency;
	    
	    @FXML
	    private TableView<ArrivalAndDeparatureTime> tableViewDepartureTime;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			
		}

		public void setTimesInTable(ArrayList<ArrivalAndDeparatureTime> times) {
	
			ObservableList<ArrivalAndDeparatureTime> arrivalTimes= FXCollections.observableArrayList();
			ObservableList<ArrivalAndDeparatureTime> departureTimes= FXCollections.observableArrayList();
			
			for(int i=0; i<times.size(); i++) {
				
				if(times.get(i).isType()) {
					arrivalTimes.add(times.get(i));
				}else {
					departureTimes.add(times.get(i));
				}
			}
			
			tableColumnArrivalTime.setCellValueFactory(new PropertyValueFactory<ArrivalAndDeparatureTime, String>("recordedTime"));
			tableViewEvidency.setItems(arrivalTimes);
			tableColumnDepartureTime.setCellValueFactory(new PropertyValueFactory<ArrivalAndDeparatureTime, String>("recordedTime"));
			tableViewDepartureTime.setItems(departureTimes);
		}

	
}

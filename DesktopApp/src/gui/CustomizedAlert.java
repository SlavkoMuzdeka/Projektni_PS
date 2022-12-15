package gui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CustomizedAlert extends Alert {

	public CustomizedAlert(AlertType arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CustomizedAlert(AlertType arg0, String message1,String title) {
		super(arg0,message1,ButtonType.YES,ButtonType.NO);
//		Alert a = new Alert(arg0,message1,message2,ButtonType.YES,ButtonType.NO);
		this.setTitle(title);
		this.setHeaderText(message1);
		this.setHeaderText("");
		
	}

}

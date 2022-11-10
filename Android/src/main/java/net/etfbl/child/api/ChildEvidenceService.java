package net.etfbl.child.api;

import net.etfbl.child.model.DataSource;
import java.util.ArrayList;
import net.etfbl.child.model.Child;

public class ChildEvidenceService {

	DataSource data = DataSource.getInstance();
	
	public ArrayList<Child> getAllChilds(){
		return data.readAllChildsFromDB();
	}
}

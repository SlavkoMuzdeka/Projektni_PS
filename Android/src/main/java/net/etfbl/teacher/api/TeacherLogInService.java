package net.etfbl.teacher.api;

import net.etfbl.teacher.model.DataSource;
import net.etfbl.teacher.model.Teacher;

public class TeacherLogInService {

	DataSource data = DataSource.getInstance();

	public Boolean getIsValid(Teacher teacher) {
		 return data.checkValidation(teacher);
	}

}

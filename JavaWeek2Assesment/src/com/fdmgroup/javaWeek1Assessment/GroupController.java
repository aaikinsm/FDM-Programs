package com.fdmgroup.javaWeek1Assessment;

import java.util.Map;

public class GroupController {

	DatabaseReader dbReader;
	DatabaseWriter dbWriter;
	public GroupController(DatabaseWriter mockWriter, DatabaseReader mockReader) {
		dbReader = mockReader;
		dbWriter = mockWriter;
	}

	public Map<String, Trainee> getAllTrainees() {
		return dbReader.readGroup();
	}

	public void addTrainee(Trainee mockTrainee) {
		dbWriter.addTrainee(mockTrainee);
	}

	public void removeTraineeByUsername(String string) {
		dbWriter.deleteTraineeByUsername(string);
	}

}

package com.fdmgroup.javaWeek1Assessment;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.mockito.*;
import static org.mockito.Mockito.*;

import java.util.Map;

public class GroupControllerTest {
	
	private GroupController traineeGroupController;
	private Trainee mockTrainee;
	private DatabaseWriter mockWriter;
	private DatabaseReader mockReader;
	private Map<String, Trainee> mockMap;
	
	@Before
	public void setup(){
		mockWriter = mock(DatabaseWriter.class);
		mockReader = mock(DatabaseReader.class);
		mockMap = mock(Map.class);
		when(mockReader.readGroup()).thenReturn(mockMap);
		traineeGroupController = new GroupController(mockWriter, mockReader);
		mockTrainee = mock(Trainee.class);
	}

	@Test
	public void test_GetAllTraineesMethod_CallsReadGroupMethodOfInjectedDatabaseReader_WhenCalled(){
		traineeGroupController.getAllTrainees();
		verify(mockReader, times(1)).readGroup();
	}
	
	@Test
	public void test_GetAllTraineesMethod_ReturnsMapGivenToItByReadGroupMethodOfInjectedReader_WhenCalled(){
		Map<String, Trainee> allTrainees = traineeGroupController.getAllTrainees();
		assertEquals(mockMap, allTrainees);
	}
	
	@Test
	public void test_GetAllTraineesMethod_ReturnsAnEmptyMap_IfNoTraineesAreInGroup() {
		when(mockMap.size()).thenReturn(0);
		Map<String, Trainee> allTrainees = traineeGroupController.getAllTrainees();
		assertEquals(0, allTrainees.size());
	}
	
	@Test
	public void test_GetAllTrainees_ReturnsMapOfSizeOne_IfOneTraineeIsInTheGroup(){
		when(mockMap.size()).thenReturn(1);
		Map<String, Trainee> allTrainees = traineeGroupController.getAllTrainees();
		assertEquals(1, allTrainees.size());
	}	
	
	@Test
	public void test_AddTraineeMethod_CallsAddTraineeMethodOfDatabaseWriter_WhenCalled(){
		traineeGroupController.addTrainee(mockTrainee);
		verify(mockWriter, times(1)).addTrainee(any(Trainee.class));
	}
	
	@Test
	public void test_AddTraineeMethod_CallsAddTraineeMethodOfDatabaseWriterPassingTraineeObjectDefinedAsInput_WhenCalled(){
		traineeGroupController.addTrainee(mockTrainee);
		verify(mockWriter, times(1)).addTrainee(mockTrainee);
	}
	
	@Test
	public void test_RemoveTraineeMethodByUsername_CallsDeleteTraineeByUsernameMethodOfInjectedWriter_WhenCalled(){
		traineeGroupController.removeTraineeByUsername("");
		verify(mockWriter, times(1)).deleteTraineeByUsername(anyString());
	}
	
	@Test
	public void test_RemoveTraineeMethodByUsername_CallsDeleteTraineeByUsernameMethodOfInjectedWriterPassingUsernameDefinedAsInput_WhenCalled(){
		String username = "john.smith";
		traineeGroupController.removeTraineeByUsername(username);
		verify(mockWriter, times(1)).deleteTraineeByUsername(username);
	}
}








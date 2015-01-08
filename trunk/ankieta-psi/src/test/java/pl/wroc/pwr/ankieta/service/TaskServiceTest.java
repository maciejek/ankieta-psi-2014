package pl.wroc.pwr.ankieta.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import pl.wroc.pwr.ankieta.entity.Task;
import pl.wroc.pwr.ankieta.entity.User;
import pl.wroc.pwr.ankieta.entity.UserStory;
import pl.wroc.pwr.ankieta.entity.Workspace;
import pl.wroc.pwr.ankieta.repository.TaskRepository;
import pl.wroc.pwr.ankieta.service.TaskService;
import pl.wroc.pwr.ankieta.service.UserService;

public class TaskServiceTest {
	
	private static final int TASK_ID = 99;
	private static final String NUMBER = "T01-test";
	private static final String POINTS = "3";
	private static final String SUMMARY = "Testowy task";
	
	@Mock
	private Task task;
	
	@InjectMocks
	@Autowired
	private TaskService taskService;
	
	@Mock
	private Workspace workSpace;
	
	@Mock
	private UserService userService;
	
	@Mock
	private User user;
	
	@Mock
	private TaskRepository taskRepository;
	
	@Before
	public void initMocks(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldFindAllTasksOnRepository(){
		taskService.findAllTasks();
		verify(taskRepository).findAll();
	}
	
	@Test
	public void shouldFindTaskById(){
		taskService.getTaskById(TASK_ID);
		verify(taskRepository).findOne(TASK_ID);
	}
	
	@Test
	public void shouldGetTaskById(){
		taskService.saveTask(task);
		verify(taskRepository).save(task);
		taskService.getTaskById(task.getId());
		verify(taskRepository).findOne(task.getId());
		taskService.deleteTaskById(task.getId());
		verify(taskRepository).delete(task.getId());
	}

}

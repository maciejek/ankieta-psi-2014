package pl.wroc.pwr.ankieta.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wroc.pwr.ankieta.entity.Task;
import pl.wroc.pwr.ankieta.repository.TaskRepository;

@Service
@Transactional
public class TaskService {

	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAllTasks(){
		return taskRepository.findAll();
	}
	
	public Task getTaskById(Integer id){
		return taskRepository.findOne(id);
	}
	
	public void saveTask(Task task){
		taskRepository.save(task);
	}
	
	public void deleteTaskById(Integer id){
		taskRepository.delete(id);
	}
	
	
}
package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}

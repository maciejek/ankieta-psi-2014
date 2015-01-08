package pl.wroc.pwr.ankieta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.wroc.pwr.ankieta.entity.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {

}

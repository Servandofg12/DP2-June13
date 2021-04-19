package acme.features.anonymous.task;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousTaskRepository extends AbstractRepository{
	
	@Query(value = "SELECT * FROM TASK WHERE NOW() < END_MOMENT AND STATUS = 0 ORDER BY START_MOMENT, END_MOMENT,WORKLOAD", nativeQuery = true)
	Collection<Task> findNotFinishedByExecutionPeriod();
	

	
}

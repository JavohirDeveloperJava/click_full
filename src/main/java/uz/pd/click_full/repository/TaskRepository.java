package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.Task;


import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {

}

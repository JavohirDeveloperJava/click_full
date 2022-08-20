package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.TaskUser;


import java.util.UUID;

public interface TaskUserRepository extends JpaRepository<TaskUser, UUID> {
     boolean existsByTaskIdAndUsersId(UUID task_id, UUID users_id);
}

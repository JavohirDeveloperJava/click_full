package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.TaskTag;


import java.util.UUID;

public interface TaskTagRepository extends JpaRepository<TaskTag, UUID> {
}

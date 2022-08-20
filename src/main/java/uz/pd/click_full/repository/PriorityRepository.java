package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pd.click_full.entity.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}

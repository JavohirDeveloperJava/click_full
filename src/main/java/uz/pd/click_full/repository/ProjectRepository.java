package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pd.click_full.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByNameAndSpaceId(String name, Long space_id);
}

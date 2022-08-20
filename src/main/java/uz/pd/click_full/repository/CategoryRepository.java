package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByNameAndProjectId(String name, Long project_id);
}

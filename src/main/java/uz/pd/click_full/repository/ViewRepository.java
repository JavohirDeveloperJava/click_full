package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pd.click_full.entity.View;

@Repository
public interface ViewRepository extends JpaRepository<View, Long> {
     View getByName(String name);
}

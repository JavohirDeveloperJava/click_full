package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.ClickApps;


public interface ClickAppsRepository extends JpaRepository<ClickApps, Long> {
    boolean existsByName(String name);
    ClickApps getByName(String name);
}

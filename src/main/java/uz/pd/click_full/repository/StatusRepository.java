package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.Status;


public interface StatusRepository extends JpaRepository<Status, Long> {
    boolean existsByNameAndSpaceId(String name, Long space_id);
}

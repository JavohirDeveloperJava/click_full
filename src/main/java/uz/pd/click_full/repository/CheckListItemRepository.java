package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.CheckListItem;


public interface CheckListItemRepository extends JpaRepository<CheckListItem, Long> {
}

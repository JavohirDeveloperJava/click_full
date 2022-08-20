package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pd.click_full.entity.CheckList;


@Repository
public interface CheckListRepository extends JpaRepository<CheckList, Long> {
}

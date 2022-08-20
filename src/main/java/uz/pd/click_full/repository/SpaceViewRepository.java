package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pd.click_full.entity.SpaceView;

@Repository
public interface SpaceViewRepository extends JpaRepository<SpaceView, Long> {
  void deleteBySpaceIdAndId(Long space_id, Long id);
}

package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.SpaceUser;


import java.util.List;
import java.util.UUID;

public interface SpaceUserRepository extends JpaRepository<SpaceUser, UUID> {
    List<SpaceUser> findAllBySpaceId(Long space_id);


}

package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.Tag;


import java.util.List;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
    boolean existsByNameAndWorkspaceId(String name, Long workspace_id);
    List<Tag> findAllByWorkspaceId(Long workspace_id);
}

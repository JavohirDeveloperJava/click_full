package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.WorkspaceRole;


import java.util.UUID;

public interface WorkspaceRoleRepository extends JpaRepository<WorkspaceRole, UUID> {

    boolean existsByWorkspaceIdAndName(Long workspace_id, String name);
}

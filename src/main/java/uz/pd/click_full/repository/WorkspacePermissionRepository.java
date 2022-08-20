package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pd.click_full.entity.WorkspacePermission;


import java.util.List;
import java.util.UUID;

public interface WorkspacePermissionRepository extends JpaRepository<WorkspacePermission, UUID> {

    @Query("select w from WorkspacePermission w where w.workspaceRole.workspace.id = ?1 and w.workspaceRole.name = ?2")
    List<WorkspacePermission> findAllByWorkspaceRole(Long workspace_id, String name);


    List<WorkspacePermission> findAllByWorkspaceRole_NameAndWorkspaceRole_WorkspaceId(String workspaceRole_name, Long workspaceRole_workspace_id);
}

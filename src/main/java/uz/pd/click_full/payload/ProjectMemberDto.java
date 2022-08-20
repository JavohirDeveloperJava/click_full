package uz.pd.click_full.payload;

import lombok.Data;
import uz.pd.click_full.entity.enums.WorkspacePermissionName;

import java.util.List;
import java.util.UUID;

@Data
public class ProjectMemberDto {

//    @NotNull
    private Long projectId;

//    @NotBlank
    private WorkspacePermissionName permissions;

    private List<UUID> users;

}

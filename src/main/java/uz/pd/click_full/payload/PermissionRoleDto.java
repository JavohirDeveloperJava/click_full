package uz.pd.click_full.payload;

import lombok.Data;


import java.util.List;
import java.util.UUID;
@Data
public class PermissionRoleDto {


    private Long workspaceId;

    private UUID workspaceRoleId;

    private List<String> permissions;
}

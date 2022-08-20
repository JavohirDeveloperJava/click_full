package uz.pd.click_full.payload;

import lombok.Data;

import uz.pd.click_full.entity.enums.AccessType;
import uz.pd.click_full.entity.enums.WorkspacePermissionName;


import java.util.List;
import java.util.UUID;

@Data
public class CategoryDto {

    private String name;

    private String color;

    private Long projectId;


    private AccessType accessType;

    private List<UUID> members;

    private WorkspacePermissionName workspacePermissionName;
}

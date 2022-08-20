package uz.pd.click_full.service;


import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.PermissionRoleDto;
import uz.pd.click_full.payload.WorkspaceRoleDto;

public interface WorkspaceRoleService {
    ApiResponse addWorkspaceRole(WorkspaceRoleDto dto);

    ApiResponse addPermissionWorkspaceRole(PermissionRoleDto dto);

    ApiResponse removePermissionWorkspaceRole(PermissionRoleDto dto);
}

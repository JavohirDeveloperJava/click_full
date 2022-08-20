package uz.pd.click_full.service;



import uz.pd.click_full.entity.Users;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.ChangeOwnerDto;
import uz.pd.click_full.payload.MemberDTO;
import uz.pd.click_full.payload.WorkspaceDTO;

import java.util.List;


public interface WorkspaceService {

    ApiResponse addWorkspace(WorkspaceDTO workspaceDTO, Users user);

    ApiResponse deleteWorkspace(Long id);

    ApiResponse addOrEditOrRemoveWorkspace(Long id, MemberDTO memberDTO, Users users);

    ApiResponse joinToWorkspace(Long id, Users user);

    ApiResponse editWorkspace(Long id, WorkspaceDTO workspaceDTO);

    ApiResponse changeOwnerWorkspace(ChangeOwnerDto dto);

    List<MemberDTO> getMemberGuest(Long id);

    List<WorkspaceDTO> getMyWorkspace(Users users);
}

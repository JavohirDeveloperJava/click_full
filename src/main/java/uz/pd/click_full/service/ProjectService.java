package uz.pd.click_full.service;


import uz.pd.click_full.entity.Users;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.ProjectDto;
import uz.pd.click_full.payload.ProjectMemberDto;

public interface ProjectService {
    ApiResponse addProject(ProjectDto dto, Users users);


    ApiResponse addAndRemoveInviteMember(ProjectMemberDto dto, Long id);

    ApiResponse deletProject(Long id);
}

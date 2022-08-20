package uz.pd.click_full.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pd.click_full.entity.Users;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.ProjectDto;
import uz.pd.click_full.payload.ProjectMemberDto;
import uz.pd.click_full.security.CurrentUser;
import uz.pd.click_full.service.ProjectService;


import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("/add")
    public HttpEntity<?> addProject(@Valid @RequestBody ProjectDto dto, @CurrentUser Users users){
        ApiResponse apiResponse = projectService.addProject(dto, users);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/addAndRemoveMember/{id}")
    public HttpEntity<?> addAndRemoveInviteMember(@Valid @RequestBody ProjectMemberDto dto, @PathVariable Long id){
        ApiResponse apiResponse = projectService.addAndRemoveInviteMember(dto, id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/deletProject/{id}")
    public HttpEntity<?> deletProject(@PathVariable Long id){
        ApiResponse apiResponse = projectService.deletProject(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}

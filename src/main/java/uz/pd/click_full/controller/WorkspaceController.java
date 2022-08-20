package uz.pd.click_full.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pd.click_full.entity.Users;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.ChangeOwnerDto;
import uz.pd.click_full.payload.MemberDTO;
import uz.pd.click_full.payload.WorkspaceDTO;
import uz.pd.click_full.security.CurrentUser;
import uz.pd.click_full.service.WorkspaceService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceController {
    @Autowired
    WorkspaceService workspaceService;

    @PostMapping
    public HttpEntity<?> addWorkspace(@Valid @RequestBody WorkspaceDTO workspaceDTO, @CurrentUser Users user) {
        ApiResponse apiResponse = workspaceService.addWorkspace(workspaceDTO, user);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     * NAME, COLOR, AVATAR O'ZGARAISHI MUMKIN
     *
     * @param id
     * @param workspaceDTO
     * @return
     */
    @PutMapping("/edet")
    public HttpEntity<?> editWorkspace(@RequestParam Long id, @RequestBody WorkspaceDTO workspaceDTO) {
        ApiResponse apiResponse = workspaceService.editWorkspace(id, workspaceDTO);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    /**
     *
     * @return
     */
    @PutMapping("/changeOwner")
    public HttpEntity<?> changeOwnerWorkspace(@RequestBody ChangeOwnerDto dto) {
        ApiResponse apiResponse = workspaceService.changeOwnerWorkspace(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }


    /**
     * ISHXONANI O'CHIRISH
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteWorkspace(@PathVariable Long id) {
        ApiResponse apiResponse = workspaceService.deleteWorkspace(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping("/addOrEditOrRemove/{id}")
    public HttpEntity<?> addOrEditOrRemoveWorkspace(@PathVariable Long id,
                                                    @RequestBody MemberDTO memberDTO, @CurrentUser Users users) {
        ApiResponse apiResponse = workspaceService.addOrEditOrRemoveWorkspace(id, memberDTO, users);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PutMapping("/join")
    public HttpEntity<?> joinToWorkspace(@RequestParam Long id,
                                         @CurrentUser Users users) {
        ApiResponse apiResponse = workspaceService.joinToWorkspace(id, users);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    //Member va Guest larni korish
    @GetMapping("/getMemberGuest/{id}")
    public HttpEntity<?> getMemberGuest(@PathVariable Long id){
        List<MemberDTO> members = workspaceService.getMemberGuest(id);
        return ResponseEntity.ok(members);
    }

    //Worspace larni hammasini olish
    @GetMapping()
    public HttpEntity<?> getMyWorkspace(@CurrentUser Users users){
        List<WorkspaceDTO> workspaceList = workspaceService.getMyWorkspace(users);
        return ResponseEntity.ok(workspaceList);
    }


}

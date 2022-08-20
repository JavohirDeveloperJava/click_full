package uz.pd.click_full.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.CheckListDto;
import uz.pd.click_full.payload.CheckListItemDto;
import uz.pd.click_full.service.CheckListService;


import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/checkList")
public class CheckListController {
    @Autowired
    CheckListService checkListService;
    @PostMapping("/add")
    public HttpEntity<?> addCheckList(@RequestBody CheckListDto dto){
        ApiResponse apiResponse = checkListService.addCheckList(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/edet/{id}")
    public HttpEntity<?> edetCheckList(@PathVariable Long id, @Valid @RequestBody CheckListDto dto){
        ApiResponse apiResponse = checkListService.edetCheckList(dto, id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/delete/id")
    public HttpEntity<?> deleteCheckList(@PathVariable Long id){
        ApiResponse apiResponse = checkListService.deleteCheckList(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PostMapping("add/checkItem")
    public HttpEntity<?> addCheckListItem(@RequestBody CheckListItemDto dto){
        ApiResponse apiResponse = checkListService.addCheckListItem(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/edetItem/{id}")
    public HttpEntity<?> edetItemCheckList(@Valid @RequestBody CheckListItemDto dto, @PathVariable Long id){
        ApiResponse apiResponse = checkListService.edetItemCheckList(dto, id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("addAssign/{id}")
    public HttpEntity<?> addAssign(@PathVariable Long id, @RequestParam UUID userId){
        ApiResponse apiResponse = checkListService.addAssignCheckList(id, userId);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}

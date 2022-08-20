package uz.pd.click_full.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.StatusDto;
import uz.pd.click_full.service.StatusService;


import javax.validation.Valid;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    StatusService statusService;

    @PostMapping("/add")
    public HttpEntity<?> addStatus(@Valid @RequestBody StatusDto dto){
        ApiResponse apiResponse  = statusService.addStatus(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/edet/{id}")
    public HttpEntity<?> edetStatus(@Valid @RequestBody StatusDto dto, @PathVariable Long id){
       ApiResponse apiResponse =  statusService.edetStatus(dto, id);
       return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}

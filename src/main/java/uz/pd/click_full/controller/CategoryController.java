package uz.pd.click_full.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pd.click_full.entity.Users;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.CategoryDto;
import uz.pd.click_full.security.CurrentUser;
import uz.pd.click_full.service.CategoryService;


import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public HttpEntity<?> addCategory(@Valid @RequestBody CategoryDto dto, @CurrentUser Users users){
        ApiResponse apiResponse = categoryService.addCategory(dto, users);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/edet/{id}")
    public HttpEntity<?> edetCategory(@Valid @RequestBody CategoryDto dto, @PathVariable Long id, @CurrentUser Users users){
        ApiResponse apiResponse = categoryService.edetCategory(dto, id, users);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/archived/{id}")
    public HttpEntity<?> archivedCategory(@PathVariable Long id){
        ApiResponse apiResponse = categoryService.archivedCategory(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

}

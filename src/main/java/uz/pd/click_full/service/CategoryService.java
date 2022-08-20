package uz.pd.click_full.service;


import uz.pd.click_full.entity.Users;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.CategoryDto;

public interface CategoryService {
    ApiResponse addCategory(CategoryDto dto, Users users);

    ApiResponse edetCategory(CategoryDto dto, Long id, Users users);

    ApiResponse archivedCategory(Long id);
}

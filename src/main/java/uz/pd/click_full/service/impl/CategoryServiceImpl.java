package uz.pd.click_full.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pd.click_full.entity.*;
import uz.pd.click_full.entity.enums.AccessType;
import uz.pd.click_full.entity.enums.WorkspacePermissionName;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.CategoryDto;
import uz.pd.click_full.repository.CategoryRepository;
import uz.pd.click_full.repository.CategoryUserRepository;
import uz.pd.click_full.repository.ProjectRepository;
import uz.pd.click_full.repository.ProjectUserRepository;
import uz.pd.click_full.service.CategoryService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectUserRepository projectUserRepository;
    @Autowired
    CategoryUserRepository categoryUserRepository;

    @Override
    public ApiResponse addCategory(CategoryDto dto, Users users) {
        if (categoryRepository.existsByNameAndProjectId(dto.getName(), dto.getProjectId()))
            return new ApiResponse("Category mavjud", true);
        Category category = new Category(
                dto.getName(),
                dto.getColor(),
                projectRepository.findById(dto.getProjectId()).orElseThrow(() -> new ResourceNotFoundException("project")),
                dto.getAccessType(),
                false
        );
        categoryRepository.save(category);
        List<CategoryUser> categoryUserList = new ArrayList<>();
        if (dto.getAccessType().equals(AccessType.PUBLIC)){
            List<ProjectUser> projectUserList = projectUserRepository.findAllByProjectId(dto.getProjectId());
            for (ProjectUser projectUser : projectUserList) {
                for (WorkspacePermissionName value : WorkspacePermissionName.values()) {
                    categoryUserList.add(new CategoryUser(dto.getName(), category,projectUser.getUsers(),value));
                }
            }
        }else {
            for (WorkspacePermissionName value : WorkspacePermissionName.values()) {
                categoryUserList.add(new CategoryUser(dto.getName(),category, users ,value));
            }
        }
        categoryUserRepository.saveAll(categoryUserList);
        return new ApiResponse("Saqlandi", true);
    }

    @Override
    public ApiResponse edetCategory(CategoryDto dto, Long id, Users users) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new ApiResponse("Topilmadi", false);

        Project project = projectRepository.findById(dto.getProjectId()).orElseThrow(() -> new ResourceNotFoundException("project"));

        Category category = optionalCategory.get();
        category.setName(dto.getName());
        category.setColor(dto.getColor());
        category.setProject(project);

        List<CategoryUser> categoryUserList = new ArrayList<>();
        if (!category.getAccessType().equals(dto.getAccessType())){
            category.setAccessType(dto.getAccessType());
            categoryRepository.save(category);
            if (dto.getAccessType().equals(AccessType.PUBLIC)){
                List<ProjectUser> projectUserList = projectUserRepository.findAllByProjectId(dto.getProjectId());
                for (ProjectUser projectUser : projectUserList) {
                    for (WorkspacePermissionName value : WorkspacePermissionName.values()) {
                        categoryUserList.add(new CategoryUser(dto.getName(), category, projectUser.getUsers(),value));
                    }
                }
            }else {
                for (WorkspacePermissionName value : WorkspacePermissionName.values()) {
                    categoryUserList.add(new CategoryUser(dto.getName(),category, users ,value));
                }
            }
        }
        categoryUserRepository.saveAll(categoryUserList);
        return new ApiResponse("Edet category", true);
    }

    @Override
    public ApiResponse archivedCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category"));
        if (category.isArchived()) {
            category.setArchived(false);
        }else {
            category.setArchived(true);
        }
        return new ApiResponse("Archived category", true);
    }
}

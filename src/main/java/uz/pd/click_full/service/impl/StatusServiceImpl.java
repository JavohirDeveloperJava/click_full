package uz.pd.click_full.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pd.click_full.entity.Category;
import uz.pd.click_full.entity.Project;
import uz.pd.click_full.entity.Space;
import uz.pd.click_full.entity.Status;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.StatusDto;
import uz.pd.click_full.repository.CategoryRepository;
import uz.pd.click_full.repository.ProjectRepository;
import uz.pd.click_full.repository.SpaceRepository;
import uz.pd.click_full.repository.StatusRepository;
import uz.pd.click_full.service.StatusService;


import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    SpaceRepository spaceRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public ApiResponse addStatus(StatusDto dto) {
        if (statusRepository.existsByNameAndSpaceId(dto.getName(), dto.getSpaceId()))
            return new ApiResponse("Exists status space already", false);
        Status status = new Status(
                dto.getName(), 
                dto.getColor(),
                spaceRepository.findById(dto.getSpaceId()).orElseThrow(() -> new ResourceNotFoundException("Space")),
                projectRepository.findById(dto.getProjectId()).orElseThrow(() -> new ResourceNotFoundException("project")),
                categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("category")),
                dto.getStatusType()
        );
        statusRepository.save(status);
        return new ApiResponse("Saqlandi", true);
    }

    @Override
    public ApiResponse edetStatus(StatusDto dto, Long id) {
        Optional<Status> optionalStatus = statusRepository.findById(id);
        if (!optionalStatus.isPresent())
            return new ApiResponse("Status topilmadi", false);
        Status status = optionalStatus.get();
        Space space = spaceRepository.findById(dto.getSpaceId()).orElseThrow(() -> new ResourceNotFoundException("Space"));
        Project project = projectRepository.findById(dto.getProjectId()).orElseThrow(() -> new ResourceNotFoundException("project"));
        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("category"));
        status.setName(dto.getName());
        status.setColor(dto.getColor());
        status.setSpace(space);
        status.setProject(project);
        status.setCategory(category);
        status.setStatusType(dto.getStatusType());
        statusRepository.save(status);
        return new ApiResponse("Edet status", true);

    }
}

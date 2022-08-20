package uz.pd.click_full.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pd.click_full.entity.Tag;
import uz.pd.click_full.entity.Workspace;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.TagDto;
import uz.pd.click_full.repository.TagRepository;
import uz.pd.click_full.repository.UserRepository;
import uz.pd.click_full.repository.WorkspaceRepository;
import uz.pd.click_full.service.TagService;


import java.util.List;
import java.util.UUID;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepository tagRepository;
    @Autowired
    WorkspaceRepository workspaceRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public ApiResponse createTag(TagDto dto) {
        if (tagRepository.existsByNameAndWorkspaceId(dto.getName(), dto.getWorkspaceId()))
            return new ApiResponse("Tag exists", false);
        Workspace workspace = workspaceRepository.findById(dto.getWorkspaceId()).orElseThrow(() -> new ResourceNotFoundException("Worksapce not found"));

        Tag tag = new Tag(
                dto.getName(),
                dto.getColor(),
                workspace
        );
        tagRepository.save(tag);
        return new ApiResponse("Saqlandi", true);
    }

    @Override
    public ApiResponse deleteTag(UUID id) {
        try {
            tagRepository.deleteById(id);
            return new ApiResponse("deleted ", true);
        }catch (Exception e){
            return new ApiResponse("No deleted", false);
        }
    }

    @Override
    public List<Tag> getTagAll(Long workspaceId) {
        List<Tag> tagList = tagRepository.findAllByWorkspaceId(workspaceId);
        return tagList;
    }

}

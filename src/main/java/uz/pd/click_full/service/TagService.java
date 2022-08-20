package uz.pd.click_full.service;


import uz.pd.click_full.entity.Tag;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.TagDto;

import java.util.List;
import java.util.UUID;

public interface TagService {
    ApiResponse createTag(TagDto dto);

    ApiResponse deleteTag(UUID id);

    List<Tag> getTagAll(Long workspaceId);
}

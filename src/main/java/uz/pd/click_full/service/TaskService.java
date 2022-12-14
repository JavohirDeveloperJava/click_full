package uz.pd.click_full.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pd.click_full.payload.*;

import java.util.UUID;

public interface TaskService {
    ApiResponse addTask(TaskDto dto);

    ApiResponse edetTask(TaskDto dto, UUID id);

    ApiResponse changeStatus(UUID id, Long statusId);

    ApiResponse createSubTask(TaskDto dto, UUID id);

    ApiResponse addCommentTask(CommentDto dto, UUID id);

    ApiResponse deleteComment(UUID id);

    ApiResponse addTag(TagDto dto, UUID id);

    ApiResponse removeTag(UUID id);

    ApiResponse assignAddUser(TaskUserDto dto);

    ApiResponse removeAssign(TaskUserDto dto);

    ApiResponse addAttachmentTask(TaskAttachmentDto dto, MultipartHttpServletRequest request);


}

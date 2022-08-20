package uz.pd.click_full.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskAttachmentDto {
//    @NotNull
    private UUID taskId;

    private boolean pinCoverImaga;

}

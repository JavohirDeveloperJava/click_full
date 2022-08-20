package uz.pd.click_full.payload;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TaskUserDto {

    private UUID taskId;

    private List<UUID> userId;
}

package uz.pd.click_full.payload;

import lombok.Data;
import uz.pd.click_full.entity.enums.StatusType;


@Data
public class StatusDto {

//    @NotNull
    private String name;

    private String color;

    private Long spaceId;

    private Long projectId;

    private Long categoryId;

    private StatusType statusType;
}

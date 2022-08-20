package uz.pd.click_full.payload;

import lombok.Data;
import uz.pd.click_full.entity.enums.AccessType;

import java.util.List;

@Data
public class ProjectDto {

    private String name;

    private String color;

    private Long spaceId;


    private AccessType accessType;

    private List<String> lists;
}

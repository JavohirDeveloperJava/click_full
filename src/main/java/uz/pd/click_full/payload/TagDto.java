package uz.pd.click_full.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class TagDto {

    private UUID id;

//    @NotNull
    private String name;

    private String color;

    private Long workspaceId;


}

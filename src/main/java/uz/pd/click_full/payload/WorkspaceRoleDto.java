package uz.pd.click_full.payload;

import lombok.Data;


import java.util.UUID;


@Data
public class WorkspaceRoleDto {

//    @NotNull
    private Long workspaceId;

//    @NotBlank
    private String name;

//    @NotNull
    private UUID extendsRole;
}

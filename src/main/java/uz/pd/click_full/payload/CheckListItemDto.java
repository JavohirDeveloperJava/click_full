package uz.pd.click_full.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class CheckListItemDto {


    private String name;

    private Long checkId;

    private boolean resolved;

    private UUID userId;
}

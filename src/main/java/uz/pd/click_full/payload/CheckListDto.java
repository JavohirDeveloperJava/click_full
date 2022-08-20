package uz.pd.click_full.payload;

import lombok.Data;


import java.util.UUID;

@Data
public class CheckListDto {


    private String name;

    private UUID taskId;

}

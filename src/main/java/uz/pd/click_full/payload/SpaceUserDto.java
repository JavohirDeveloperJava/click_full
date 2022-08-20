package uz.pd.click_full.payload;

import lombok.Data;
import uz.pd.click_full.entity.enums.AccessType;


import java.util.List;
import java.util.UUID;

@Data
public class SpaceUserDto {

    private List<UUID> userId;


    private AccessType accessType;


}

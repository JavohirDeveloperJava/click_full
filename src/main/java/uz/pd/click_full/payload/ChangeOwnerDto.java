package uz.pd.click_full.payload;


import lombok.Data;


import java.util.UUID;

@Data
public class ChangeOwnerDto {


    private Long id;

    private UUID ownerId;
}

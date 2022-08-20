package uz.pd.click_full.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import uz.pd.click_full.entity.enums.AddType;


import java.sql.Timestamp;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberDTO {
    private UUID id;

    private String fullName;

    private String email;

    private Timestamp lastActive;

    private String roleName;

    private UUID roleId;

    private AddType addType;//ADD, EDIT, REMOVE
}

package uz.pd.click_full.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pd.click_full.entity.enums.WorkspacePermissionName;
import uz.pd.click_full.entity.template.AbsLongEntity;


import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoryUser extends AbsLongEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Users users;

    @Enumerated(EnumType.STRING)
    private WorkspacePermissionName workspacePermissionName;

}

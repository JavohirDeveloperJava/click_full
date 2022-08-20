package uz.pd.click_full.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pd.click_full.entity.enums.WorkspacePermissionName;
import uz.pd.click_full.entity.template.AbsLongEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProjectUser extends AbsLongEntity {

    @ManyToOne
    private Project project;

    @ManyToOne
    private Users users;

    @Enumerated(EnumType.STRING)
    private WorkspacePermissionName permissions;
}

package uz.pd.click_full.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pd.click_full.entity.enums.DependencyType;
import uz.pd.click_full.entity.template.AbsUUIDEntity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskDependency extends AbsUUIDEntity {
    @ManyToOne
    private Task task;

    @ManyToOne
    private TaskDependency taskDependency;

    @Enumerated(EnumType.STRING)
    private DependencyType dependencyType;
}

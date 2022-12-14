package uz.pd.click_full.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CascadeType;
import uz.pd.click_full.entity.enums.AccessType;
import uz.pd.click_full.entity.template.AbsLongEntity;


import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "project_id"}))
public class Category extends AbsLongEntity {

    @Column(nullable = false)
    private String name;

    private String color;

    @ManyToOne
    private Project project;

    @Transient
    @OneToMany(mappedBy = "category")
    private List<Status> status;

    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    private boolean archived;

    public Category(String name, String color, Project project, AccessType accessType, boolean archived) {
        this.name = name;
        this.color = color;
        this.project = project;
        this.accessType = accessType;
        this.archived = archived;
    }

    public Category(String name, Project project) {
        this.name = name;
        this.project = project;
    }


}

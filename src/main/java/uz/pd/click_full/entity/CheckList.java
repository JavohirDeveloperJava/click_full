package uz.pd.click_full.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pd.click_full.entity.template.AbsLongEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CheckList extends AbsLongEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Task task;

}

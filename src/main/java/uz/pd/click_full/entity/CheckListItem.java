package uz.pd.click_full.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pd.click_full.entity.template.AbsLongEntity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CheckListItem extends AbsLongEntity {
    private String name;

    @ManyToOne
    private CheckList checkList;

    private boolean resolved;  //Bajarilganligi

    @ManyToOne
    private Users users;
}

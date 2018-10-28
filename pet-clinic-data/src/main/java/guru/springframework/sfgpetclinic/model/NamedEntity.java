package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class NamedEntity extends BaseEntity {
    protected String name;

    NamedEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

    NamedEntity(){}
}

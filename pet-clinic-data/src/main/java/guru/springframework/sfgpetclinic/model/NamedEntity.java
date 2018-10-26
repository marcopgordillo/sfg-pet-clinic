package guru.springframework.sfgpetclinic.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class NamedEntity extends BaseEntity {
    protected String name;
}

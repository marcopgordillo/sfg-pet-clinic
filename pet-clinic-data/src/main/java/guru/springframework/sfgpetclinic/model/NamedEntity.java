package guru.springframework.sfgpetclinic.model;

import lombok.Data;

@Data
public class NamedEntity extends BaseEntity {
    protected String name;
}

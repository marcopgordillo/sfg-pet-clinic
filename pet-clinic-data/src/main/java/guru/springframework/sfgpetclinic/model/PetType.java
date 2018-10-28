package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "types")
public class PetType extends NamedEntity {

    @Builder
    public PetType(Long id, String name) {
        super(id, name);
    }

    public PetType() {
    }
}

package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {

    @Builder
    public Specialty(Long id, String name) {
        super(id, name);
    }

    public Specialty(){}
}

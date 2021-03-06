package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {

    @Builder
    public Specialty(Long id, String name) {
        super(id, name);
    }
}

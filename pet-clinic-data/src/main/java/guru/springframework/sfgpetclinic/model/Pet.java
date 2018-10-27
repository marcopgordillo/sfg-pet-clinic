package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet extends NamedEntity {

    private LocalDate birthDate;
    private PetType petType;
    private Owner owner;
    private Set<Visit> visits;
}

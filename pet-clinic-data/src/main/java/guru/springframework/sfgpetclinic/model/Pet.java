package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false, exclude = "visits")
@AllArgsConstructor
@NoArgsConstructor
public class Pet extends NamedEntity {

    private LocalDate birthDate;
    private PetType petType;
    private Owner owner;
    private Set<Visit> visits = new HashSet<>();
}

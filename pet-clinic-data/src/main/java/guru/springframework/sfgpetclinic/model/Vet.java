package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vet extends Person {
    private Set<Speciality> specialties;
}

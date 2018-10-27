package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false, exclude = "specialties")
@AllArgsConstructor
@NoArgsConstructor
public class Vet extends Person {
    private Set<Specialty> specialties = new HashSet<>();
}

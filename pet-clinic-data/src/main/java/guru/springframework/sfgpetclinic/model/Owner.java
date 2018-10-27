package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false, exclude = "pets")
@AllArgsConstructor
@NoArgsConstructor
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets = new HashSet<>();

}

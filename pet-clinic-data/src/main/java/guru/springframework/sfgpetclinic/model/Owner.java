package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets;

}

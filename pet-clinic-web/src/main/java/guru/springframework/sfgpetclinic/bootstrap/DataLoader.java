package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadOwners();

        loadVets();

        loadPets();
    }

    private void loadPets() {
        Pet pet1 = new Pet();
        pet1.setName("Jupiter");

        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setName("Tarzan");

        petService.save(pet2);

        System.out.println("Loaded Pets...");
    }

    private void loadVets() {
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Juan");
        vet2.setLastName("Perez");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }

    private void loadOwners() {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenname");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

    }
}

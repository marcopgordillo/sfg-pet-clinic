package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private PetType savedDogPetType;
    private PetType savedCatPetType;
    private Owner savedOwner1;
    private Owner savedOwner2;

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        loadPetTypes();

        loadOwners();

        loadVets();

        loadPets();

    }

    private void loadPetTypes() {

        PetType dog = new PetType();
        dog.setName("Dog");

        savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes...");
    }

    private void loadPets() {
        Pet pet1 = new Pet();
        pet1.setName("Jupiter");
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(savedOwner1);
        pet1.setBirthDate(LocalDate.now());

        petService.save(pet1);

        savedOwner1.getPets().add(pet1);
        ownerService.save(savedOwner1);

        Pet pet2 = new Pet();
        pet2.setName("Miche");
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(savedOwner2);
        pet2.setBirthDate(LocalDate.now());

        petService.save(pet2);

        savedOwner2.getPets().add(pet2);
        ownerService.save(savedOwner2);

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
        owner1.setAddress("123 Brickerel");
        owner1.setTelephone("1234454334");
        owner1.setCity("Miami");

        savedOwner1 = ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenname");
        owner2.setAddress("123 Brickerel");
        owner2.setTelephone("12344545678");
        owner2.setCity("New York");

        savedOwner2 = ownerService.save(owner2);

        System.out.println("Loaded Owners...");

    }
}

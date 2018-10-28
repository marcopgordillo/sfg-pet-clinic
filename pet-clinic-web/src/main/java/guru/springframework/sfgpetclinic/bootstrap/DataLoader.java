package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        Specialty specialty1 = new Specialty();
        specialty1.setName("Radiology");

        Specialty savedSpecialty1 = specialtyService.save(specialty1);

        Specialty specialty2 = new Specialty();
        specialty2.setName("Surgery");

        Specialty savedSpecialty2 = specialtyService.save(specialty2);

        System.out.println("Loaded Specialties...");

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setTelephone("1234454334");
        owner1.setCity("Miami");

        Owner savedOwner1 = ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenname");
        owner2.setAddress("123 Brickerel");
        owner2.setTelephone("12344545678");
        owner2.setCity("New York");

        Owner savedOwner2 = ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Pet pet1 = new Pet();
        pet1.setName("Jupiter");
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());

        petService.save(pet1);

        savedOwner1.getPets().add(pet1);
        ownerService.save(savedOwner1);

        Pet pet2 = new Pet();
        pet2.setName("Miche");
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());

        petService.save(pet2);

        savedOwner2.getPets().add(pet2);
        ownerService.save(savedOwner2);

        System.out.println("Loaded Pets...");

        Vet vet1 = Vet.builder().firstName("Sam").lastName("Axe").build();
        vet1.getSpecialties().add(savedSpecialty1);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Juan");
        vet2.setLastName("Perez");
        vet2.getSpecialties().add(savedSpecialty2);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Visit cat");
        visit1.setPet(pet1);

        visitService.save(visit1);

        System.out.println("Loaded Visits...");


    }
}

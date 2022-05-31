package bht.salvinto.sfgdi.controllers;

import bht.salvinto.springframework.pets.PetService;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsBest() {
        return petService.getPetType();
    }
}

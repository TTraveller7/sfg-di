package bht.salvinto.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// @Service
// @Profile("cat")
public class CatService implements PetService {
    @Override
    public String getPetType() {
        return "Cats are the best!";
    }
}

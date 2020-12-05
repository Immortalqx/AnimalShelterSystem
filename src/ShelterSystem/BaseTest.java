package ShelterSystem;

import ShelterSystem.Base.AnimalShelterSystem;

import java.io.IOException;

public class BaseTest {

    public static void main(String[] args) throws IOException {
        // write your code here
        AnimalShelterSystem animalShelterSystem = AnimalShelterSystem.systemInit();
        animalShelterSystem.login();
    }
}

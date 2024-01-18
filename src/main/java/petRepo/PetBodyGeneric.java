package petRepo;

import java.util.Random;


public class PetBodyGeneric {

	public static Pet randomPetBody(Status status) {
		int petId=new Random().nextInt(1000);
		String petName ="fluffy"+petId;
		Pet pet=new Pet(petId, petName, status);
	return pet;
	}
	
}

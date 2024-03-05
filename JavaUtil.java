package commonUtils;

import java.util.Random;

public class JavaUtil {

	public int getRandomNumber() {
		Random rndm = new Random();
		int num = rndm.nextInt(500);
		return num;

	}

}

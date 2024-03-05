package CommanUtils;

import java.util.Random;

public class javaUtil {

	public int getRandomNumber() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int ran = r.nextInt(500);
		return ran;
	}

}

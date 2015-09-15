package refactoring;

public class Util {
	static public int randomNumber(int min, int max) {
		int range = (max - min);
		return (int) (Math.random() * range) + min;
	}
}

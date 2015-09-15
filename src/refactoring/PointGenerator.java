package refactoring;

import java.util.ArrayList;
import java.util.List;

public class PointGenerator {

	// Divide Space
	public Space[] divideSpace(Space space, int divide) {
		int spaceWidth = space.getWidth() / divide;
		int spaceHeight = space.getHeight() / divide;

		Space[] spaces = new Space[(int) Math.pow(divide, 2)];

		for (int i = 0; i < spaces.length; i++) {
			Point anchor = new Point((i / divide) * spaceWidth, (i % divide) * spaceHeight);
			Space s = new Space(anchor, spaceWidth, spaceHeight);
			spaces[i] = s;
		}
		return spaces;
	}

	public List<Point> generate(Space space, int num) {
		space.generatePoints(num);
		return space.getPointList();
	}

	public List<Point> getPointList(Space space, int num, int divide) {
		Space[] spaces = divideSpace(space, divide);
		List<Point> pointList = new ArrayList<Point>();
		for (Space s : spaces)
			pointList.addAll(generate(s, num / spaces.length));
		return pointList;
	}
}

package refactoring;

import java.util.ArrayList;
import java.util.List;

//사각형의 공간을 n개로 분할하여 m개의 포인트 쏠리지 않게 생성한 리스트를 리턴한다.
public class PointGenerator {

	//public이라면 private변경해야 함. Test를 위한 임시해제
	public Space[] divideSpace(Space space, int divide) {
		int spaceWidth = space.getWidth() / divide;
		int spaceHeight = space.getHeight() / divide;
		Space[] spaces;
		if (space.isDividable()) {
			spaces = new Space[(int) Math.pow(divide, 2)];
			for (int i = 0; i < spaces.length; i++) {
				Point anchor = new Point((i / divide) * spaceWidth, (i % divide) * spaceHeight);
				Space s = space.getInstance(anchor, spaceWidth, spaceHeight);
				spaces[i] = s;
			}
		} else
			spaces = new Space[] { space };
		return spaces;
	}

	//public이라면 private변경해야 함. Test를 위한 임시해제
	public List<Point> generate(Space s, int amount) {
		s.generatePoints(amount);
		return s.getPointList();
	}

	public List<Point> getPointList(Space space, int amount, int divide) {
		Space[] spaces = divideSpace(space, divide);

		List<Point> pointList = new ArrayList<Point>();
		for (Space s : spaces)
			pointList.addAll(generate(s, amount / spaces.length));
		return pointList;
	}
}

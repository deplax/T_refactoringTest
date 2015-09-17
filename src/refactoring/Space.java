package refactoring;

import java.util.ArrayList;
import java.util.List;

public class Space {
	private Point point;
	private int width, height;
	private List<Point> pointList = new ArrayList<Point>();

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Space(Point point, int width, int height) {
		this.point = point;
		this.width = width;
		this.height = height;
	}

	public List<Point> getPointList() {
		return pointList;
	}

	public void generatePoints(int num) {
		for (int i = 0; i < num; i++) {
			int x = Util.randomNumber(point.x(), point.x() + width);
			int y = Util.randomNumber(point.y(), point.y() + height);
			Point p = new Point(x, y);
			pointList.add(p);
		}
	}
}

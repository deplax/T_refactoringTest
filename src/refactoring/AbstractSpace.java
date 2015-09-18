package refactoring;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSpace {
	protected Point anchor;
	protected int width, height;
	protected List<Point> pointList = new ArrayList<Point>();
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Space getInstance(Point anchor, int width, int height) {
		return new RectSpace(anchor, width, height);
	}
	
	protected Boolean ensureAmount(Point p) {
		if (!pointList.contains(p)){
			pointList.add(p);
			return true;
		}
		return false;
	}
}

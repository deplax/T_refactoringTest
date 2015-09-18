package refactoring;

import java.util.List;

public class CircleSpace extends AbstractSpace implements Space {
	protected Boolean dividable = true;

	public CircleSpace(Point anchor, int width, int height) {
		super.anchor = anchor;
		super.width = width;
		super.height = height;
	}

	@Override
	public List<Point> getPointList() {
		return pointList;
	}

	@Override
	public void generatePoints(Integer amount) {
		Point center = getCenterPoint(anchor, width, height);
		while (0 < amount)
			if(ensureAmount(getPoint(center, amount)))
				amount--;
	}

	@Override
	public Boolean isDividable() {
		return dividable;
	}

	private Point getPoint(Point center, int i) {
		Point offsetPoint;
		if (i % 2 == 0)
			offsetPoint = getXoffset(width, height);
		else
			offsetPoint = getYoffset(width, height);
		return new Point(center.x() + offsetPoint.x(), center.y()
				+ offsetPoint.y());
	}

	private Point getXoffset(int width, int height) {
		int offsetX = Util.randomNumber(-width, +width);
		int temp = (int) Math.sqrt((double) (height * height - offsetX
				* offsetX));
		int offsetY = Util.randomNumber(-temp, +temp);
		Point offsetPoint = new Point(offsetX, offsetY);
		return offsetPoint;
	}

	private Point getYoffset(int width, int height) {
		int offsetY = Util.randomNumber(-height, +height);
		int temp = (int) Math
				.sqrt((double) (width * width - offsetY * offsetY));
		int offsetX = Util.randomNumber(-temp, +temp);
		Point offsetPoint = new Point(offsetX, offsetY);
		return offsetPoint;
	}

	private Point getCenterPoint(Point anchor, int width, int height) {
		int x = anchor.x() + width / 2;
		int y = anchor.y() + height / 2;
		Point centerPoint = new Point(x, y);
		return centerPoint;
	}
}

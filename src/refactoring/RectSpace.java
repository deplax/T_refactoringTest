package refactoring;

import java.util.List;

public class RectSpace extends AbstractSpace implements Space {

	protected Boolean dividable = true;

	public RectSpace(Point anchor, int width, int height) {
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
		while (0 < amount)
			if (ensureAmount(getPoint()))
				amount--;
	}

	@Override
	public Boolean isDividable() {
		return dividable;
	}

	private Point getPoint() {
		int x = Util.randomNumber(anchor.x(), anchor.x() + width);
		int y = Util.randomNumber(anchor.y(), anchor.y() + height);
		return new Point(x, y);
	}
}

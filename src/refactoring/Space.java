package refactoring;

import java.util.List;

public interface Space {
	public List<Point> getPointList();
	public void generatePoints(Integer amount);
	public int getWidth();
	public int getHeight();
	public Boolean isDividable();
	public Space getInstance(Point anchor, int width, int height);
}

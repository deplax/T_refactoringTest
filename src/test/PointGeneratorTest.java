package test;

import java.util.List;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import refactoring.Point;
import refactoring.PointGenerator;
import refactoring.Space;

public class PointGeneratorTest {
	
	PointGenerator pointGenerator;
	
	@Before
	public void before()
	{
		pointGenerator = new PointGenerator();
	}

	@Test
	public void checkPointCount() {
		int pointCnt = 100;
		Space space = new Space(new Point(0, 0), 800, 600);
		List<Point> pointList = pointGenerator.getPointList(space, pointCnt, 2);
		assertEquals(pointCnt, pointList.size());
		
	}

}

package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import refactoring.CircleSpace;
import refactoring.Point;
import refactoring.PointGenerator;
import refactoring.RectSpace;
import refactoring.Space;

public class PointGeneratorTest {

	PointGenerator pointGenerator;
	Space rectSpace;
	Space circleSpace;
	int pointCnt;
	int divide;
	int width = 800;
	int height = 600;

	@Before
	public void before() {
		pointCnt = 10000;
		divide = 5;
		pointGenerator = new PointGenerator();
		rectSpace = new RectSpace(new Point(0, 0), width, height);
		circleSpace = new CircleSpace(new Point(0, 0), width, height);
	}

	@Test
	public void countEntirePointRect() throws Exception {
		List<Point> pointList = pointGenerator.getPointList(rectSpace,
				pointCnt, divide);
		assertEquals(pointCnt, pointList.size());
	}

	@Test
	public void countEntirePointCircle() throws Exception {
		List<Point> pointList = pointGenerator.getPointList(circleSpace,
				pointCnt, divide);
		assertEquals(pointCnt, pointList.size());
	}

	@Test
	public void countSpace() throws Exception {
		Space spaces[] = pointGenerator.divideSpace(rectSpace, divide);
		assertEquals(divide * divide, spaces.length);
	}

	@Test
	public void isPointDuplicate() throws Exception {
		List<Point> pointList = pointGenerator.getPointList(rectSpace,
				pointCnt, divide);
		long uniqueCount = pointList.stream().distinct().count();
		assertEquals(pointCnt, uniqueCount);
	}

	@Test
	public void checkPointBaundary() throws Exception {
		List<Point> pointList = pointGenerator.getPointList(rectSpace,
				pointCnt, divide);
		for (Point point : pointList) {
			if(point.x() < 0 && point.x() > width)
				fail();
			if(point.y() < 0 && point.y() > height)
				fail();
		}
	}

	@Test
	public void countPointInSpace() throws Exception {
		Space spaces[] = pointGenerator.divideSpace(rectSpace, divide);
		for (Space space : spaces) {
			pointGenerator.generate(space, pointCnt / (divide * divide));
			assertEquals(pointCnt / (divide * divide), space.getPointList()
					.size());
		}
	}

}

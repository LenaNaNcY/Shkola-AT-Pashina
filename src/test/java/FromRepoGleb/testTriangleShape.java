package FromRepoGleb;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class testTriangleShape {
    @DataProvider(name = "detect")
    public Object[][] createDataShapeAndTriangle() {
        return new Object[][]{
                {8, new Triangle(3.0, 4.0, 5.0)},
                {8, new Triangle(3.0, 5.0, 4.0)},
                {8, new Triangle(5.0, 3.0, 4.0)},
                {2, new Triangle(5.0, 5.0, 5.0)},
                {2, new Triangle(5.0, 5.0, 2.0)},
                {2, new Triangle(5.0, 2.0, 5.0)},
                {2, new Triangle(2.0, 5.0, 5.0)},
                {4, new Triangle(2.0, 3.0, 4.0)},
        };
    }

    @Test(dataProvider = "detect")
    public void testShape(int shape, Triangle triangle) {
        Assert.assertEquals(triangle.detectTriangle(), shape);
    }
}

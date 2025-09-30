package FromRepoGleb;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class testTriangleException {
    @DataProvider(name = "negativeCreation")
    public Object[][] setUp() {
        return new Object[][]{
                {new Triangle(0.0, 1.0, 1.0)},
                {new Triangle(-5.0, 1.0, 5.0)},
                {new Triangle(1.0, 0.0, 5.0)},
                {new Triangle(1.0, -6.0, 5.0)},
                {new Triangle(1.0, 1.0, 0.0)},
                {new Triangle(1.0, 1.0, -6.0)},
                {new Triangle(1.0, 2.0, 3.0)},
                {new Triangle(1.0, 3.0, 2.0)},
                {new Triangle(3.0, 1.0, 2.0)},
        };
    }


    @Test(dataProvider = "negativeCreation",
            expectedExceptions = Exception.class)
    public void checkShapeTriangleExceptions(Triangle triangle) {
        triangle.detectTriangle();

    }

    @Test(dataProvider = "negativeCreation",
            expectedExceptions = Exception.class)
    public void checkSquareTriangleExceptions(Triangle triangle) {
        triangle.getSquare();

    }
}

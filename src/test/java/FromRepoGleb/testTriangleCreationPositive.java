package FromRepoGleb;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class testTriangleCreationPositive {
    @DataProvider(name = "positiveCreation")
    public Object[][] createPositiveTriangle() {
        return new Object[][]{
                {new Triangle(2.0, 3.0, 4.0)},
                {new Triangle(2.0, 2.0, 2.0)},
                {new Triangle(3.0, 4.0, 5.0)},
                {new Triangle(4.0, 3.0, 4.0)},
        };
    }

    @Test(dataProvider = "positiveCreation")
    public void checkTriangle(Triangle triangle) {
        Assert.assertTrue(triangle.checkTriangle());

    }
}

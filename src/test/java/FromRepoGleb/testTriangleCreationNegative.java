package FromRepoGleb;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class testTriangleCreationNegative {

    @DataProvider(name = "negativeCreation")
    public Object[][] createTriangleWithMsg() {
        return new Object[][]{
                {"a<=0",
                        new Triangle(0.0, 1.0, 1.0)},
                {"a<=0",
                        new Triangle(-5.0, 1.0, 5.0)},
                {"b<=0",
                        new Triangle(1.0, 0.0, 5.0)},
                {"b<=0",
                        new Triangle(1.0, -6.0, 5.0)},
                {"c<=0",
                        new Triangle(1.0, 1.0, 0.0)},
                {"c<=0",
                        new Triangle(1.0, 1.0, -6.0)},
                {"a+b<=c",
                        new Triangle(1.0, 2.0, 3.0)},
                {"a+c<=b",
                        new Triangle(1.0, 3.0, 2.0)},
                {"b+c<=a",
                        new Triangle(3.0, 1.0, 2.0)},
        };
    }

    @Test(dataProvider = "negativeCreation")
    public void checkTriangle(String msg, Triangle triangle) {
        Assert.assertFalse(triangle.checkTriangle());
        Assert.assertEquals(triangle.getMessage(), msg);

    }


}

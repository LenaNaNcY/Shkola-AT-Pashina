package FromRepoGleb;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

import java.util.ArrayList;
import java.util.Arrays;

public class testTriangleSquare {
    @DataProvider(name = "square")
    public Object[][] addDataTriangle() {

        return new Object[][]{
                {new ArrayList<Double>(Arrays.asList(2.0, 3.0, 4.0))},
                {new ArrayList<Double>(Arrays.asList(2.0, 2.0, 2.0))},
                {new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0))},
                {new ArrayList<Double>(Arrays.asList(4.0, 3.0, 4.0))},
        };

    }

    @Test(dataProvider = "square")
    public void checkSquare(ArrayList<Double> dataSide) {
        double a = dataSide.get(0);
        double b = dataSide.get(1);
        double c = dataSide.get(2);

        Triangle triangle = new Triangle(a, b, c);

        double p = (a + b + c) / 2;
        double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        Assert.assertEquals(square, triangle.getSquare(), 0.01);

    }
}

package calculator;

import Operators.Suma;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuma {


    @Test
    public void suma(){
        Suma suma = new Suma();
        int result = suma.add(0,2);
        System.out.println(result + "  4");
        Assert.assertEquals(result, 2);
    }
}

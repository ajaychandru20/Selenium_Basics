import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateTest {

    @Test
    public void addTest(){
        Calculator cal = new Calculator();
        int result = cal.addNumbers(2,4);
        Assertions.assertEquals(6,result);
    }

    @Test
    public void subTest(){
        Calculator cal = new Calculator();
        int result = cal.subNumbers(2,4);
        Assertions.assertEquals(-2,result);
    }

}

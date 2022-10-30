import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class FelineTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void eatMeatReturnsValidValue() throws Exception {
        Feline feline = new Feline();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");

        List<String> actualResult = feline.eatMeat();

        Assert.assertEquals("Хищник ест не мясо, птицу или рыбу", expectedResult, actualResult);
    }

    @Test
    public void getKittensWithoutParametersReturnsValidValue() throws Exception {
        Feline feline = new Feline();
        int expectedResult = 1;

        int actualResult = feline.getKittens();

        Assert.assertEquals("Неверное количество детей", expectedResult, actualResult);
    }

    @Test
    public void getKittensWithParametersReturnsValidValue() throws Exception {
        Feline feline = new Feline();
        int expectedResult = 40;

        int actualResult = feline.getKittens(40);

        Assert.assertEquals("Неверное количество детей", expectedResult, actualResult);
    }

    @Test
    public void getFamilyReturnsValidValue() throws Exception {
        Feline feline = new Feline();
        String expectedResult = "Кошачьи";

        String actualResult = feline.getFamily();

        Assert.assertEquals("Неверное название семейства", expectedResult, actualResult);
    }
}

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class CatTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsValidValue() {
        Cat cat = new Cat(feline);
        String expectedResult = "Мяу";

        String actualResult = cat.getSound();

        Assert.assertEquals("Кошка не мяукает:(", expectedResult, actualResult);
    }

    @Test
    public void getFoodReturnsValidValue() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");

        List<String> actualResult = cat.getFood();

        Assert.assertEquals("Кошка ест не мясо, птицу или рыбу", expectedResult, actualResult);
    }
}

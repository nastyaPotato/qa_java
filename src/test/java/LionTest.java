import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean result;
    private static final String FEMALE = "Самка";
    private static final String MALE = "Самец";

    public LionTest(String sex, boolean result) {
        this.sex = sex;
        this.result=result;
    }

    @Parameterized.Parameters
    public static Object[][] getInputs() {
        return new Object[][]{
                {MALE, true},
                {FEMALE, false},
        };

    }

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void doesHaveManeReturnsValidValue() throws Exception {
        Lion lion = new Lion(sex, feline);

        boolean actualResult = lion.doesHaveMane();

        Assert.assertEquals("Неверное сочетание пола и наличия гривы", result, actualResult);
    }


    @Test
    public void getFoodReturnsValidValue() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");

        List<String> actualResult = lion.getFood();

        Assert.assertEquals("Хищник ест не мясо, птицу или рыбу", expectedResult, actualResult);
    }

    @Test
    public void getKittensReturnsValidValue() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedResult = 1;

        int actualResult = lion.getKittens();

        Assert.assertEquals("Неверное количество детей", expectedResult, actualResult);
    }

    @Test
    public void constructorThrowsException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Тест", feline);
        });
    }

}

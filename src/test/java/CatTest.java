import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline; // Мок для Feline

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSound_ReturnsMeow() {
        assertEquals("Должен вернуть 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void getFood_ReturnsFelineFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals("Должен вернуть еду хищника", expectedFood, cat.getFood());
    }

    @Test(expected = Exception.class)
    public void getFood_ThrowsException() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка"));
        cat.getFood();
    }
}

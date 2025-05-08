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

@RunWith(MockitoJUnitRunner.class) // Указываем, что тесты будут запускаться с использованием MockitoJUnitRunner, который обеспечивает инициализацию моков
public class CatTest {

    private Cat cat; // Объект Cat для тестирования

    @Mock
    private Feline feline; // Мок для Feline (создаем мок-объект интерфейса Feline)



    @Before // Аннотация, указывающая, что метод setUp() должен быть выполнен перед каждым тестовым методом
    public void setUp() {
        cat = new Cat(feline); // Создаем объект Cat, передавая в конструктор мок-объект Feline.  Это выполняется перед каждым тестом.
    }

    @Test // Аннотация, указывающая, что метод getSoundReturnsMeow() является тестовым методом
    public void getSoundReturnsMeow() { // Тест для проверки метода getSound()
        assertEquals("Должен вернуть 'Мяу'", "Мяу", cat.getSound()); // Проверяем, что getSound() возвращает строку "Мяу".  Используем assertEquals для сравнения ожидаемого и фактического результатов.
    }

    @Test // Аннотация, указывающая, что метод getFoodReturnsFelineFood() является тестовым методом
    public void getFoodReturnsFelineFood() throws Exception { // Тест для проверки метода getFood()
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба"); // Создаем список ожидаемой еды
        when(feline.eatMeat()).thenReturn(expectedFood); // Настраиваем поведение мока: когда у feline вызывается eatMeat(), возвращаем expectedFood.  Используем when() и thenReturn() для мокирования.
        assertEquals("Должен вернуть еду хищника", expectedFood, cat.getFood()); // Проверяем, что getFood() возвращает ожидаемый список еды.
    }

    @Test(expected = Exception.class) // Аннотация, указывающая, что ожидается выброс исключения типа Exception
    public void getFoodThrowsException() throws Exception { // Тест для проверки, что getFood() выбрасывает исключение
        when(feline.eatMeat()).thenThrow(new Exception("Ошибка")); // Настраиваем поведение мока: когда у feline вызывается eatMeat(), выбрасываем исключение "Ошибка".  Используем when() и thenThrow() для мокирования исключений.
        cat.getFood(); // Вызываем метод getFood(), который, как ожидается, должен выбросить исключение.  Если исключение не выброшено, тест провалится.
    }
}

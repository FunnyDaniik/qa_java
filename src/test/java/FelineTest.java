import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class) // Указываем, что тесты будут запускаться с использованием MockitoJUnitRunner, который обеспечивает инициализацию моков
public class FelineTest {

    @Test // Указываем, что метод eatMeatReturnsPredatorFood() является тестовым методом
    public void eatMeatReturnsPredatorFood() throws Exception { // Тест для проверки метода eatMeat()
        Feline feline = new Feline(); // Создаем экземпляр Feline для тестирования
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба"); // Создаем список ожидаемой еды для хищника
        assertEquals("Должен вернуть список еды для хищника", expected, feline.eatMeat()); // Проверяем, что метод eatMeat() возвращает ожидаемый список еды.  Используем assertEquals для сравнения ожидаемого и фактического результатов.
    }

    @Test // Указываем, что метод getFamilyReturnsFelineFamily() является тестовым методом
    public void getFamilyReturnsFelineFamily() { // Тест для проверки метода getFamily()
        Feline feline = new Feline(); // Создаем экземпляр Feline для тестирования
        assertEquals("Должен вернуть семейство кошачьих", "Кошачьи", feline.getFamily()); // Проверяем, что метод getFamily() возвращает строку "Кошачьи".
    }

    @Test // Указываем, что метод getKittensWithoutArgsReturnsOneKitten() является тестовым методом
    public void getKittensWithoutArgsReturnsOneKitten() { // Тест для проверки метода getKittens() без аргументов
        Feline feline = new Feline(); // Создаем экземпляр Feline для тестирования
        assertEquals("Должен вернуть 1 котенка по умолчанию", 1, feline.getKittens()); // Проверяем, что метод getKittens() без аргументов возвращает 1.
    }
}

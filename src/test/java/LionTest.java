import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class) // Указываем, что тесты будут запускаться с использованием MockitoJUnitRunner, который обеспечивает инициализацию моков
public class LionTest {

    @Mock // Указываем, что поле felineMock будет мок-объектом
    private Feline felineMock; // Мок-объект класса Feline

    private String sex; // Поле для хранения пола льва (не final, т.к. может меняться в setUp)

    @Before // Указываем, что метод setUp() должен быть выполнен перед каждым тестовым методом
    public void setUp() {
        felineMock = Mockito.mock(Feline.class); // Создаем мок-объект Feline перед каждым тестом
    }

    @Test // Указываем, что метод constructorInvalidSexThrowsException() является тестовым методом
    public void constructorInvalidSexThrowsException() { // Тест для проверки, что конструктор выбрасывает исключение при недопустимом значении пола
        Exception exception = assertThrows(Exception.class, () -> new Lion("Недопустимый", felineMock)); // Пытаемся создать объект Lion с недопустимым полом, ожидаем выброс исключения
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage()); // Проверяем, что сообщение исключения соответствует ожидаемому
    }

    @Test // Указываем, что метод getKittensReturnsFelineKittens() является тестовым методом
    public void getKittensReturnsFelineKittens() throws Exception { // Тест для проверки, что getKittens() возвращает количество котят, полученное от Feline
        when(felineMock.getKittens()).thenReturn(3); // Настраиваем поведение мок-объекта: getKittens() должен возвращать 3
        Lion lion = new Lion("Самец", felineMock); // Создаем объект Lion с мок-объектом Feline
        assertEquals("Должен вернуть количество котят от Feline", 3, lion.getKittens()); // Проверяем, что getKittens() возвращает 3
    }

    @Test // Указываем, что метод getFoodReturnsFelineFood() является тестовым методом
    public void getFoodReturnsFelineFood() throws Exception { // Тест для проверки, что getFood() возвращает еду, полученную от Feline
        when(felineMock.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба")); // Настраиваем поведение мок-объекта: eatMeat() должен возвращать список еды
        Lion lion = new Lion("Самка", felineMock); // Создаем объект Lion с мок-объектом Feline
        assertEquals("Должен вернуть еду от Feline", Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood()); // Проверяем, что getFood() возвращает ожидаемый список еды
    }

    @Test // Указываем, что метод getFoodThrowsException() является тестовым методом
    public void getFoodThrowsException() throws Exception { // Тест для проверки, что getFood() выбрасывает исключение, если Feline выбрасывает исключение
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка")); // Настраиваем поведение мок-объекта: eatMeat() должен выбрасывать исключение
        Lion lion = new Lion("Самка", felineMock); // Создаем объект Lion с мок-объектом Feline
        assertThrows(Exception.class, () -> lion.getFood()); // Вызываем метод getFood(), ожидаем выброс исключения
    }
}

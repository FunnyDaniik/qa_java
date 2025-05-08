import com.example.Feline;
import com.example.Lion;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class) // Указываем, что тесты будут запускаться с использованием Parameterized runner'а
public class LionParameterizedTest {

    private final String sex; // Объявляем поле sex, представляющее пол льва (параметр теста)
    private final boolean expectedMane; // Объявляем поле expectedMane, представляющее ожидаемое наличие гривы (параметр теста)

    public LionParameterizedTest(String sex, boolean expectedMane) { // Конструктор для параметризованного теста
        this.sex = sex; // Инициализируем поле sex
        this.expectedMane = expectedMane; // Инициализируем поле expectedMane
    }

    @Parameterized.Parameters // Указываем, что метод data() является источником данных для параметризованного теста
    public static Collection<Object[]> data() { // Метод, возвращающий коллекцию массивов объектов, представляющих тестовые данные
        return Arrays.asList(new Object[][]{ // Создаем и возвращаем список массивов объектов
                {"Самец", true}, // Первый набор данных: пол "Самец", ожидаемое наличие гривы true
                {"Самка", false} // Второй набор данных: пол "Самка", ожидаемое наличие гривы false
        });
    }

    @Test // Указываем, что метод constructorValidSexSetsManeCorrectly() является тестовым методом
    public void constructorValidSexSetsManeCorrectly() throws Exception { // Проверяем, что конструктор правильно устанавливает наличие гривы в зависимости от пола
        // Так как конструктор принимает Feline, создаем его экземпляр
        Feline feline = new Feline(); // Создаем экземпляр класса Feline
        Lion lion = new Lion(sex, feline); // Создаем объект Lion с заданным полом и объектом Feline
        assertEquals("Грива должна соответствовать полу", expectedMane, lion.doesHaveMane()); // Проверяем, что наличие гривы соответствует ожидаемому
    }
}

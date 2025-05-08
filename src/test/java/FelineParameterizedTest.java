import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // Указываем, что тесты будут запускаться с использованием Parameterized runner'а
public class FelineParameterizedTest { // Объявляем класс FelineTestParameterized для тестирования класса Feline

    private final Feline feline = new Feline(); // Создаем экземпляр класса Feline, который будем тестировать
    private final int kittensCount; // Объявляем переменную для хранения количества котят, передаваемого в метод getKittens(int kittensCount)
    private final int expectedKittens; // Объявляем переменную для хранения ожидаемого количества котят

    public FelineParameterizedTest(int kittensCount, int expectedKittens) { // Создаем конструктор для класса FelineTestParameterized, принимающий количество котят и ожидаемое количество котят
        this.kittensCount = kittensCount; // Инициализируем переменную kittensCount
        this.expectedKittens = expectedKittens; // Инициализируем переменную expectedKittens
    }

    @Parameterized.Parameters // Указываем, что метод data() предоставляет данные для параметризации тестов
    public static Collection<Object[]> data() { // Создаем статический метод data(), возвращающий коллекцию массивов объектов
        return Arrays.asList(new Object[][]{ // Возвращаем список массивов, содержащих данные для тестов
                {0, 0}, // Первый набор данных: kittensCount = 0, expectedKittens = 0
                {1, 1}, // Второй набор данных: kittensCount = 1, expectedKittens = 1
                {5, 5}, // Третий набор данных: kittensCount = 5, expectedKittens = 5
                {10, 10} // Четвертый набор данных: kittensCount = 10, expectedKittens = 10
        });
    }


    @Test // Указываем, что метод getKittensWithArgs_ReturnsSpecifiedCount() является тестовым
    public void getKittensWithArgsReturnsSpecifiedCount() { // Создаем тестовый метод getKittensWithArgs_ReturnsSpecifiedCount(), проверяющий, что метод getKittens(int kittensCount) возвращает указанное количество котят
        assertEquals("Должен вернуть указанное количество котят", expectedKittens, feline.getKittens(kittensCount)); // Сравниваем фактический и ожидаемый результаты
    }
}

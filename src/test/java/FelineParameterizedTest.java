import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // Указываем, что тесты будут запускаться с использованием Parameterized runner'а
public class FelineTestParameterized { // Объявляем класс FelineTestParameterized для тестирования класса Feline

    private final Feline feline = new Feline(); // Создаем экземпляр класса Feline, который будем тестировать
    private final int kittensCount; // Объявляем переменную для хранения количества котят, передаваемого в метод getKittens(int kittensCount)
    private final int expectedKittens; // Объявляем переменную для хранения ожидаемого количества котят

    public FelineTestParameterized(int kittensCount, int expectedKittens) { // Создаем конструктор для класса FelineTestParameterized, принимающий количество котят и ожидаемое количество котят
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

    @Test // Указываем, что метод eatMeat_ReturnsPredatorFood() является тестовым
    public void eatMeat_ReturnsPredatorFood() throws Exception { // Создаем тестовый метод eatMeat_ReturnsPredatorFood(), проверяющий, что метод eatMeat() возвращает список еды для хищника
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба"); // Создаем список ожидаемой еды для хищника
        assertEquals("Должен вернуть список еды для хищника", expected, feline.eatMeat()); // Сравниваем фактический и ожидаемый результаты
    }

    @Test // Указываем, что метод getFamily_ReturnsFelineFamily() является тестовым
    public void getFamily_ReturnsFelineFamily() { // Создаем тестовый метод getFamily_ReturnsFelineFamily(), проверяющий, что метод getFamily() возвращает семейство кошачьих
        assertEquals("Должен вернуть семейство кошачьих", "Кошачьи", feline.getFamily()); // Сравниваем фактический и ожидаемый результаты
    }

    @Test // Указываем, что метод getKittensWithoutArgs_ReturnsOneKitten() является тестовым
    public void getKittensWithoutArgs_ReturnsOneKitten() { // Создаем тестовый метод getKittensWithoutArgs_ReturnsOneKitten(), проверяющий, что метод getKittens() без аргументов возвращает 1 котенка
        assertEquals("Должен вернуть 1 котенка по умолчанию", 1, feline.getKittens()); // Сравниваем фактический и ожидаемый результаты
    }

    @Test // Указываем, что метод getKittensWithArgs_ReturnsSpecifiedCount() является тестовым
    public void getKittensWithArgs_ReturnsSpecifiedCount() { // Создаем тестовый метод getKittensWithArgs_ReturnsSpecifiedCount(), проверяющий, что метод getKittens(int kittensCount) возвращает указанное количество котят
        assertEquals("Должен вернуть указанное количество котят", expectedKittens, feline.getKittens(kittensCount)); // Сравниваем фактический и ожидаемый результаты
    }
}

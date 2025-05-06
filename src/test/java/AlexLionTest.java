import com.example.AlexLion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class) // Указываем, что тесты будут запускаться с использованием MockitoJUnitRunner
public class AlexLionTest {

    @Mock
    private Predator predator; // Мок для Predator (создаем мок-объект интерфейса Predator)

    private AlexLion alexLion; // Объект AlexLion для тестирования (экземпляр класса AlexLion, который будем тестировать)

    @Before // Аннотация, указывающая, что метод setUp() должен быть выполнен перед каждым тестовым методом
    public void setUp() throws Exception {
        alexLion = new AlexLion(predator); // Создаем AlexLion с моком Predator (инициализируем объект AlexLion, передавая ему мок-объект predator)
    }

    @Test // Аннотация, указывающая, что метод getFriends_ReturnsCorrectListOfFriends() является тестовым методом
    public void getFriends_ReturnsCorrectListOfFriends() { // Проверяем, что getFriends() возвращает правильный список друзей (тест проверяет, что метод getFriends() класса AlexLion возвращает ожидаемый список друзей)
        List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман"); // Ожидаемый список друзей (создаем список строк, который ожидаем получить от метода getFriends())
        assertEquals("Список друзей должен соответствовать ожидаемому", expectedFriends, alexLion.getFriends()); // Сравниваем фактический и ожидаемый список друзей (проверяем, что метод getFriends() возвращает ожидаемый список)
    }

    @Test // Аннотация, указывающая, что метод getPlaceOfLiving_ReturnsNewYorkZoo() является тестовым методом
    public void getPlaceOfLiving_ReturnsNewYorkZoo() { // Проверяем, что getPlaceOfLiving() возвращает "New York Zoo" (тест проверяет, что метод getPlaceOfLiving() класса AlexLion возвращает строку "New York Zoo")
        assertEquals("Место жительства должно быть 'New York Zoo'", "New York Zoo", alexLion.getPlaceOfLiving()); // Сравниваем фактическое и ожидаемое место жительства (проверяем, что метод getPlaceOfLiving() возвращает ожидаемую строку)
    }

    @Test // Аннотация, указывающая, что метод getKittens_ReturnsZero() является тестовым методом
    public void getKittens_ReturnsZero() { // Проверяем, что getKittens() возвращает 0 (тест проверяет, что метод getKittens() класса AlexLion всегда возвращает 0, так как у Алекса нет котят)
        assertEquals("У Алекса не должно быть котят", 0, alexLion.getKittens()); // Сравниваем фактическое и ожидаемое количество котят (проверяем, что метод getKittens() возвращает 0)
    }

    @Test // Аннотация, указывающая, что метод doesHaveMane_ReturnsTrue() является тестовым методом
    public void doesHaveMane_ReturnsTrue() { // Проверяем, что doesHaveMane() возвращает true (т.к. Алекс - самец) (тест проверяет, что метод doesHaveMane() класса AlexLion возвращает true, так как Алекс всегда самец и, следовательно, имеет гриву)
        assertEquals("У Алекса должна быть грива (он самец)", true, alexLion.doesHaveMane()); // Сравниваем фактическое и ожидаемое значение наличия гривы (проверяем, что метод doesHaveMane() возвращает true)
    }
}

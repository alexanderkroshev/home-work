package com.sbrf.reboot.collections;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {


    /*
     * Задача.
     * Имеется список лучших студентов вуза.
     *
     * 1. Иванов
     * 2. Петров
     * 3. Сидоров
     *
     * В новом семестре по результатам подсчетов оценок в рейтинг на 1 место добавился новый студент - Козлов.
     * Теперь в рейтинге участвуют 4 студента.
     * (Предполагаем что в рейтинг можно попасть только получив достаточное количество балов, что бы занять 1 место).
     *
     * Вопрос.
     * Какую коллекцию из реализаций интерфейса Collection вы предпочтете для текущего хранения и использования списка студентов?
     *
     * Проинициализируйте students, добавьте в нее 4 фамилии студентов что бы тест завершился успешно.
     */
    @Test
    public void addStudentToRating() {

        List<String> students = null;

        students = new ArrayList<>(Arrays.asList("Kozlov", "Ivanov", "Petrov", "Sidorov"));

        assertEquals(4, students.size());
    }

    /*
     * Задача.
     * Вы коллекционируете уникальные монеты.
     * У вас имеется специальный бокс с секциями, куда вы складываете монеты в хаотичном порядке.
     *
     * Вопрос.
     * Какую коллекцию из реализаций интерфейса Collection вы предпочтете использовать для хранения монет в боксе.
     *
     * Проинициализируйте moneyBox, добавьте в нее 10 монет что бы тест завершился успешно.
     */
    @Test
    public void addMoneyToBox() {

        Set<Integer> moneyBox = null;

        moneyBox = new HashSet<>(Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 300, 500));

        assertEquals(10, moneyBox.size());
    }

    /*
     * Задача.
     * Имеется книжная полка.
     * Периодически вы берете книгу для чтения, затем кладете ее на свое место.
     *
     * Вопрос.
     * Какую коллекцию из реализаций интерфейса Collection вы предпочтете использовать для хранения книг.
     *
     * Проинициализируйте bookshelf, добавьте в нее 3 книги что бы тест завершился успешно.
     */
    @Test
    public void addBookToShelf() {
        class Book {
        }

        List<Book> bookshelf = null;

        bookshelf = new ArrayList<>(Arrays.asList(new Book(), new Book(), new Book()));

        assertEquals(3, bookshelf.size());
    }

    /*
     * Задача на 5+
     * Пример реального проекта, необходимо было из шаблонов картинок сгенерировать 1000 картинок с людьми
     * (шаблоны накладываются друг на друга).
     * Были рандомно сгенерированы цифры, которые были присвоены полям класса Person,
     * исходя из которых выбирался шаблон конкретной части тела (face, eyes...).
     * Далее генерировались картинки, после генерации картинок информация по каждой картинке записывалась в отдельный файл txt.
     * В данной задаче лучше всего было использовать упорядоченную коллекцию, чтобы зная индекс сгенерированной
     * картинки получить информацию о ней из коллекции, в которой хранятся <Picture>
     * В этой коллекции могут быть только уникальные элементы, так как мы не хотим сгенерировать 2 одинаковые картинки.
     * LinkedHashMap- подходящая коллекция.
     *
     *
     */
    @Test
    public void addPicture() {

        @AllArgsConstructor
        class Person {

            private int face;
            private int eyes;
            private int brow;
            private int mouth;

        }

        LinkedHashSet<Person> pictures = null;

        pictures = new LinkedHashSet<>();
        pictures.add(new Person(1, 3, 4, 2));
        pictures.add(new Person(3, 4, 2, 3));
        pictures.add(new Person(2, 2, 1, 4));

        assertEquals(3, pictures.size());
    }


}

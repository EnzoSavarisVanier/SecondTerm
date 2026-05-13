import org.junit.jupiter.api.Test;
import org.example.Student;
import org.example.Library;
import static org.junit.jupiter.api.Assertions.*;

public class MethodTest {
    @Test
    void searchItemStreamTestValid() {
        Library library = new Library();
        library.initLibrary("src/main/resources/items.csv", "src/main/resources/users.csv");
        Student student = new Student("S1", "John");
        assertTrue(student.searchItemStream("Evil Trump").isPresent());
    }

    @Test
    void searchItemStreamTestInvalid() {
        Student student = new Student("S1", "John");
        assertFalse(student.searchItemStream("Evill Trump").isPresent());
    }

    @Test
    void searchItemRecursiveTestValid() {
        Student student = new Student("S1", "John");
        assertTrue(student.searchItemRecursive("Evil Trump").isPresent());
    }

    @Test
    void searchItemRecursiveTestInvalid() {
        Student student = new Student("S1", "John");
        assertFalse(student.searchItemRecursive("Evill Trump").isPresent());
    }

    @Test
    void sortItemsByTitle() {
        Library library = new Library();
        library.initLibrary("src/main/resources/items.csv", "src/main/resources/users.csv");
        assertEquals("1984", library.sortItemsByTitle().getFirst().getTitle());
    }

    @Test
    void sortItemsById() {
        Library library = new Library();
        library.initLibrary("src/main/resources/items.csv", "src/main/resources/users.csv");
        assertEquals("To Kill a Mockingbird", library.sortItemsById().getFirst().getTitle());
    }

    @Test
    void sortUsersByName() {
        Library library = new Library();
        library.initLibrary("src/main/resources/items.csv", "src/main/resources/users.csv");
        assertEquals("Alice Johnson", library.sortUsersByName().getFirst().getName());
    }

    @Test
    void sortUsersById() {
        Library library = new Library();
        library.initLibrary("src/main/resources/items.csv", "src/main/resources/users.csv");
        assertEquals("Carol White", library.sortUsersById().getFirst().getName());
    }
}
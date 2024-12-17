package lab2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LabTests {

    // Test to verify students
    @Test
    public void testStudentCreation() throws InvalidIDException {
        Student student = new Student("John", "Doe", 1);
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
    }
   
    //test first name
    @Test
    public void testChangeStudentFirstName() throws InvalidIDException {
        Student student = new Student("John", "Doe", 1);
        student.setFirstName("Jane");
        assertEquals("Jane", student.getFirstName());
    }
    
    //test last name
    @Test
    public void testChangeStudentLastName() throws InvalidIDException {
        Student student = new Student("John", "Doe", 1);
        student.setLastName("Smith");
        assertEquals("Smith", student.getLastName());
    }

    
    @Test(expected = InvalidIDException.class)
    public void testInvalidIDException() throws InvalidIDException {
        new Student("Invalid", "Student", 0);  
    }

    @Test
    public void testAddStudentToUniversity() throws InvalidIDException, DuplicateIDException {
        University university = new University("Test University");
        university.addStudent("Alice", "Johnson", 1);
        assertEquals(1, university.getNumberOfStudents());
    }

    @Test(expected = DuplicateIDException.class)
    public void testDuplicateIDException() throws InvalidIDException, DuplicateIDException {
        University university = new University("Test University");
        university.addStudent("Alice", "Johnson", 1);
        university.addStudent("Bob", "Williams", 1);  
    }

    @Test(expected = StudentNotFoundException.class)
    public void testStudentNotFoundException() throws StudentNotFoundException {
        University university = new University("Test University");
        university.removeStudent(999);  
    }
}

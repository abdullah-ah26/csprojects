package lab2;

public class Main {
    public static void main(String[] args) {
        University university = new University("Test University");

        try {
            university.addStudent("Alice", "Johnson", 1);
            university.addStudent("Bob", "Williams", 2);
            university.addStudent("Charlie", "Brown", 3);

            System.out.println("List of students:\n" + university.listOfStudents());

            university.changeStudentFirstName(2, "Robert");
            System.out.println("After changing Bob's first name to Robert:\n" + university.listOfStudents());
            
            university.removeStudent(1);
            System.out.println("After removing Alice:\n" + university.listOfStudents());

            // DuplicateIDException Test
            try {
                university.addStudent("Duplicate", "Student", 2);
            } catch (DuplicateIDException e) {
                System.out.println("Caught expected exception: " + e.getMessage());
            }

            // StudentNotFoundException Test 
            try {
                university.removeStudent(10);  // Non-existent ID
            } catch (StudentNotFoundException e) {
                System.out.println("Caught expected exception: " + e.getMessage());
            }

        } catch (InvalidIDException | DuplicateIDException | StudentNotFoundException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }
}
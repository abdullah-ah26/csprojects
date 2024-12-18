package lab2;

import java.util.ArrayList;

public class University {
    private String universityName;
    private ArrayList<Student> allStudents;

    public University(String universityName) {
        this.universityName = universityName;
        this.allStudents = new ArrayList<>();
    }

    //number of students
    public int getNumberOfStudents() {
        return allStudents.size();
    }

    public void addStudent(String firstName, String lastName, int id) throws InvalidIDException, DuplicateIDException {
        if (id <= 0) {
            throw new InvalidIDException("ID must be greater than 0");
        }

        for (Student student : allStudents) {
            if (student.hasId(id)) {
                throw new DuplicateIDException("Student with ID " + id + " already exists");
            }
        }

        Student newStudent = new Student(firstName, lastName, id);
        allStudents.add(newStudent);
    }

    // Removes a student by id
    public void removeStudent(int id) throws StudentNotFoundException {
        for (Student student : allStudents) {
            if (student.hasId(id)) {
                allStudents.remove(student);
                return;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found");
    }

    // Change a student's first name 
    public void changeStudentFirstName(int id, String newFirstName) throws StudentNotFoundException {
        for (Student student : allStudents) {
            if (student.hasId(id)) {
                student.setFirstName(newFirstName);
                return;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found");
    }

    // Changes a student's last name
    public void changeStudentLastName(int id, String newLastName) throws StudentNotFoundException {
        for (Student student : allStudents) {
            if (student.hasId(id)) {
                student.setLastName(newLastName);
                return;
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found");
    }

    public String listOfStudents() {
        if (allStudents.isEmpty()) {
            return "No Students";
        }

        StringBuilder list = new StringBuilder();
        for (Student student : allStudents) {
            list.append(student.getFirstName()).append(" ").append(student.getLastName()).append("\n");
        }
        return list.toString();
    }
}

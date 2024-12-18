package lab2;

public class Student {
    private String firstName;
    private String lastName;
    private int id;

    public Student(String firstName, String lastName, int id) throws InvalidIDException {
        if (id <= 0) {
            throw new InvalidIDException("ID must be greater than 0");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) throws InvalidIDException {
        if (id <= 0) {
            throw new InvalidIDException("ID must be greater than 0");
        }
        this.id = id;
    }

    //manual id check
    public boolean hasId(int id) {
        return this.id == id;
    }
}

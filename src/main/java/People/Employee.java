package People;


public class Employee {
    public Employee() {
    }
//    @JacksonXmlProperty(isAttribute = true)
    public String firstName;
    public String lastName;
    public String patronimic;
    public int age;
    public int experience;
    public static int id;

    @Override
    public String toString() {
        return "Employee{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", patronimic=" + patronimic +
                ", age=" + age +
                ", experience=" + experience + '\'' +
                '}';
    }

    public Employee (String firstName, String lastName, String patronimic, int age, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronimic = patronimic;
        this.age = age;
        this.experience = experience;
        id++;
    }
}
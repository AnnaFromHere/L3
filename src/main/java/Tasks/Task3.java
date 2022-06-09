package Tasks;

import People.Employee;
import Other.Address;
import Other.Office;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Task3 {
    public static void main(String[] args) throws IOException {
        String[] countries = {"Russia", "USA", "Spain"};
        String[] cities = {"Moscow", "Odessa", "Izhevsk"};
        String[] streets = {"South", "West", "Square"};
        final int houses = 100;
        final int floors = 10;
        final int flats = 100;
        final int age = 80;
        final int experience = 60;
        final int numberOfOffices = 100;
        String[] firstNames = {"Anna", "Ivan", "Jane", "Vladimir"};
        String[] lastNames = {"Smith", "Smirnov", "Holms", "Ivanov"};
        String[] patronimics = {"Sergeevna", "Ivanovich", "Nikolaevich"};
        Random random = new Random();
        List<Object> offices = new ArrayList<>();
        for (int currNumberofOffices = 0; currNumberofOffices < numberOfOffices; currNumberofOffices++) {
            List<Object> employees = new ArrayList<>();
            int randomIndexForCountry = random.nextInt(countries.length);
            int randomIndexForCity = random.nextInt(cities.length);
            int randomIndexForStreet = random.nextInt(streets.length);
            int randomHouse = random.nextInt(houses);
            int randomFloor = random.nextInt(floors);
            int randomFlat = random.nextInt(flats);
            Address address = new Address(
                    countries[randomIndexForCountry],
                    cities[randomIndexForCity],
                    streets[randomIndexForStreet],
                    randomHouse,
                    randomFloor,
                    randomFlat
            );
            int randomIndexForName = random.nextInt(firstNames.length);
            int randomIndexForLastName = random.nextInt(lastNames.length);
            int randomIndexForPatronimic = random.nextInt(patronimics.length);
            int randomAge = random.nextInt(age);
            int randomExperience = random.nextInt(experience);
            Employee employee1 = new Employee(firstNames[randomIndexForName], lastNames[randomIndexForLastName], patronimics[randomIndexForPatronimic], randomAge, randomExperience);
            Employee employee2 = new Employee(firstNames[randomIndexForName], lastNames[randomIndexForLastName], patronimics[randomIndexForPatronimic], randomAge, randomExperience);
            employees.add(employee1);
            employees.add(employee2);
            Office office = new Office(address, employees);
            offices.add(office);
        }

        FileWriter fileWriter = new FileWriter("src/offices.xml");
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(fileWriter, offices);
        FileReader fileReader = new FileReader("src/offices.xml");
        offices = objectMapper.readValue(fileReader, List.class);
        System.out.println(offices.toString());

    }
}

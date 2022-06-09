package Other;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

public class Office {
    public Office() {
    }

    @Override
    public String toString() {
        return "Office{" +
                "address=" + address +
                ", employees=" + employees + '\'' +
                '}';
    }

    public Office(Address address, List<Object> employees) {
        this.employees = employees;
        this.address = address;
    }
    @JacksonXmlElementWrapper(localName = "employees")
    @JacksonXmlProperty(localName = "employee")
    public List<Object> employees;


    public Address address;
 }
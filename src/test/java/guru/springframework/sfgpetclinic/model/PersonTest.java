package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest {

    @Test
    void groupedAssertions(){
        Person person = new Person(1L, "Joe", "Buck" );
        assertAll("Person assertions",
                ()-> assertEquals( Long.valueOf(1L), person.getId(),"Id comparison failed"),
                ()-> assertEquals("Joe", person.getFirstName(), "First name comparison failed"),
                ()-> assertEquals("Buck",
                        person.getLastName(), "Last name comparison failed"));
    }
    @Test
    void groupedFailedAssertions(){
        Person person = new Person(1L, "Joe", "Buck" );
        assertAll("Person assertions",
                ()-> assertEquals( Long.valueOf(1L), person.getId(),"Id comparison failed"),
                ()-> assertEquals("Je", person.getFirstName(), "First name comparison failed"),
                ()-> assertEquals("Bck",
                        person.getLastName(), "Last name comparison failed"));
    }

}
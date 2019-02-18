package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

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

    @RepeatedTest(value = 10, name = "{displayName}: {currentRepetition} / {totalRepetitions}")
    @DisplayName("My repeated test")
    void repeatedTests(){
        //TODO -impl
    }
}
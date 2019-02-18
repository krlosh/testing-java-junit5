package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

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

    @RepeatedTest(5)
    void repeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ":"+repetitionInfo.getCurrentRepetition());
    }
}
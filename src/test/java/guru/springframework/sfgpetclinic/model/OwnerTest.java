package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

class OwnerTest {

    @Test
    void dependantAssertions() {
        Owner ownerTest = new Owner(1l, "Joe", "Buck");
        ownerTest.setCity("Key West");
        ownerTest.setTelephone("12312312322");
        assertAll("Properties test",
                ()-> assertAll("Person properties",
                        () -> assertEquals("Joe", ownerTest.getFirstName(), "First name did not match"),
                        () -> assertEquals("Buck", ownerTest.getLastName(), "Last name did not match")
                ),
                ()->assertAll("Owner properties",
                        () -> assertEquals("Key West",ownerTest.getCity(), "City did not match"),
                        () -> assertEquals("12312312322",ownerTest.getTelephone(), "Telephone did not match")
                )
        );

        assertThat(ownerTest.getCity(), is("Key West"));
    }
}
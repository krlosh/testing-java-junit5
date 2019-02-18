package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

class OwnerTest implements ModelTests {

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

    @DisplayName("Value Source test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"One" , "Two", "Three"})
    void testParameterizedTest(String val){
        System.out.println("VALUE: " + val);
    }

    @DisplayName("Enum Source test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void testEnum(OwnerType type) {
        System.out.println("TYPE: " +type);
    }
}
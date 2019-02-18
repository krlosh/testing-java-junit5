package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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

    @DisplayName("CSV Source test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @CsvSource(value={
            "FL ,1 ,1",
            "OH ,1 ,2",
            "MI ,2 ,1",
    })
    void testCsv(String state, int val1, int val2) {
        System.out.println("state: " +state +" = "+val1 +" :"+val2);
    }

    @DisplayName("CSV Source test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void testFromCsvFile(String state, int val1, int val2) {
        System.out.println("state: " +state +" = "+val1 +" :"+val2);
    }

    @DisplayName("Method Source test")
    @ParameterizedTest(name="{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void testFromMethod(String state, int val1, int val2) {
        System.out.println("state: " +state +" = "+val1 +" :"+val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("XX" , 4 ,7),
                Arguments.of("ZZ" , 6 ,9)
        );
    }
}
package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTest implements ModelRepeatedTests {

    @RepeatedTest(value = 10, name = "{displayName}: {currentRepetition} / {totalRepetitions}")
    @DisplayName("My repeated test")
    void repeatedTests(){
        //TODO -impl
    }

    @RepeatedTest(5)
    void repeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ":"+repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 7, name = "{displayName}: {currentRepetition} | {totalRepetitions}")
    @DisplayName("My repeated test")
    void newRepeatedTest() {
        //TODO: Implement
    }
}

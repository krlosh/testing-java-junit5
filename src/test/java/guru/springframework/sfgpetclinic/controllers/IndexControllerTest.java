package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
class IndexControllerTest implements ControllerTests {

    IndexController controller ;

    @BeforeEach
    void setUp() {
        this.controller = new IndexController();
    }

    @DisplayName("Test proper view name is returned for index mapping")
    @Test
    void index() {
        //Also lambda expression should be used but although it's only evaluated in failure conditions it's more
        // expensive
        assertEquals("index", controller.index(),"Wrong view returned");

        assertThat(controller.index()).isEqualTo("index");
    }


    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, ()->{
            controller.oupsHandler();
        });
        /*assertTrue("asdf".equals(controller.oupsHandler()),()->"This is some expensive " + "Message to build" + " for" +
                " my test");*/
    }

    @Disabled("Enable it to test timeouts")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofSeconds(1), ()-> {
            Thread.sleep(5000);
            System.out.println("I'm here");
        });
    }

    @Disabled("Enable it to test timeouts")
    @Test
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> {
            Thread.sleep(5000);
            System.out.println("I'm here");
        });
    }

    @Test
    void testAssumptionTrue() {
        //Show as disabled when assumption si not true
        assumeTrue("CI".equalsIgnoreCase(System.getenv("ENVIRONMENT")));
    }

    @Test
    void testAssumptionTrueExpected() {
        //Show as disabled when assumption si not true
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testMeOnLinux() {
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMac() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfSystemProperty(named="USER", matches = "krlosh")
    @Test
    void testMeIfUserKrlosh() {
    }
}
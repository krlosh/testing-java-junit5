package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

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
    }

    @Test
    void oupsHandler() {
        assertTrue("asdf".equals(controller.oupsHandler()),()->"This is some expensive " + "Message to build" + " for" +
                " my test");
    }
}
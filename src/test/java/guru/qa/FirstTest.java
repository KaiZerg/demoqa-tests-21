package guru.qa;

import org.junit.jupiter.api.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll()");
        //open("https://google.com");
        //Configuration.browser = "chrome";
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll()");
        //Configuration.browser = "chrome";
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    beforeEach()");
        //Configuration.browser = "chrome";
    }

    @AfterEach
    void afterEach() {
        System.out.println("    afterEach()");
        //Configuration.browser = "chrome";
    }

    @Test
    void firstTest() {
        System.out.println("            firstTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("            secondTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("            thirdTest");
        Assertions.assertTrue(3 > 2);
    }
}

package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class UsersTest {
    static UserManager userManager;

    @BeforeAll
    public static void initUser() {
        userManager = new UserManager();
        userManager.users.add(new User("Alla", "Kostenko", 15));
        userManager.users.add(new User("Oleg", "Aroma", 25));
        userManager.users.add(new User("Sergiy", "Drovenko", 28));
        userManager.users.add(new User("Dmytro", "Furman", 44));
        userManager.users.add(new User("Alya", "Osnova", 33));
        userManager.users.add(new User("Anna", "Perova", 17));
        userManager.users.add(new User("Maya", "Stezhko", 23));
        userManager.users.add(new User("Olga", "Yurko", 29));
        userManager.users.add(new User("Katya", "Revchina", 28));
        userManager.users.add(new User("Ganna", "Markova", 59));
    }

    @BeforeEach
    public void printSomething() {
        System.out.println("User test");
    }


    @Test
    public void testFirstName() {
        Assertions.assertEquals(userManager.findFirstName(), "Alla");
    }
    @Test
    public void testFirstNameNegative() {
        Assertions.assertNotEquals(userManager.findFirstName(), "");
    }

        @Test
    public void testFindSecondName(){
        Assertions.assertEquals(userManager.findSecondName(),"Kostenko");
    }
    @Test
    public void testFindSecondNameNegative(){
        Assertions.assertNotEquals(userManager.findSecondName(),"");
    }
    @Test
    public void testFindMinAge(){
        Assertions.assertEquals(userManager.findMinAge(),15);
    }
    @Test
    public void testFindMinAgeNegative(){
        Assertions.assertNotEquals(userManager.findMinAge(),0);
    }
    @Test
    public void testAverageAgeOfUsers() {
        Assertions.assertEquals(userManager.averageAgeOfUsers(), 30.1);
    }
    @Test
    public void testAverageAgeOfUsersNegative() {
        Assertions.assertNotEquals(userManager.averageAgeOfUsers(), 0);
    }
    @Test
    public void testUserHAsSInSecondName() {
        Assertions.assertTrue(userManager.userHAsSInSecondName());
    }
    @Test
    public void testUserHAsSInSecondNameNegative() {
        Assertions.assertNotEquals(userManager.userHAsSInSecondName(), false);
    }
       @ParameterizedTest
   @ValueSource(strings = {"Alla", "Dmytro", "Anna"})
   public void stringTest(String value) throws InterruptedException {
        Thread.sleep(10000);
       Assertions.assertTrue(!value.isEmpty());
   }

   @ParameterizedTest
   @CsvSource(value = {
           "Alla, 15", "Anna, 17", "Dmytro, 44"
    })
   void testWithCSVSource(String firstName, int age) throws InterruptedException {
       Thread.sleep(10000);
        Assertions.assertNotNull(firstName);
        Assertions.assertTrue(age > 0);
   }
    @Test
    public void testUserHasAInFirstName() {
        Assertions.assertTrue(userManager.userHasAInFirstName());
    }
    @Test
    public void testUserHasAInFirstNameNegative() {
        Assertions.assertNotEquals(userManager.userHasAInFirstName(), false);
    }
    @Test
    public void testUserMore18Negative() {
        Assertions.assertNotEquals(userManager.AgeOfUsersMore18(), false);
    }

    @RepeatedTest(value = 10, name = "{displayName} and {totalRepetitions}")
       public void testUserMore18(RepetitionInfo repetitionInfo) {

        System.out.println(repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
        Assertions.assertTrue(userManager.AgeOfUsersMore18());
    }

    @AfterAll
    public static void testSuiteName(){
        System.out.println("User test suite");
    }
    @AfterEach
    public void cleanUpEach(){
        System.out.println("After Each cleanUp method called");
    }

}

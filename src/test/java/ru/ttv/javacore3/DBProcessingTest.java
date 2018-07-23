package ru.ttv.javacore3;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.ttv.javacore3.lesson6.DBProcessing;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DBProcessingTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] testData = getTestData();
        return Arrays.asList(testData);
    }

    private static String[][] getTestData(){
        return new String[][] {
                {"Anton","Perfect"},
                {"Viktoriya","Satisfied"}
        };
    }

    private static Connection conn;
    private static DBProcessing dbProcessing;
    private String surname;
    private String grade;

    public DBProcessingTest(String surname, String grade) {
        this.surname = surname;
        this.grade = grade;
    }

    @BeforeClass
    public static void startTest(){
        String url = "jdbc:sqlite:C:/sqlite/db/ttv.db";
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            dbProcessing = new DBProcessing(conn);
            dbProcessing.initDB();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        try {
            dbProcessing.addStudent(surname, grade);
            Assert.assertEquals(grade,dbProcessing.getGradeBySurname(surname));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void stopTest(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package ru.ttv.javacore3.lesson6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class App {
    public static void main(String[] args){

        //task#1
        ArrayProcessing arrayProcessing = new ArrayProcessing();
        int[] arr = { 1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] arrResult = arrayProcessing.getSubArray(arr);
        System.out.println(Arrays.toString(arrResult));

        //task#2
        int[] arr1 = {1,1,1,1,1,4,4,4,4,1,4,4};
        System.out.println(arrayProcessing.checkArray(arr1));

        //task#3
        Connection conn;
        DBProcessing dbProcessing;
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


}

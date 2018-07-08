package ru.ttv.javacore3.lesson2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:/sqlite/db/ttv.db";
        // create a connection to the database
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            //DatabaseMetaData dbMeta = conn.getMetaData();

            DBprocess dbProcess = new DBprocess(conn);
            dbProcess.initDB();

            Scanner scanner = new Scanner(System.in);
            while(true){
                String input = scanner.nextLine();
                if("exit".equals(input)) break;
                String[] splittedMas = input.split("\\s");
                if(splittedMas.length >= 2 ){
                    if("/цена".equals(splittedMas[0])){
                        Float cost = dbProcess.getCostByProductTitle(splittedMas[1]);
                        if(cost == null){
                            System.out.println("Такого товара нет");
                        }else {
                            System.out.println(cost);
                        }
                    }
                    if("/сменитьцену".equals(splittedMas[0])){
                        dbProcess.changeNewPrice(splittedMas[1],Float.parseFloat(splittedMas[2]));
                    }
                    if("/товарыпоцене".equals(splittedMas[0])){
                        dbProcess.showProductRange(Float.parseFloat(splittedMas[1]),Float.parseFloat(splittedMas[2]));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

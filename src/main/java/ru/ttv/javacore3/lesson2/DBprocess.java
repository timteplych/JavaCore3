package ru.ttv.javacore3.lesson2;

import java.sql.*;

public class DBprocess {
    private Connection conn;

    public DBprocess(Connection conn){
        this.conn = conn;
    }

    public void initDB(){
        try {
            Statement stmt = conn.createStatement();
            //initial query
            stmt.execute(getInitialQuery());
            //filling demo data
            fillDemoData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillDemoData() throws SQLException {
        String query = "INSERT INTO products (PRODID, TITLE, COST) VALUES (?,?,?)";
        PreparedStatement pstmnt = conn.prepareStatement(query);
        for(int i=1;i<=10000; i++){
            pstmnt.setString(1,"id_product"+i);
            pstmnt.setString(2,"product"+i);
            pstmnt.setFloat(3,new Float(i*10));
            pstmnt.addBatch();
        }
        pstmnt.executeBatch();
    }

    private String getInitialQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS  products (");
        sb.append("ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sb.append("PRODID TEXT NOT NULL,");
        sb.append("TITLE TEXT,");
        sb.append("COST REAL);");
        sb.append("DELETE FROM products;");
        return sb.toString();
    }

    public Float getCostByProductTitle(String title) throws SQLException {
        String query = "SELECT COST FROM products WHERE TITLE = ?";
        PreparedStatement pstmnt = conn.prepareStatement(query);
        pstmnt.setString(1,title);
        ResultSet rs = pstmnt.executeQuery();
        if(rs.next()){
            return rs.getFloat(1);
        }
        return null;
    }

    public void changeNewPrice(String title, Float newCost) throws SQLException {
        String query = "UPDATE products SET COST = ? WHERE TITLE = ?";
        PreparedStatement pstmnt = conn.prepareStatement(query);
        pstmnt.setFloat(1,newCost);
        pstmnt.setString(2,title);
        pstmnt.execute();
    }

    public void showProductRange(Float startCost, Float endCost) throws SQLException {
        String query = "SELECT PRODID, TITLE, COST FROM products WHERE COST >= ? AND COST <= ?";
        PreparedStatement pstmnt = conn.prepareStatement(query);
        pstmnt.setFloat(1,startCost);
        pstmnt.setFloat(2,endCost);
        ResultSet rs = pstmnt.executeQuery();
        while(rs.next()){
            //return rs.getFloat(1);
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+new Float(rs.getFloat(3)));
        }
    }
}

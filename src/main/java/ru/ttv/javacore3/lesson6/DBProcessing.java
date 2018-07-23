package ru.ttv.javacore3.lesson6;

import java.sql.*;

public class DBProcessing {
    private Connection conn;

    public DBProcessing(Connection conn){
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

    private String getInitialQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS  students (");
        sb.append("ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sb.append("SURNAME TEXT NOT NULL,");
        sb.append("GRADE TEXT);");
        sb.append("DELETE FROM students;");
        return sb.toString();
    }

    private void fillDemoData() throws SQLException {
        String query = "INSERT INTO students (SURNAME, GRADE) VALUES (?,?)";
        PreparedStatement pstmnt = conn.prepareStatement(query);
        pstmnt.setString(1,"Ivanov");
        pstmnt.setString(2,"5");
        pstmnt.addBatch();
        pstmnt.setString(1,"Petrov");
        pstmnt.setString(2,"4");
        pstmnt.addBatch();
        pstmnt.setString(1,"Sidorov");
        pstmnt.setString(2,"2");
        pstmnt.addBatch();
        pstmnt.executeBatch();
    }

    public int addStudent(String surname, String grade) throws SQLException{
        String query = "INSERT INTO students (SURNAME, GRADE) VALUES (?,?)";
        PreparedStatement pstmnt = conn.prepareStatement(query);
        pstmnt.setString(1,surname);
        pstmnt.setString(2,grade);
        return pstmnt.executeUpdate();
    }

    public int changeGrade(String surname, String newGrade) throws SQLException{
        String query = "UPDATE Students SET GRADE = ? WHERE Name = ?";
        PreparedStatement pstmnt = conn.prepareStatement(query);
        pstmnt.setString(1,newGrade);
        return pstmnt.executeUpdate();
    }

    public String getGradeBySurname(String surname) throws SQLException{
        String query = "SELECT GRADE FROM students WHERE SURNAME = ?";
        PreparedStatement pstmnt = conn.prepareStatement(query);
        pstmnt.setString(1,surname);
        ResultSet rs = pstmnt.executeQuery();
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }

}

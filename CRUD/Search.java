package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import connection.DatabaseConnection;

public class Search {
    public static void searchTable(String tableName){
        String sql = "SELECT * FROM " + tableName;

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                ResultSet rs = pstmt.executeQuery();
                
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
    
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rsmd.getColumnName(i) +"\t");
                }
                System.out.println();
    
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print("   " + rs.getString(i)+"\t");
                    }
                    System.out.println();
                }
        }
        catch(SQLException e){
             System.out.println("ERROR::" + e.getMessage());
        }
    }
    public static void searchPerson(int alunoID){
        String sql = "SELECT nomeDoAluno FROM alunos WHERE alunoID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
       
        pstmt.setInt(1, alunoID);
        try (ResultSet rs = pstmt.executeQuery()) {
           if (rs.next()) {
               String nomeDoAluno = rs.getString("nomeDoAluno");
               System.out.println("Person found: " + nomeDoAluno);
           } else {
               System.out.println("No person found with ID: " + alunoID);
           }
        }
        } catch (Exception e) {
            System.out.println("ERROR::"+ e.getMessage());
            
        }
    }
    public static void searchPersonPratice(int exercicioID){
        String sql = "SELECT nomeDoExercicio, series FROM exercicios WHERE exercicioID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
       
        pstmt.setInt(1, exercicioID);
        try (ResultSet rs = pstmt.executeQuery()) {
           if (rs.next()) {
               String nameOfExercice = rs.getString("nomeDoExercicio");
               int seriesOfExercice = rs.getInt("series");
               System.out.println("Exercice: " + nameOfExercice + "\n"+"Series: " + seriesOfExercice);
           } else{ 
               System.out.println("No Exercise found with ID: " + exercicioID);
           }
        }
        } catch (Exception e) {
            System.out.println("ERROR::"+ e.getMessage());
        }
    }
    public static void searchPersonDate(int alunoID){
        String sql = "select dataTreino from treino where alunoID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
       
        pstmt.setInt(1, alunoID);
        try (ResultSet rs = pstmt.executeQuery()) {
           if (rs.next()) {
               String dataTreino = rs.getString("dataTreino");
               System.out.println("Data of the Gym: " + dataTreino);
           } else {
               System.out.println("Date not found, please check your input!");
           }
        }
        } catch (Exception e) {
            System.out.println("ERROR::"+ e.getMessage());
        }
    }
}
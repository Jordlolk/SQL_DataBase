package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.DatabaseConnection;

public class Insert {

    public static void InsertPerson(String name, int id){
    String sql = "INSERT INTO alunos(nomeDoAluno, alunoID) value (?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2,id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0){
                System.out.println("The person`s data was saved successfully!");
            }
        } catch (SQLException e) {
            System.out.println("System notification:: " + e.getMessage());
        }
    }
    public static void InsertPratice(String praticeName, int exerciceID, int series){
        String sql = "INSERT INTO exercicios(nomeDoExercicio, exercicioID,series) value (?,?,?)";
    
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
                pstmt.setString(1, praticeName);
                pstmt.setInt(2,exerciceID);
                pstmt.setInt(3,series);
                int affectedRows = pstmt.executeUpdate();
    
                if (affectedRows > 0){
                    System.out.println("The exercice`s data was saved with success!");
                }
            } catch (SQLException e) {
                System.out.println("System notification:: " + e.getMessage());
            }
        }
        public static void InsertWorkOut(String personID, int trainingID, int workOutDay){
            String sql = "INSERT INTO treino(alunoID, treinoID,dataTreino) value (?,?,?)";
        
                try (Connection conn = DatabaseConnection.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
                    pstmt.setString(1, personID);
                    pstmt.setInt(2,trainingID);
                    pstmt.setInt(3,workOutDay);
                    int affectedRows = pstmt.executeUpdate();
        
                    if (affectedRows > 0){
                        System.out.println("The data of the Work-Out was saved with success!");
                    }
                } catch (SQLException e) {
                    System.out.println("System notification:: " + e.getMessage());
                }
            }
}

package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.DatabaseConnection;

public class Update {
    public static void updatePersonName(String newName, int id){
        String sql = "UPDATE alunos SET nomeDoAluno = ? WHERE alunoID = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setString(0, newName);
                pstmt.setInt(2, id);
                int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("The update was executed with succes!");
            }
        } catch(SQLException e){
            System.out.println("ERROR::" + e.getMessage());
        }
    }
    public static void updateExercice(String newExercice,int series, int id){
        String sql = "UPDATE exercicios SET nomeDoExercicio = ?, series = ? WHERE exercicioID = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setString(0, newExercice);
                pstmt.setInt(2, series);
                pstmt.setInt(3, id);
                int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("The update was executed with succes!");
            }

        } catch(SQLException e){
            System.out.println("ERROR::" + e.getMessage());
        }
    }
    public static void updatGymDay(String newExercice,int series, int id){
        String sql = "UPDATE treino SET dataTreino = ? WHERE alunoID = ?;";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setString(0, newExercice);
                pstmt.setInt(1, series);
                int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("The update was executed with succes!");
            }

        } catch(SQLException e){
            System.out.println("ERROR::" + e.getMessage());
        }
    }
}

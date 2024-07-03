package CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.DatabaseConnection;

public class Delete{

    public static void deletePessoa(int id) {
        String sql = "DELETE FROM alunos WHERE alunoID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0){
                System.out.println("The person was successfully deleted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("System notification:: " + e.getMessage());
        }
    }
    public static void deleteExercice(int exerciceID){
            String sql = "DELETE FROM exercicios WHERE exerciceID = ?";

           try(Connection conn = DatabaseConnection.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setInt(1,exerciceID);
                int affectedRows = pstmt.executeUpdate();

                if(affectedRows > 0){
                    System.out.println("The exercice was deleted without difficulty!");
                }
            }
            catch(SQLException e){
                System.out.println("ERROR::"+ e.getMessage());
            }
    }
    public static void deletePratice(int treinoID){
         String sql = "DELETE FROM treino WHERE treinoID = ?";

         try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setInt(1, treinoID);
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("The gum pratice was successfully deleted!");
                }
            } catch(SQLException e){
                System.out.println("Error::"+ e.getMessage());
            }
    }
}

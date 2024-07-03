/* 
Te desafio fazer um sistema simples de cadastro em Java com um banco de dados simples
Vc pode cadastrar, excluir e atualizar dados de alunos, instrutor e exercícios
O sistema deve ter uma funcionalidade específica para mostrar o treino  do aluno por dia
Cada treino é composto por no mínimo 4 exercícios.
E nessa funcionalidade, vc deve procurar o nome do aluno,
e mostrar a série que ele vai fazer no dia
*/
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Here you must enter the name of your data base and the name of user
    // If your data base has a password, just clear the "//" from  the line 19;
    private static final String URL = "jdbc:mysql://localhost:3306/Your_database_name";
    private static final String USER = "user";
    //private static final int password = "password";
    public  static Connection getConnection() {
        try {
            System.out.println("SYSTEM NOTIFICATION:: Connection executed with success!");
            return DriverManager.getConnection(URL, USER, null);
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error while trying to connect to the data base: " + e.getMessage());
        }
    }
}
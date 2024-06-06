package agenda.aplicacao.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String user = "postgres";
    private static final String senha = "lain27022004";
    private static final String url = "jdbc:postgresql://localhost:5432/Agenda";

    public static Connection getConexao(){
        Connection connection = null;
        try {
            return DriverManager.getConnection(url,user,senha);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

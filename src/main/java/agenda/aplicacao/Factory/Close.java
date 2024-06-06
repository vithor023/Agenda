package agenda.aplicacao.Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Close {

    public static void closeconect(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void closeconect(Connection connection, PreparedStatement preparedStatement) {
        closeconect(connection);
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void closeconect(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        closeconect(connection,preparedStatement);
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


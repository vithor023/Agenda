package agenda.aplicacao.Factory.Repositorio;

import agenda.aplicacao.Classes.Agenda;
import agenda.aplicacao.Factory.Close;
import agenda.aplicacao.Factory.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class agendaDB {

    public static void insert(Agenda agenda){
        Connection connection = Conexao.getConexao();
        String query = "INSERT INTO agenda(id,tarefa) values(?,?);";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,agenda.getId());
            ps.setString(2,agenda.getTask());
            ps.executeUpdate();
            System.out.println("Tarefa inserida com sucesso!");
            Close.closeconect(connection,ps);

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void select() {
        Connection connection = Conexao.getConexao();
        String query = "SELECT id,tarefa,isfeito,data_tarefa FROM agenda WHERE isfeito=false;";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Id da tarefa: "+rs.getInt("id"));
                System.out.println("Tarefa do dia: " + rs.getString("tarefa"));
                System.out.println("Status da tarefa, feita? " + rs.getBoolean("isfeito"));
                System.out.println("Hora e data que a tarefa foi adicionada: "+rs.getTimestamp("data_tarefa"));
                System.out.println("--------------------------------------");
            }
            Close.closeconect(connection, ps, rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(Boolean status, int id){
        Connection connection = Conexao.getConexao();
        String query = "UPDATE agenda set isfeito=? WHERE id=?;";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setBoolean(1,status);
            ps.setInt(2,id);
            System.out.println("Numero de linhas atualizadas: "+ps.executeUpdate());
            Close.closeconect(connection,ps);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id){
        Connection connection = Conexao.getConexao();
        String query = "DELETE FROM agenda WHERE id=?;";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            System.out.println("Numero de linhas deletadas: "+ps.executeUpdate());
            Close.closeconect(connection,ps);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

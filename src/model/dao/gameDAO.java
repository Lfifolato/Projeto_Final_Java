package model.dao;

import static connection.Conexao.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.game;
import model.bean.Xbox;
import model.bean.Ps5;



//CRUD VAI SER EXECUTADO
//CREATE READ UPDATE DELETE
// INSERT
public class gameDAO {

    public void create(game g, Xbox x, Ps5 p) {

        connection.Conexao.Conectar();

        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO videogame (NomeDoVideoGame,NomeDoJogo,cor,processador,placaVideo,Memoria,QtdControle,Roda4k) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setString(1, g.getNomeDoVideoGame());
            stmt.setString(2, g.getNomeDoJogo());
            stmt.setString(3, x.getCor());
            stmt.setString(4, x.getProcessador());
            stmt.setString(5, x.getPlacaVideo());
            stmt.setString(6, p.getMemoria());
            stmt.setString(7, p.getQtdControle());
            stmt.setString(8, p.getRoda4k());
            
            
            
            
            
            stmt.executeUpdate();   // Excuta e rodas os comando no SQL no Banco

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso !!!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            connection.Conexao.Desconectar(); // Fecha conexão Depois de Executar SQL
        }
    }

// SELECT
    public game read(String NomeDoJogo) {             
        game g = new game();
        Xbox x = new Xbox();
        Ps5 p = new Ps5();
        connection.Conexao.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement("SELECT * FROM videogame WHERE NomeDoJogo Like  ?");
            stmt.setString(1, "%"+NomeDoJogo+"%");
            rs = stmt.executeQuery();

            //while (rs.next)
            if (rs.next() == true) {
                g.setIdVideoGame(rs.getInt("IdVideoGame"));
                g.setNomeDoVideoGame(rs.getString("NomeDoVideoGame"));
                g.setNomeDoJogo(rs.getString("NomeDoJogo"));
                x.setCor(rs.getString("Cor"));
                x.setProcessador(rs.getString("processador"));
                x.setPlacaVideo(rs.getString("placaVideo"));
                p.setMemoria(rs.getString("memoria"));
                p.setQtdControle(rs.getString("qtdControle"));
                p.setRoda4k(rs.getString("roda4k"));
                g.setXbox(x);
                g.setPs5(p);
                                                                         
                JOptionPane.showMessageDialog(null, "Nome encontrado !!! ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(gameDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nome não encontrado, Tente novamente.");
        } finally {
            connection.Conexao.Desconectar();
        }
        return g;
    }

// UPDATE
    public void update(game g, Xbox x, Ps5 p) {

        connection.Conexao.Conectar();

        PreparedStatement stmt = null;

//stmt = conexao.prepareStatement("UPDATE videogame SET NomeDoVideoGame = ? , NomeDoJogo = ? , cor = ? , processador = ? , placaVideo = ? , Memoria = ? , QtdControle = ? , roda4k = ?  WHERE IdVideoGame = ?");
        try {
            stmt = conexao.prepareStatement("UPDATE videogame SET NomeDoJogo = ?, nomedovideogame = ? , Roda4k = ? , cor = ? , processador = ?, placavideo = ?, memoria = ?, QtdControle = ? WHERE idVideoGame = ?");


              stmt.setString(1, g.getNomeDoJogo());
              stmt.setString(2, g.getNomeDoVideoGame());
              stmt.setString(3, p.getRoda4k());
              stmt.setString(4, x.getCor());
              stmt.setString(5, x.getProcessador());
              stmt.setString(6, x.getPlacaVideo());
              stmt.setString(7, p.getMemoria());
              stmt.setString(8, p.getQtdControle());
              stmt.setInt(9, g.getIdVideoGame());
              
            stmt.executeUpdate();  // Executar os comando no banco SQL

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Erro ao atualizar: " + ex);
        } finally {
            connection.Conexao.Desconectar(); //Fechar conexão
        }
    }

// DELETE
    public void delete(game g) {

        connection.Conexao.Conectar();  // abri o Banco

        PreparedStatement stmt = null;  // É quem Recebe os comandos SQL

        try {
            stmt = conexao.prepareStatement("DELETE FROM videogame WHERE IdVideoGame = ?");
            stmt.setInt(1, g.getIdVideoGame());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso !!! ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + ex);
        } finally {
            connection.Conexao.Desconectar();
        }
    }

}

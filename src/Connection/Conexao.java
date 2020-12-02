package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Responsavel por Estabelecer a Conexão com o Banco: Conecta / Desconecta
public class Conexao {
    
    public Conexao() {} 
    
    public static Connection conexao = null;
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bancogame?useTimezone=true&serverTimezone=UTC"; 
    private static final String USER = "root";
    private static final String PASS = "root"; //senha do banco
    
    // Antes de fazer qualquer consulta em SQL precisa estabelecer um conexão
    public static void Conectar() {
        System.out.println("Conectando ao Banco....");
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontrada, adicone o driver na bibliotecas.");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e){
            System.out.println(e);
           throw new RuntimeException(e);
        }      
    }
    
    // Depois de fazer qualquer consulta em SQL, precisa fecha a conexão
    
    public static void Desconectar() {
        System.out.println("Desconectando do Banco....");
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Desconectado.");
    }
}

package br.com.gerenciadortarefas.conexao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class CriarConexao {
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("Conectado");
			return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoesig?useSSL=false", "root", "123456");
		} catch(ClassNotFoundException e) {
			throw new SQLException(e);
		} catch(SQLException e1) {
			throw new SQLException(e1);
		}
	}
}

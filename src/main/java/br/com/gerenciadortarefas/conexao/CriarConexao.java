package br.com.gerenciadortarefas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.print("Conectado");
			return (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetoesig","postgres", "123456");			
		} catch(ClassNotFoundException e) {
			throw new SQLException(e);
		} catch(SQLException e1) {
			throw new SQLException(e1);
		}
	}
}

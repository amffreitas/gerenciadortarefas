package br.com.gerenciadortarefas.conexao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Main {
	public static void main(String[] args) throws SQLException {
		@SuppressWarnings("unused")
		Connection con = CriarConexao.getConexao();
	}
}

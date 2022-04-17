package br.com.gerenciadortarefas.tarefa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.gerenciadortarefas.conexao.*;

public class TarefaDAO {

	public void salvar(Tarefa tarefa) throws SQLException {
		
		try {
			Connection con = CriarConexao.getConexao();
			PreparedStatement ps;
			if (tarefa.getId() == null) {
				ps = con.prepareCall(
						"INSERT INTO projetoesig.tarefa (titulo, descricao, responsavel, prioridade, situacao, prazo_final) VALUES (?,?,?,?,?,?) ");
			} else {
				ps = con.prepareCall("update projetoesig.tarefa set titulo=?, descricao=?, responsavel=?, prioridade=?, situacao=?, prazo_final=? where id=?");
				ps.setString(5, tarefa.getSituacao());
				ps.setLong(7, tarefa.getId());
			}
			ps.setString(1, tarefa.getTitulo());
			ps.setString(2, tarefa.getDescricao());
			ps.setString(3, tarefa.getResponsavel());
			ps.setInt(4, tarefa.getPrioridade());
			ps.setString(5, "Em andamento");
			ps.setDate(6, new Date(tarefa.getPrazoFinal().getTime()));
			ps.execute();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	public List<Tarefa> buscar() {
		try {
			Connection con = CriarConexao.getConexao();
			PreparedStatement ps = con.prepareCall("select * from projetoesig.tarefa");
			ResultSet resultSet = ps.executeQuery();
			List<Tarefa> tarefas = new ArrayList<>();
			while (resultSet.next()) {
				Tarefa tarefa = new Tarefa();
				tarefa.setId(resultSet.getLong("id"));
				tarefa.setTitulo(resultSet.getString("titulo"));
				tarefa.setDescricao(resultSet.getString("descricao"));
				tarefa.setResponsavel(resultSet.getString("responsavel"));
				tarefa.setPrioridade(resultSet.getInt("prioridade"));
				tarefa.setSituacao(resultSet.getString("situacao"));
				tarefa.setPrazoFinal(resultSet.getDate("prazo_final"));
				tarefas.add(tarefa);
			}
			return tarefas;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public void deletar(Long idTarefa) {
		try {
			Connection con = CriarConexao.getConexao();
			PreparedStatement ps = con.prepareCall("delete from projetoesig.tarefa where id = ?");
			ps.setLong(1, idTarefa);
			ps.execute();
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void concluir(Long idTarefa) {
		try {
			Connection con = CriarConexao.getConexao();
			PreparedStatement ps = con.prepareCall("update projetoesig.tarefa set situacao=? where id=?");
			ps.setString(1, "Finalizado");
			ps.setLong(2, idTarefa);
			ps.execute();
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}

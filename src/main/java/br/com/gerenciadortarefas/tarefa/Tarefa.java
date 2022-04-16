package br.com.gerenciadortarefas.tarefa;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tarefa {
	
	@Id
	private Long id;
	private String titulo;
	private String descricao;
	private String responsavel;
	private Integer prioridade;
	private String situacao;
	@Column(name = "prazo_final")	
	private Date prazoFinal;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public Integer getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getPrazoFinal() {
		return prazoFinal;
	}

	public void setPrazoFinal(Date prazoFinal) {
		this.prazoFinal = prazoFinal;
	}
	
	public java.sql.Date getPrazoFinalSql() {
		return (java.sql.Date) java.sql.Date.from(prazoFinal.toInstant());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}
		
}

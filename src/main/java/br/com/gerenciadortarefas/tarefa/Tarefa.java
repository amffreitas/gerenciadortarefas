package br.com.gerenciadortarefas.tarefa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
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
	
}

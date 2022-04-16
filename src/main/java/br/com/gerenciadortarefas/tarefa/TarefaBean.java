package br.com.gerenciadortarefas.tarefa;



import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "tarefaBean")
public class TarefaBean implements Serializable {
	
	private List<Tarefa> tarefas = new ArrayList<>();
	private TarefaDAO tarefaDAO = new TarefaDAO();
	
	private static final long serialVersionUID = 1L;
	private Tarefa tarefa = new Tarefa();
	@PostConstruct
    public void init(){
        listar(); 
    }
	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public String cadastrarTarefa() throws SQLException {
		
		tarefaDAO.salvar(this.tarefa);
		return this.tarefa.getDescricao();

	}
	
	public void listar() {
		this.setTarefas(this.tarefaDAO.buscar()); 
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public void editar(Tarefa e) {
		this.tarefa = e;
	}
	
	public void deletar(Tarefa t) {
		tarefaDAO.deletar(t.getId());
		listar();
	}
}

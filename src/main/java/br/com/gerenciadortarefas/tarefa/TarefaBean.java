package br.com.gerenciadortarefas.tarefa;



import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;

import lombok.Data;

@Data
@ViewScoped
@ManagedBean(name = "tarefaBean")
public class TarefaBean extends HttpServlet {
	
	private List<Tarefa> tarefas = new ArrayList<>();
	private TarefaDAO tarefaDAO = new TarefaDAO();
	
	private static final long serialVersionUID = 1L;
	private Tarefa tarefa = new Tarefa();
	
	@PostConstruct
    public void init(){
        listar(); 
    }
	
	public String cadastrarTarefa() throws SQLException {
		
		tarefaDAO.salvar(this.tarefa);
		return "Tarefa salva com sucesso";

	}
	
	public void listar() {
		this.setTarefas(this.tarefaDAO.buscar()); 
	}
	
	
	public void editar(Tarefa t) throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect("formulario.xhtml");
		
		this.tarefa = t;
	}
	
	public void deletar(Tarefa t) {
		tarefaDAO.deletar(t.getId());
		listar();
	}
	
	public void concluir(Tarefa t) {
		tarefaDAO.concluir(t.getId());
		listar();
	}
	
}

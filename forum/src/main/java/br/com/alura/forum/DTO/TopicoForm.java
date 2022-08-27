package br.com.alura.forum.DTO;


import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//SÃO DADOS QUE SAI DO CLIENTE PARA API,PENSAR NA REGRA DE NEGOCCIO
public class TopicoForm {

    //BEAN VALIDATION
    @NotNull  @NotEmpty @Length (min=5)
    private String titulo;

    @NotNull  @NotEmpty @Length (min=10)
    private String mensagem;
    //COMO O CURSO TA CADASTRADO
    @NotNull  @NotEmpty
    private String nomeCurso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(CursoRepository cursoRepository) {
        Curso curso=cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo,mensagem,curso);
    }
}

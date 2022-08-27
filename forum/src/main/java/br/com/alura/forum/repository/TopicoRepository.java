package br.com.alura.forum.repository;


import br.com.alura.forum.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//EXTENDENDO ESSA INTERFACE DE UMA JPA,SENDO O PRIMEIRO PARAMETRO
//QUAL CLASSE ELA HERDA COMO TA FAZENDO DO TOPICO,HERDA DE TOPICO
//SEGUNDO PARAMETRO E O TIPO DA CHAVE PRIMARIA
public interface TopicoRepository extends JpaRepository<Topico,Long> {


    List<Topico> findByCursoNome(String nomeCurso);

    //TBM PODEMOS CRIAR A QUERRY PELO JPQL
    @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
    List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso")String nomeCurso);
}

package br.com.alura.forum.controller;


import br.com.alura.forum.DTO.TopicoDto;
import br.com.alura.forum.DTO.TopicoForm;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

//TODO METODO TEM O RESPONSE BODY
@RestController
@RequestMapping("/topicos")
public class TopicosController {

    //INJETANDO Dependencias
    @Autowired
    private TopicoRepository topicoRepository;


    @Autowired
    private CursoRepository cursoRepository;
    @GetMapping
    public List<TopicoDto> lista(String nomeCurso)
    {
        if(nomeCurso==null)
        {
            List<Topico> topicos=topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        }
        else
        {
            List<Topico> topicos=topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }

    @PostMapping
    //TENHO QUE PEGAR DO CORPO DA REQUISIÇÃO
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid  TopicoForm form, UriComponentsBuilder uriBuilder)
    {
        Topico topico=form.converter(cursoRepository);
        topicoRepository.save(topico);
        URI uri=uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }



}

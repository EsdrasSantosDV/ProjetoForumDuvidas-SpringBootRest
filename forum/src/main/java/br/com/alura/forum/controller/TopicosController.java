package br.com.alura.forum.controller;


import br.com.alura.forum.DTO.TopicoDto;
import br.com.alura.forum.model.Curso;
import br.com.alura.forum.model.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//TODO METODO TEM O RESPONSE BODY
@RestController
public class TopicosController {
    @RequestMapping("/topicos")
    @ResponseBody
    public List<TopicoDto> lista()
    {
        Topico topico=new Topico("Duvida","Duvida com Spring",new Curso("Spring","Programação"));

        return TopicoDto.converter(Arrays.asList(topico,topico,topico));

    }




}

package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComunidadeTest {
    private Comunidade comunidade;
    private List<Usuario> usuarios;
    private Usuario gabriel;
    private Usuario anthoni;

    @BeforeEach
    void setUp() {
        usuarios = new ArrayList<>();
        gabriel = new Usuario("Gabriel", "gab");
        anthoni = new Usuario("Anthoni", "ant");
    }

    @Test
    void constroi(){
        comunidade = new Comunidade(usuarios);
        assertEquals(new ArrayList<>(), comunidade.apelidosMembros());

    }

    @Test
    void adicionaUmMembro(){
        usuarios.add(gabriel);
        List<String> apelidosMembros = List.of(gabriel.getApelido());
        comunidade = new Comunidade(usuarios);
        assertEquals(apelidosMembros, comunidade.apelidosMembros());
    }
    @Test
    void adicionaDoisMembro(){
        usuarios.add(gabriel);
        usuarios.add(anthoni);
        List<String> apelidosMembros = List.of(gabriel.getApelido(), anthoni.getApelido());
        comunidade = new Comunidade(usuarios);
        assertEquals(apelidosMembros, comunidade.apelidosMembros());
    }

}

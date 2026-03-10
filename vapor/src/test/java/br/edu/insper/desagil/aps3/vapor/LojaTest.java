package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LojaTest {
    private Jogo mortal;
    private Jogo fifa;
    private Jogo pes;
    private Usuario gabriel;
    private Usuario felipe;
    private List<Jogo> jogos;
    private Loja loja;


    @BeforeEach
    void setUp() {
        mortal = new Jogo(1, "Mortal Kombat");
        fifa = new Jogo(2, "Fifa");
        pes = new Jogo(3, "PES");
        gabriel = new Usuario("Gabriel", "Gab");
        felipe = new Usuario("Felipe", "Fe");
        jogos = new ArrayList<>();


    }

    @Test
    void constroi(){
        loja = new Loja(gabriel, jogos);
        assertEquals(gabriel, loja.getDono());
        assertEquals(0, loja.numeroAvaliados(loja.getDono()));
    }

    @Test
    void umUsuarioAvaliaUmJogo(){
        mortal.avalia(gabriel.getApelido(), 10);
        jogos.add(mortal);
        jogos.add(fifa);
        jogos.add(pes);
        loja = new Loja(gabriel, jogos);

        assertEquals(1, loja.numeroAvaliados(loja.getDono()));
    }

    @Test
    void umUsuarioAvaliaDoisJogos(){
        mortal.avalia(gabriel.getApelido(), 10);
        fifa.avalia(gabriel.getApelido(), 10);

        jogos.add(mortal);
        jogos.add(fifa);
        jogos.add(pes);
        loja = new Loja(gabriel, jogos);

        assertEquals(2, loja.numeroAvaliados(loja.getDono()));
    }

    @Test
    void doisUsuariosAvaliamUmJogo(){
        mortal.avalia(gabriel.getApelido(), 10);
        mortal.avalia(felipe.getApelido(), 10);

        jogos.add(mortal);
        jogos.add(fifa);
        jogos.add(pes);
        loja = new Loja(gabriel, jogos);
        assertEquals(1, loja.numeroAvaliados(loja.getDono()));
        assertEquals(1, loja.numeroAvaliados(felipe));
    }
    @Test
    void doisUsuariosAvaliamDoisJogo(){
        mortal.avalia(gabriel.getApelido(), 10);
        fifa.avalia(felipe.getApelido(), 10);

        jogos.add(mortal);
        jogos.add(fifa);
        jogos.add(pes);
        loja = new Loja(gabriel, jogos);
        assertEquals(1, loja.numeroAvaliados(loja.getDono()));
        assertEquals(1, loja.numeroAvaliados(felipe));
    }


}

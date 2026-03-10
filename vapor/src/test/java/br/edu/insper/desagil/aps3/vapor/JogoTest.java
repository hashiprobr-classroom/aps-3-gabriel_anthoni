package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JogoTest {
    private static final double DELTA = 0.01;
    private Jogo jogo;
    private Usuario marcio;
    private Usuario anthoni;
    private Usuario gabriel;


    @BeforeEach
    public void setUp(){
        jogo = new Jogo(0,"Palmeiras");
        marcio = new Usuario("Marcio", "mar");
        anthoni = new Usuario("Anthoni", "ant");
        gabriel = new Usuario("Gabriel", "gab");
    }

    @Test
    void constroi(){
        assertEquals(0, jogo.getId());
        assertEquals("Palmeiras", jogo.getNome());
        assertEquals(0.0, jogo.media(), DELTA);
    }

    @Test
    void avaliaUmaVez(){
        jogo.avalia(marcio.getApelido(), 3);
        assertTrue(jogo.avaliado(marcio.getApelido()));
        assertFalse(jogo.avaliado(gabriel.getApelido()));
        assertEquals(3, jogo.media(), DELTA);
    }

    @Test
    void avaliaDuasVezes(){
        jogo.avalia(marcio.getApelido(), 3);
        jogo.avalia(anthoni.getApelido(), 4);
        assertTrue(jogo.avaliado(marcio.getApelido()));
        assertTrue(jogo.avaliado(anthoni.getApelido()));
        assertEquals(3.5, jogo.media(), DELTA);
    }

    @Test
    void avaliaTresVezes(){
        jogo.avalia(marcio.getApelido(), 3);
        jogo.avalia(anthoni.getApelido(), 4);
        jogo.avalia(marcio.getApelido(), 5);
        assertEquals(4.5, jogo.media(), DELTA);
    }
}

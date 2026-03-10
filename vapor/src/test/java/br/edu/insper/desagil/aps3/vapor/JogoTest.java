package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JogoTest {
    private static final double DELTA = 0.01;
    private Jogo jogo;
    private Usuario Marcio;
    private Usuario Anthoni;
    private Usuario Gabriel;


    @BeforeEach
    public void setUp(){
        jogo = new Jogo(0,"Palmeiras");
        Marcio = new Usuario("Marcio", "mar");
        Anthoni = new Usuario("Anthoni", "ant");
        Gabriel = new Usuario("Gabriel", "gab");
    }

    @Test
    void constroi(){
        assertEquals(0, jogo.getId());
        assertEquals("Palmeiras", jogo.getNome());
        assertEquals(0.0, jogo.media(), DELTA);
    }

    @Test
    void avaliaUmaVez(){
        jogo.avalia(Marcio.getApelido(), 3);
        assertTrue(jogo.avaliado(Marcio.getApelido()));
        assertFalse(jogo.avaliado(Gabriel.getApelido()));
        assertEquals(3, jogo.media(), DELTA);
    }

    @Test
    void avaliaDuasVezes(){
        jogo.avalia(Marcio.getApelido(), 3);
        jogo.avalia(Anthoni.getApelido(), 4);
        assertTrue(jogo.avaliado(Marcio.getApelido()));
        assertTrue(jogo.avaliado(Anthoni.getApelido()));
        assertEquals(3.5, jogo.media(), DELTA);
    }

    @Test
    void avaliaTresVezes(){
        jogo.avalia(Marcio.getApelido(), 3);
        jogo.avalia(Anthoni.getApelido(), 4);
        jogo.avalia(Marcio.getApelido(), 5);
        assertEquals(4.5, jogo.media(), DELTA);
    }
}

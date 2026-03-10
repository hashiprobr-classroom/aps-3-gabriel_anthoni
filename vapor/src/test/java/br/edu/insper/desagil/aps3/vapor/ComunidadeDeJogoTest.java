package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComunidadeDeJogoTest {

    private ComunidadeDeJogo comunidadeDeFifa;
    private Jogo fifa;
    private Usuario gabriel;
    private Usuario anthoni;
    private List<Usuario> membros;

    @BeforeEach
    void setUp() {
        fifa = new Jogo(1, "Fifa");
        gabriel = new Usuario("Gabriel", "gab");
        anthoni = new Usuario("Anthoni", "ant");
        membros = new ArrayList<>();
        comunidadeDeFifa = new ComunidadeDeJogo(membros, fifa);
    }

    @Test
    void adicionaDoisInvalidos(){
        comunidadeDeFifa.adicionaMembro(anthoni);
        comunidadeDeFifa.adicionaMembro(gabriel);

        assertEquals(new ArrayList<>(), comunidadeDeFifa.apelidosMembros());
    }

    @Test
    void adicionaUmInvalidoUmValido(){
        fifa.avalia(anthoni.getApelido(), 10);

        comunidadeDeFifa = new ComunidadeDeJogo(membros, fifa);

        comunidadeDeFifa.adicionaMembro(anthoni);
        comunidadeDeFifa.adicionaMembro(gabriel);
        assertEquals(List.of(anthoni.getApelido()), comunidadeDeFifa.apelidosMembros());
    }

    @Test
    void adicionaDoisValidos(){
        fifa.avalia(gabriel.getApelido(), 10);
        fifa.avalia(anthoni.getApelido(), 10);

        List<String> avaliados = List.of(anthoni.getApelido(), gabriel.getApelido());

        comunidadeDeFifa = new ComunidadeDeJogo(membros, fifa);
        comunidadeDeFifa.adicionaMembro(anthoni);
        comunidadeDeFifa.adicionaMembro(gabriel);

        assertEquals(avaliados, comunidadeDeFifa.apelidosMembros());

    }



}

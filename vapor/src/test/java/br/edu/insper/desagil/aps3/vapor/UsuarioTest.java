package br.edu.insper.desagil.aps3.vapor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    @Test
    void constroi(){
        Usuario usuario = new Usuario("Gabriel", "Gab");
        assertEquals("Gabriel", usuario.getNome());
        assertEquals("Gab", usuario.getApelido());
    }
    @Test
    void mudaNome(){
        Usuario usuario = new Usuario("Gabriel", "Gab");
        usuario.setNome("Gabzão");
        assertEquals("Gabzão", usuario.getNome());
    }
}

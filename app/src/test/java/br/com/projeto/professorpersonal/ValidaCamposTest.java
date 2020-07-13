package br.com.projeto.professorpersonal;

import org.junit.Test;

import br.com.projeto.professorpersonal.model.Trainer;

import static org.junit.Assert.assertEquals;

public class ValidaCamposTest {

    @Test
    public void deve_ValidarCamPoIdentidade_QuandoTamanhoEh9 () {
        Trainer trainer = new Trainer("nome", "sobrenome", "23455689",
                "234573428", "cristiano@gmail.com");
        assertEquals(9, trainer.getNumeroIdentidade().length());
    }
}

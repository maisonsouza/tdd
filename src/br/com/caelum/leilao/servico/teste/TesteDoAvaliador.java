package br.com.caelum.leilao.servico.teste;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteDoAvaliador {

    @Test
    public void devemEntenderLancesEmOrdemCrescente( ) {
        //Montar o cenário
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,250.0));
        leilao.propoe(new Lance(jose,300.0));
        leilao.propoe(new Lance(maria,400.0));

        //Executar uma ação
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        //Validação
        double maiorEsperado = 400;
        double menorEsperado = 250;

        assertEquals(maiorEsperado,leiloeiro.getMaiorLance(),0.00001);
        assertEquals(menorEsperado,leiloeiro.getMenorLance(),0.00001);
    }

    @Test
    public void deveCalcularAMedia() {
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,300.0));
        leilao.propoe(new Lance(joao,400.0));
        leilao.propoe(new Lance(jose,500.0));

        // executando a acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // comparando a saida com o esperado
        assertEquals(400, leiloeiro.getMedia(), 0.0001);
    }

    @Test
    public void testaMediaDeZeroLance(){

        // cenario
        Usuario ewertom = new Usuario("Ewertom");

        // acao
        Leilao leilao = new Leilao("Iphone 7");

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        //validacao
        assertEquals(0, avaliador.getMedia(), 0.0001);

    }
}

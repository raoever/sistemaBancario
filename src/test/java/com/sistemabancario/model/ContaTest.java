package com.sistemabancario.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    
//    @Test
//    void testAddMovimentacao() {
//        //TODO: Você precisa implementar este teste
//    }
    
    @Test
    void testSetNumeroValido(){
        final Conta instance = new Conta();
        final String esperado = "12345-6";
        instance.setNumero(esperado);
        final String obtido = instance.getNumero();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testSetNumeroInvalidoNaoArmazenado(){
        final Conta instance = new Conta();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
        final String obtido = instance.getNumero();
        assertNotEquals(invalido, obtido);
    }
    
    @Test
    void testSetNumeroNulo(){
        final Conta instance = new Conta();
        assertThrows(NullPointerException.class, () -> instance.setNumero(null));
    }
    
    @Test
    void testInstanciaPadraoPoupanca(){
        final Conta instance = new Conta();
        assertFalse(instance.isPoupanca());
    }
    
    @Test 
    void testSetLimiteContaEspecial(){
        final Conta instance = new Conta();
        instance.setEspecial(true);
        final double esperado = 1000;
        instance.setLimite(esperado);
        final double obtido = instance.getLimite();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testSetLimiteContaNaoEspecial(){
        final Conta instance = new Conta();
        final double limite = 1000;
        assertThrows(IllegalStateException.class, () -> instance.setLimite(limite));
    }
    
    @Test
    void testHistoricoNotNull(){
        final Conta instance = new Conta();
        assertNotNull(instance.getMovimentacoes());
    }
    
    @Test
    void testSetValorValido(){
        final Conta instance = new Conta();
        final Movimentacao movimentacao = new Movimentacao(instance);
        final double esperado = 100;
        movimentacao.setValor(esperado);
        final double obtido = movimentacao.getValor();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testGetSaldoTotal(){
        final Conta instance = new Conta();
        final double limite = 500;
        final double esperado = limite;
        instance.setEspecial(true);
        instance.setLimite(limite);
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testDepositoDinheiro(){
        final Conta instance = new Conta();
        final double limite = 500.6, deposito = 500.8, esperado = 1001.4;
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito); 
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido, 0.001);
    }
    
    @Test
    void testTipoDepositoDineiroCredito(){
        final Conta instance = new Conta();
        final double limite = 500.0, deposito = 500.0;
        final char esperado = 'C';
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito); 
        List <Movimentacao> movimentacoes = instance.getMovimentacoes();
        final char obtido = movimentacoes.get(movimentacoes.size()-1).getTipo();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testMovimentacaoConfirmada(){
        final Conta instance = new Conta();
        final double limite = 500.0, deposito = 500.0;
        final boolean esperado = true;
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito); 
        List <Movimentacao> movimentacoes = instance.getMovimentacoes();
        final boolean obtido = movimentacoes.get(movimentacoes.size()-1).isConfirmada();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testValorAtribuidoMovimentacao(){
        final Conta instance = new Conta();
        final double limite = 500.0, deposito = 500.0;
        final double esperado = deposito;
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito); 
        List <Movimentacao> movimentacoes = instance.getMovimentacoes();
        final double obtido = movimentacoes.get(movimentacoes.size()-1).getValor();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testMovimentacaoAdicionada(){
        final Conta instance = new Conta();
        final int esperado = instance.getMovimentacoes().size() + 1;
        final double limite = 500.0, deposito = 500.0;
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito); 
        final int obtido = instance.getMovimentacoes().size();
        assertEquals(esperado, obtido);
    }
    
}

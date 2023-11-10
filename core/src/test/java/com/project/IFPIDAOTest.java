package com.project;

import com.project.Dao.IFPIDAO;

/**
 * Classe de teste para IFPIDAO.
 * 
 * Exemplo simples de teste para o método getUsuarios da classe IFPIDAO.
 * 
 * Certifique-se de ajustar e expandir este teste conforme necessário.
 * 
 * @author @HeitorLouzeiro
 */
public class IFPIDAOTest {

    public static void main(String[] args) {
        testGetUsuarios();
    }

    /**
     * Testa o método getUsuarios da classe IFPIDAO.
     */
    private static void testGetUsuarios() {
        try {
            IFPIDAO ifpidao = new IFPIDAO();
            ifpidao.getUsuarios();
            System.out.println("Teste bem-sucedido!");
        } catch (Exception e) {
            System.err.println("Erro durante o teste: " + e.getMessage());
        }
    }
}

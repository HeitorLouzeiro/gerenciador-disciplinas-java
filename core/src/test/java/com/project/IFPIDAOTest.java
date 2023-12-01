package com.project;

import java.io.IOException;
import java.sql.SQLException;

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

    public static void main(String[] args) throws IOException, SQLException {
        IFPIDAO ifpidao = new IFPIDAO();

        ifpidao.getUsuarios();
        
        System.out.println("---------------------------------");
        ifpidao.disciplinasOfertadas();
        
        System.out.println("---------------------------------");
        ifpidao.listarDocentes();
    }

}

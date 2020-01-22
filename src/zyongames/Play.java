/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package play;

import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */// Bibliotecas:

public class Play {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here:
        Conexao teste = new Conexao();
        
        if(teste.teste_conexao())
        {
            if(teste.cria_db())
            {
                Tela1_LC T = new Tela1_LC();
                T.setLocationRelativeTo(null);
                T.limpa_tela();
                T.show();
            } else {
                JOptionPane.showMessageDialog(null, "Impossível Criar o Banco de Dados!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossível Conectar-se ao Banco de Dados!");
        }
    }
}
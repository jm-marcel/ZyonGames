/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package play;

/**
 *
 * @author joaom
 */// Bibliotecas:

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Gera_Arquivo {
    public void gerar(String texto)
    {
        JFileChooser Salvar = new JFileChooser();
        Salvar.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = Salvar.showSaveDialog(null);
        
        if (resultado == JFileChooser.CANCEL_OPTION)
        {
            return;
        } else if (resultado == JFileChooser.APPROVE_OPTION)
        {
            // Criando arquivo com os dados
            File arquivo = Salvar.getSelectedFile();
            
            try {
                FileWriter novo = new FileWriter(arquivo);
                BufferedWriter gravar = new BufferedWriter(novo);
                gravar.write(texto);
                gravar.flush();
                gravar.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao gerar nota!", "Comprados", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
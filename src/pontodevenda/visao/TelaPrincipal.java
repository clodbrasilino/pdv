/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontodevenda.visao;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author clodbrasilino
 */
public class TelaPrincipal {
    
    static JFrame janelaPrincipal;
    
    public static void main(String[] args) {
        janelaPrincipal = new JFrame("Ponto de Venda");
        janelaPrincipal.setPreferredSize(new Dimension(400,250));
        janelaPrincipal.pack();
        janelaPrincipal.setVisible(true);
        System.out.println("SORVETE");
    }
}

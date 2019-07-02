/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontodevenda;

/**
 *
 * @author clodbrasilino
 */
public class Produto {
    String descricao;
    Double precoUnitario;
    Double aliquota;
    
    Produto(String descricao, Double precoUnitario, Double aliquota){
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.aliquota = aliquota;
    }
}

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
public class ItemDeVenda {
    Integer quantidade;
    Double subtotal;
    Produto produto;
    
    ItemDeVenda(Produto produto, Integer quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.precoUnitario * quantidade;
    }
}

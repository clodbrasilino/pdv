/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontodevenda.modelo;

/**
 *
 * @author clodbrasilino
 */
public class ItemDeVenda {
    public Integer quantidade;
    public Double subtotal;
    public Produto produto;
    
    public ItemDeVenda(Produto produto, Integer quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.precoUnitario * quantidade;
    }
}

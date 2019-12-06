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
    public Long id;
    public Integer quantidade;
    public Double subtotal;
    public Produto produto;
    
    public ItemDeVenda(Produto produto, Integer quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        if(produto != null && produto.precoUnitario != null)
            this.subtotal = produto.precoUnitario * quantidade;
        else
            this.subtotal = 0.0;
    }
    
    public ItemDeVenda(Long id, Produto produto, Integer quantidade){
        this(produto, quantidade);
        this.id = id;
    }
}

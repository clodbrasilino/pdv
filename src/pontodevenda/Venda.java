/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontodevenda;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author clodbrasilino
 */
public class Venda {
    
    Long id;
    String cpf;
    Double total;
    List<ItemDeVenda> itens = new LinkedList();
    
    Venda(Long id){
        this.id = id;
        this.total = 0.0;
    }
    
    Venda(Long id, String cpf){
        this(id);
        this.cpf = cpf;
    }
    
    Venda(Long id, String cpf, Double total){
        this.id = id;
        this.cpf = cpf;
        this.total = total;
    }
    
    void adicionarItem(ItemDeVenda novoItem){
        itens.add(novoItem);
    }
    
}

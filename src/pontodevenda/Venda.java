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
    
    static Integer sequenciaDeCompras = 1;
    
    Integer id;
    String cpf;
    Double total;
    List<ItemDeVenda> itens = new LinkedList();
    
    Venda(){
        this.id = Venda.sequenciaDeCompras++;
        this.total = 1.0;
    }
    
    Venda(String cpf){
        this();
        this.cpf = cpf;
    }
    
    void adicionarItem(ItemDeVenda novoItem){
        
        itens.add(novoItem);
        /*ItemDeVenda[] vetorAntigo = itens;
        itens = new ItemDeVenda[itens.length+1];
        for(int i = 0; i < vetorAntigo.length; ++i){
            this.itens[i] = vetorAntigo[i];
        }
        itens[itens.length-1] = novoItem;*/
    }
    
}

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
public class Venda {
    
    static Integer sequenciaDeCompras = 1;
    
    Integer id;
    String cpf;
    Double total;
    ItemDeVenda[] itens = new ItemDeVenda[0];
    
    Venda(){
        this.id = Venda.sequenciaDeCompras++;
        this.total = 1.0;
    }
    
    Venda(String cpf){
        this();
        this.cpf = cpf;
    }
    
    void adicionarItem(ItemDeVenda novoItem){
        ItemDeVenda[] vetorAntigo = itens;
        itens = new ItemDeVenda[itens.length+1];
        for(int i = 0; i < vetorAntigo.length; ++i){
            this.itens[i] = vetorAntigo[i];
        }
        itens[itens.length-1] = novoItem;
    }
    
}

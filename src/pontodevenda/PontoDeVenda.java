/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontodevenda;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author clodbrasilino
 */
public class PontoDeVenda {

    Scanner entrada = new Scanner(System.in);
    Produto[] produtos = new Produto[0];
    Venda[] vendas = new Venda[0];
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Collection c1 = new LinkedList();
        c1.add(new Object());
        PontoDeVenda pdv = new PontoDeVenda();
        
        while(true) {
            pdv.imprimirMenuPrincipal();
            String opcao = pdv.entrada.nextLine();
            switch(opcao){
                case "1":
                    pdv.cadastrarProduto();
                    break;
                case "2":
                    pdv.realizarVenda();
                    break;
                case "3":
                    // Sair do programa
                    return;
                default:
                    pdv.imprimirOpcaoInvalida();
            }
        }
    }
    
    public void imprimirMenuPrincipal(){
        System.out.print(""
                + "    --- PONTO DE VENDA ---\n"
                + "       BARRACA DO AMOR\n"
                + "\n"
                + " 1 - Cadastrar produto\n"
                + " 2 - Realizar venda\n"
                + " 3 - Sair\n"
                + "\n"
                + "Digite sua opcao: ");
    }

    private void cadastrarProduto() {
        System.out.print("\n"
                + "   CADASTRAR PRODUTO\n"
                + "\n"
                + "Descricao: ");
        String descricao = this.entrada.nextLine();
        System.out.print("Preco: ");
        Double preco = this.entrada.nextDouble();
        System.out.print("Aliquota de Imposto: ");
        Double imposto = this.entrada.nextDouble();
        this.entrada.nextLine();
        Produto novoProduto = new Produto(descricao,preco,imposto);
        Produto[] produtosAntigo = this.produtos;
        this.produtos = new Produto[this.produtos.length+1];
        for(int i = 0; i < produtosAntigo.length; ++i){
            this.produtos[i] = produtosAntigo[i];
        }
        this.produtos[this.produtos.length-1] = novoProduto;
        System.out.print("\nProduto cadastrado com sucesso!\n\n");
    }

    private void realizarVenda() {
        this.solicitarCPF();
        Venda[] vendasAntigo = vendas;
        vendas = new Venda[vendas.length+1];
        for(int i = 0; i < vendasAntigo.length;++i){
            vendas[i] = vendasAntigo[i];
        }
        vendas[vendas.length-1] = new Venda();
        boolean vendaFinalizada = false;
        while(!vendaFinalizada){
           this.imprimirMenuVenda();
           String opcao = this.entrada.nextLine();
           switch(opcao){
                case "1":
                    this.imprimirListaDeProdutos();
                    break;
                case "2":
                    this.adicionarProduto();
                   break;
                case "3":
                   this.imprimirCupom();
                   break;
                case "4":
                   vendaFinalizada = true;
                   break;
                default:
                   imprimirOpcaoInvalida();
           }
        }
    }

    private void imprimirOpcaoInvalida() {
        System.out.print("Opção Inválida!\n\n");
    }

    private void solicitarCPF() {
    }

    private void imprimirMenuVenda() {
        System.out.print("   VENDA\n"
                   + "1 - Listar produtos\n"
                   + "2 - Adicionar produto\n"
                   + "3 - Imprimir Cupom\n"
                   + "4 - Finalizar venda\n"
                   + "\n"
                   + "Opcao: ");
    }

    private void imprimirListaDeProdutos() {
        System.out.print("   PRODUTOS\n\n");
        for(int i = 0; i < produtos.length; ++i){
            System.out.printf(" %d - %s\n",i+1,produtos[i].descricao);
        }
        System.out.print("\n\n");
    }

    private void adicionarProduto() {
        Venda vendaAtual = vendas[vendas.length-1];
        System.out.print("   ADICIONAR PRODUTO\n"
                + "\n"
                + "Id do produto: ");
        int idProduto = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Quantidade: ");
        int qtde = entrada.nextInt();
        entrada.nextLine();
        vendaAtual.adicionarItem(new ItemDeVenda(produtos[idProduto-1],qtde));
        vendaAtual.total = 0.0;
        for(ItemDeVenda item: vendaAtual.itens){
            vendaAtual.total += item.subtotal;
        }
        
    }

    private void imprimirCupom() {
        Venda vendaAtual = vendas[vendas.length-1];
        System.out.print("\n\n   NOTA FISCAL\n\n");
        int i = 0;
        for(ItemDeVenda abacaxi: vendaAtual.itens){
            System.out.printf("%d\t%s\t%d x R$%.2f\tR$%.2f\n\t\t\tT%.2f%%\n",
                    ++i,
                    abacaxi.produto.descricao,
                    abacaxi.quantidade,
                    abacaxi.produto.precoUnitario,
                    abacaxi.subtotal,
                    abacaxi.produto.aliquota*100);
        }
            
        /*for(int i = 0; i < vendaAtual.itens.length; ++i){
            System.out.printf("%d\t%s\t%d x R$%.2f\tR$%.2f\n\t\t\tT%.2f%%\n",
                    i+1,
                    vendaAtual.itens[i].produto.descricao,
                    vendaAtual.itens[i].quantidade,
                    vendaAtual.itens[i].produto.precoUnitario,
                    vendaAtual.itens[i].subtotal,
                    vendaAtual.itens[i].produto.aliquota*100);
        }*/
        System.out.printf("TOTAL\t\t\t\t\tR$%.2f\n\n VOLTE SEMPRE! :)\n\n",vendaAtual.total);
    }
}

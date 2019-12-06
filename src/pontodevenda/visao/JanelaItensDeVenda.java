/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontodevenda.visao;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import pontodevenda.PontoDeVenda;
import pontodevenda.modelo.ItemDeVenda;
import pontodevenda.modelo.Produto;
import pontodevenda.modelo.Venda;

/**
 *
 * @author clodbrasilino
 */
public class JanelaItensDeVenda extends javax.swing.JFrame {

    private final int ID = 0;
    private final int NOME_PRODUTO = 1;
    private final int QUANTIDADE = 2;
    private final int SUBTOTAL = 3;
    
    /**
     * Creates new form JanelaProdutos
     */
    public JanelaItensDeVenda() {
        initComponents();
    }
    
    public JanelaItensDeVenda(Venda v, JanelaVendas jv) {
        this.v = v;
        this.jv = jv;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoCadastrarItemDeVenda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();
        textoProduto = new javax.swing.JLabel();
        textoQtde = new javax.swing.JLabel();
        botaoApagarVenda = new javax.swing.JButton();
        comboProdutos = new javax.swing.JComboBox<>();
        spinnerQtde = new javax.swing.JSpinner();
        labelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendas");

        botaoCadastrarItemDeVenda.setText("+");
        botaoCadastrarItemDeVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirItemDeVenda(evt);
            }
        });

        tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        atualizarTabela();
        jScrollPane1.setViewportView(tabelaVendas);

        textoProduto.setText("Produto:");

        textoQtde.setText("Quantidade: ");

        botaoApagarVenda.setText("-");
        botaoApagarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarItemDeVenda(evt);
            }
        });

        comboProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        preencherComboBoxProdutos();

        labelTotal.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setText("Total: R$ 0.0");
        labelTotal.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoQtde)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerQtde))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(textoProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botaoCadastrarItemDeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoApagarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(179, 179, 179))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoProduto)
                    .addComponent(botaoCadastrarItemDeVenda)
                    .addComponent(comboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoQtde)
                    .addComponent(spinnerQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoApagarVenda))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirItemDeVenda(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirItemDeVenda
        try {
            String produtoSelecionado = (String) comboProdutos.getSelectedItem();
            String idProdutoSelecionado = produtoSelecionado.split(":")[0];
            Long idProduto = Long.parseLong(idProdutoSelecionado);
            Integer qtde = (Integer) spinnerQtde.getValue();
            
            ItemDeVenda novoItem = new ItemDeVenda(
                    new Produto(idProduto, null, null, null),
                    qtde
            );
            pdv.inserirNoBanco(v, novoItem);
        } catch (SQLException ex) {
            Logger.getLogger(JanelaItensDeVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizarTabela();
        atualizarTotal();
    }//GEN-LAST:event_inserirItemDeVenda

    private void apagarItemDeVenda(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarItemDeVenda
        int linhaSelecionada = tabelaVendas.getSelectedRow();
        Object obj = tabelaVendas.getModel().getValueAt(linhaSelecionada, ID);
        if (obj instanceof Long){
            try {
                Long id = (Long) obj;
                pdv.apagarDoBanco(new ItemDeVenda(id, null, null));
                atualizarTabela();
                atualizarTotal();
            } catch (SQLException ex) {
                Logger.getLogger(JanelaItensDeVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }//GEN-LAST:event_apagarItemDeVenda

    
    private void atualizarTabela(){
        String[] nomesDasColunas = {"ID","Nome do Produto","Quantidade","Subtotal"};
        // TODO Extrair para método
        List<ItemDeVenda> doBanco = new LinkedList();
        try {
            if(pdv == null) {
                pdv = new PontoDeVenda();
            }
            doBanco = pdv.obterItensDeVendaDoBanco(v);
        } catch (SQLException ex) {
            Logger.getLogger(JanelaItensDeVenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaItensDeVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        Object[][] matriz = new Object[doBanco.size()][nomesDasColunas.length];
        int linha = 0;
        for(ItemDeVenda iv: doBanco){
            matriz[linha][ID] = iv.id;
            matriz[linha][NOME_PRODUTO] = iv.produto.descricao;
            matriz[linha][QUANTIDADE] = iv.quantidade;
            matriz[linha][SUBTOTAL] = iv.subtotal;
            ++linha;
        }
        tabelaVendas.setModel(new DefaultTableModel(matriz,nomesDasColunas));
    }
    
    private void atualizarTotal() {
        try {
            //TODO Atualizar total da Tela
            int linhas = tabelaVendas.getModel().getRowCount();
            int linha = 0;
            Double total = 0.0;
            while(linha < linhas){
                Object obj = tabelaVendas.getModel().getValueAt(linha, SUBTOTAL);
                if(obj instanceof Double)
                    total += (Double) obj;
                ++linha;
            }
            v.total = total;
            pdv.atualizarTotalDaVendaNoBanco(v);
            labelTotal.setText("Total: R$ "+(new DecimalFormat("#.##").format(v.total)));
        } catch (SQLException ex) {
            Logger.getLogger(JanelaItensDeVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void preencherComboBoxProdutos() {
        try {
            List<Produto> produtosDoBanco = pdv.obterProdutosDoBanco();
            Vector<String> rotulosProdutosCombo = new Vector();
            for(Produto p: produtosDoBanco){
                rotulosProdutosCombo.add(p.id.toString()+": "+p.descricao);
            }
            comboProdutos.setModel(new DefaultComboBoxModel(rotulosProdutosCombo));
        } catch (SQLException ex) {
            Logger.getLogger(JanelaItensDeVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    private PontoDeVenda pdv;
    private JanelaVendas jv;
    private Venda v;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoApagarVenda;
    private javax.swing.JButton botaoCadastrarItemDeVenda;
    private javax.swing.JComboBox<String> comboProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JSpinner spinnerQtde;
    private javax.swing.JTable tabelaVendas;
    private javax.swing.JLabel textoProduto;
    private javax.swing.JLabel textoQtde;
    // End of variables declaration//GEN-END:variables

    
}

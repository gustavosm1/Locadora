/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import entidades.Jogo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.JogoDAO;

/**
 *
 * @author gusta
 */
public class TelaListaJogo extends javax.swing.JFrame {
    private List<Jogo> listaJogos;
    /**
     * Creates new form TelaListaJogo
     */
    public TelaListaJogo() {
        initComponents();
        listarJogos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabJogos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        tabJogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Categoria", "Preço", "Dias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabJogos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar)
                .addGap(27, 27, 27)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       new TelaCadastroJogo(this).setVisible(true); 
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linha = tabJogos.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um jogo para alterar!");
        } else {
            TelaCadastroJogo cadastro = new TelaCadastroJogo(this);
            // Pega o jogo selecionado e envia para a tela de cadastro
            cadastro.setJogo(listaJogos.get(linha)); 
            cadastro.setVisible(true);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tabJogos.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um jogo para excluir!");
        } else {
            Jogo jogo = listaJogos.get(linha);
            String mensagem = "Deseja realmente excluir o jogo " + jogo.getTitulo() + "?";
            int opcao = JOptionPane.showConfirmDialog(this, mensagem, "Confirme a exclusão", 
                    JOptionPane.YES_NO_OPTION);
            
            if (opcao == JOptionPane.YES_OPTION) {
                if (JogoDAO.excluir(jogo.getId())) {
                    listarJogos(); // atualizar a lista de jogos
                    JOptionPane.showMessageDialog(this, "Jogo excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir o jogo!");
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    
     public void listarJogos() {
        listaJogos = JogoDAO.listar();
        DefaultTableModel modelo = (DefaultTableModel)tabJogos.getModel();
        modelo.setRowCount(0); // Limpar os itens da tabela
        for (Jogo j : listaJogos) {
            Object[] linha = {
                j.getTitulo(),
                j.getCategoria().getNome(),
                j.getPreco(),
                j.getNumeroDias()
            };
            modelo.addRow(linha);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabJogos;
    // End of variables declaration//GEN-END:variables
}

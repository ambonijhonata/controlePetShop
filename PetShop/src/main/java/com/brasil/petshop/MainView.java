/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.brasil.petshop;

import com.brasil.petshop.controller.MainViewController;
import com.brasil.petshop.database.ConectarBanco;
import com.brasil.petshop.model.Atendimento;
import java.lang.ModuleLayer.Controller;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    private Connection connection;
    private List<Atendimento> listaAtendimentos;
    private MainViewController controller;
    
    public MainView() {
        initComponents();
        
        ConectarBanco conectarBanco = new ConectarBanco();
        connection = conectarBanco.getConnection();
        
        controller = new MainViewController(connection);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneMainView = new javax.swing.JDesktopPane();
        jPanelAtendimentos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendamentos = new javax.swing.JTable();
        jComboBoxDiasDaSemana = new javax.swing.JComboBox<>();
        jButtonListar = new javax.swing.JButton();
        jButtonInformacoesAtendimento = new javax.swing.JButton();
        jButtonCadastrarAtendimento = new javax.swing.JButton();
        jButtonCadastrarAnimal = new javax.swing.JButton();
        jButtonEditarAtendimento = new javax.swing.JButton();
        jButtonFinalizarAtendimento = new javax.swing.JButton();
        jComboBoxSituacoes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPaneMainView.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelAtendimentos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Atendimento", "Animal", "Funcionário", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAgendamentos);
        if (jTableAgendamentos.getColumnModel().getColumnCount() > 0) {
            jTableAgendamentos.getColumnModel().getColumn(0).setResizable(false);
            jTableAgendamentos.getColumnModel().getColumn(1).setResizable(false);
            jTableAgendamentos.getColumnModel().getColumn(2).setResizable(false);
            jTableAgendamentos.getColumnModel().getColumn(3).setResizable(false);
        }

        jComboBoxDiasDaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEGUNDA-FEIRA", "TERÇA-FEIRA", "QUARTA-FEIRA", "QUINTA-FEIRA", "SEXTA-FEIRA" }));

        jButtonListar.setText("Listar");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonInformacoesAtendimento.setText("Informações do Atendimento");
        jButtonInformacoesAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInformacoesAtendimentoActionPerformed(evt);
            }
        });

        jButtonCadastrarAtendimento.setText("Cadastrar Atendimento");
        jButtonCadastrarAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarAtendimentoActionPerformed(evt);
            }
        });

        jButtonCadastrarAnimal.setText("Animais");

        jButtonEditarAtendimento.setText("Editar Atendimento");
        jButtonEditarAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarAtendimentoActionPerformed(evt);
            }
        });

        jButtonFinalizarAtendimento.setText("Finalizar Atendimento");
        jButtonFinalizarAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarAtendimentoActionPerformed(evt);
            }
        });

        jComboBoxSituacoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Em andamento", "Finalizado" }));

        javax.swing.GroupLayout jPanelAtendimentosLayout = new javax.swing.GroupLayout(jPanelAtendimentos);
        jPanelAtendimentos.setLayout(jPanelAtendimentosLayout);
        jPanelAtendimentosLayout.setHorizontalGroup(
            jPanelAtendimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAtendimentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAtendimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addGroup(jPanelAtendimentosLayout.createSequentialGroup()
                        .addComponent(jComboBoxDiasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSituacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonListar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAtendimentosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonFinalizarAtendimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonInformacoesAtendimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditarAtendimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCadastrarAtendimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCadastrarAnimal)))
                .addContainerGap())
        );
        jPanelAtendimentosLayout.setVerticalGroup(
            jPanelAtendimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAtendimentosLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanelAtendimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxDiasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonListar)
                    .addComponent(jComboBoxSituacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAtendimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInformacoesAtendimento)
                    .addComponent(jButtonCadastrarAtendimento)
                    .addComponent(jButtonCadastrarAnimal)
                    .addComponent(jButtonEditarAtendimento)
                    .addComponent(jButtonFinalizarAtendimento))
                .addContainerGap())
        );

        jDesktopPaneMainView.setLayer(jPanelAtendimentos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneMainViewLayout = new javax.swing.GroupLayout(jDesktopPaneMainView);
        jDesktopPaneMainView.setLayout(jDesktopPaneMainViewLayout);
        jDesktopPaneMainViewLayout.setHorizontalGroup(
            jDesktopPaneMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneMainViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAtendimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPaneMainViewLayout.setVerticalGroup(
            jDesktopPaneMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneMainViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAtendimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneMainView)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneMainView)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarAtendimentoActionPerformed
        // TODO add your handling code here:
        DadosAtendimentoView tela = new DadosAtendimentoView(connection, 0, false, false, true);
        jDesktopPaneMainView.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jButtonCadastrarAtendimentoActionPerformed

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
        // TODO add your handling code here:
        listaAtendimentos = controller.buscarAtendimentos(jComboBoxDiasDaSemana.getSelectedItem().toString(), jComboBoxSituacoes.getSelectedItem().toString());
        
        DefaultTableModel tabela = (DefaultTableModel) jTableAgendamentos.getModel();
        tabela.setRowCount(0);
        
        for (Atendimento a : listaAtendimentos) {
            Object[] dados = {a.getCodigo(), a.getAnimal().getNome(), a.getFuncionario().getNome(), a.getSituacao().getDescricao()};
            tabela.addRow(dados);
        }
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonInformacoesAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInformacoesAtendimentoActionPerformed
        // TODO add your handling code here:
        if (jTableAgendamentos.getSelectedRow() != -1) {
            int idAtendimento = Integer.parseInt(jTableAgendamentos.getValueAt(jTableAgendamentos.getSelectedRow(), 0).toString());
            DadosAtendimentoView tela = new DadosAtendimentoView(connection, idAtendimento, true, false, false);
            jDesktopPaneMainView.add(tela);
            tela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione uma linha.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonInformacoesAtendimentoActionPerformed

    private void jButtonEditarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarAtendimentoActionPerformed
        // TODO add your handling code here:
        if (jTableAgendamentos.getSelectedRow() != -1) {
            if (jTableAgendamentos.getValueAt(jTableAgendamentos.getSelectedRow(), 3).equals("Em andamento")) {
                JOptionPane.showMessageDialog(null, "Não é possível editar agendamentos com a situação 'Em andamento'.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (jTableAgendamentos.getSelectedRow() != -1) {
                DadosAtendimentoView tela = new DadosAtendimentoView(connection, Integer.parseInt(jTableAgendamentos.getValueAt(jTableAgendamentos.getSelectedRow(), 0).toString()), false, true, false);
                jDesktopPaneMainView.add(tela);
                tela.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione um servico para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEditarAtendimentoActionPerformed

    private void jButtonFinalizarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarAtendimentoActionPerformed
        // TODO add your handling code here:
        if (jTableAgendamentos.getSelectedRow() != -1) {
            if (jTableAgendamentos.getValueAt(jTableAgendamentos.getSelectedRow(), 3).toString().equals("Finalizado")) {
                JOptionPane.showMessageDialog(null, "Atendimento já está finalizado.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            controller.finalizarAtendimento(Integer.parseInt(jTableAgendamentos.getValueAt(jTableAgendamentos.getSelectedRow(), 0).toString()), "Finalizado");
            
            listaAtendimentos = controller.buscarAtendimentos(jComboBoxDiasDaSemana.getSelectedItem().toString(), jComboBoxSituacoes.getSelectedItem().toString());;
            
            DefaultTableModel tabela = (DefaultTableModel) jTableAgendamentos.getModel();
            tabela.setRowCount(0);
            
            for (Atendimento a : listaAtendimentos) {
                Object[] dados = {a.getCodigo(), a.getAnimal().getNome(), a.getFuncionario().getNome(), a.getSituacao().getDescricao()};
                tabela.addRow(dados);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma linha.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonFinalizarAtendimentoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarAnimal;
    private javax.swing.JButton jButtonCadastrarAtendimento;
    private javax.swing.JButton jButtonEditarAtendimento;
    private javax.swing.JButton jButtonFinalizarAtendimento;
    private javax.swing.JButton jButtonInformacoesAtendimento;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JComboBox<String> jComboBoxDiasDaSemana;
    private javax.swing.JComboBox<String> jComboBoxSituacoes;
    private javax.swing.JDesktopPane jDesktopPaneMainView;
    private javax.swing.JPanel jPanelAtendimentos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgendamentos;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.brasil.petshop;

import com.brasil.petshop.controller.DadosAtendimentoViewController;
import com.brasil.petshop.model.Animal;
import com.brasil.petshop.model.Atendimento;
import com.brasil.petshop.model.AtendimentoServico;
import com.brasil.petshop.model.Funcionario;
import com.brasil.petshop.model.Servico;
import com.brasil.petshop.model.Situacao;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DadosAtendimentoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form DadosAtendimentoView
     */
    private Connection connection;
    private DadosAtendimentoViewController controller;
    private int idAtendimento;
    private boolean isEdicao = false;
    
    public DadosAtendimentoView(Connection connection, int idAtendimento, boolean isConsulta, boolean isEdicao, boolean isCadastro) {
        initComponents();
        
        this.connection = connection;
        controller = new DadosAtendimentoViewController(connection);
        this.idAtendimento = idAtendimento;
        jTextFieldCodigoAtendimento.setEnabled(false);
        jComboBoxSituacoes.setEnabled(false);                
        
        preencherComboAnimais();
        preencherComboSituacoes();
        preencherComboFuncionarios();
        preencherComboServicos();
        
        
        
        if (isConsulta) {
            preencherDadosEdicao(this.idAtendimento);
            isConsulta();
        }
        
        if (isEdicao) {
            this.isEdicao = true;
            jComboBoxSituacoes.setEnabled(false);
            jButtonIniciarAtendimento.setEnabled(false);
            jButtonGravar.setEnabled(true);
            preencherDadosEdicao(this.idAtendimento);
        }
        
        if(jComboBoxSituacoes.getSelectedItem().toString().equals("Finalizado")){
            jButtonGravar.setEnabled(false);
            jButtonIniciarAtendimento.setEnabled(false);
        }
        
        if (isCadastro) {
            jButtonIniciarAtendimento.setEnabled(false);
        }

    }
    
    private void isConsulta() {
        jComboBoxAnimal.setEnabled(false);
        jComboBoxDiasDaSemana.setEnabled(false);
        jComboBoxFuncionario.setEnabled(false);
        jComboBoxSituacoes.setEnabled(false);
        jComboBoxServicos.setEnabled(false);
        jButtonAdicionar.setEnabled(false);
        jButtonRemover.setEnabled(false);
        jButtonGravar.setEnabled(false);
    }
    
    private void preencherComboAnimais() {
        List<Animal> animais = controller.buscarAnimais();
        jComboBoxAnimal.removeAllItems();
        for (Animal a : animais) {
            jComboBoxAnimal.addItem(a);
        }
    }
    
    private void preencherComboSituacoes() {
        List<Situacao> situacoes = controller.buscarSituacoes();
        jComboBoxSituacoes.removeAllItems();
        for (Situacao s : situacoes) {
            jComboBoxSituacoes.addItem(s);
        }
        
    }
    
    private void preencherComboFuncionarios() {
        List<Funcionario> funcionarios = controller.buscarFuncionarios();
        jComboBoxFuncionario.removeAllItems();
        for (Funcionario f : funcionarios) {
            jComboBoxFuncionario.addItem(f);
        }
    }
    
    public void preencherComboServicos() {
        List<Servico> servicos = controller.buscarServicos();
        jComboBoxServicos.removeAllItems();
        for (Servico s : servicos) {
            jComboBoxServicos.addItem(s);
        }
    }
    
    public void preencherDadosEdicao(int idAtendimento) {
        List<AtendimentoServico> dados = controller.buscarAtendimentoById(idAtendimento);
        jTextFieldCodigoAtendimento.setText(Integer.toString(dados.get(0).getAtendimento().getCodigo()));
        
        for (int i = 0; i < jComboBoxAnimal.getItemCount(); i++) {
            if (dados.get(0).getAtendimento().getAnimal().getNome().equals(jComboBoxAnimal.getItemAt(i).toString())) {
                jComboBoxAnimal.setSelectedIndex(i);
            }
        }
        
        for (int i = 0; i < jComboBoxDiasDaSemana.getItemCount(); i++) {
            if (dados.get(0).getAtendimento().getDiaSemana().equals(jComboBoxDiasDaSemana.getItemAt(i))) {
                jComboBoxDiasDaSemana.setSelectedIndex(i);
            }
        }
        
        for (int i = 0; i < jComboBoxFuncionario.getItemCount(); i++) {
            if (dados.get(0).getAtendimento().getFuncionario().getNome().equals(jComboBoxFuncionario.getItemAt(i).toString())) {
                jComboBoxFuncionario.setSelectedIndex(i);
            }
        }
        
        System.out.println(jComboBoxSituacoes.getItemCount());
        
        for (int i = 0; i < jComboBoxSituacoes.getItemCount(); i++) {
            if (dados.get(0).getAtendimento().getSituacao().getDescricao().equals(jComboBoxSituacoes.getItemAt(i).toString())) {
                String aux1 = dados.get(0).getAtendimento().getSituacao().getDescricao();
                String aux2 = jComboBoxSituacoes.getItemAt(i).toString();
                jComboBoxSituacoes.setSelectedIndex(i);
            }
        }
        
        if(!jComboBoxSituacoes.getSelectedItem().toString().equals("Pendente")){
            jButtonIniciarAtendimento.setEnabled(false);
        }
        
        DefaultTableModel tabela = (DefaultTableModel) jTableServicos.getModel();
        for (AtendimentoServico as : dados) {
            Object[] linhaTabela = {as.getServico().getCodigo(), as.getServico().getNome()};
            tabela.addRow(linhaTabela);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMainDadosAtendimentoView = new javax.swing.JPanel();
        jPanelDadosAtendimento = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigoAtendimento = new javax.swing.JTextField();
        jLabelAnimal = new javax.swing.JLabel();
        jComboBoxAnimal = new javax.swing.JComboBox<>();
        jComboBoxDiasDaSemana = new javax.swing.JComboBox<>();
        jComboBoxFuncionario = new javax.swing.JComboBox<>();
        jComboBoxSituacoes = new javax.swing.JComboBox<>();
        jPanelDadosServicos = new javax.swing.JPanel();
        jComboBoxServicos = new javax.swing.JComboBox<>();
        jButtonAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableServicos = new javax.swing.JTable();
        jButtonRemover = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonIniciarAtendimento = new javax.swing.JButton();

        setClosable(true);
        setTitle("Dados do atendimento");

        jPanelMainDadosAtendimentoView.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelDadosAtendimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Atendimento"));

        jLabelCodigo.setText("Código:");

        jLabelAnimal.setText("Animal:");

        jComboBoxDiasDaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEGUNDA-FEIRA", "TERÇA-FEIRA", "QUARTA-FEIRA", "QUINTA-FEIRA", "SEXTA-FEIRA" }));

        javax.swing.GroupLayout jPanelDadosAtendimentoLayout = new javax.swing.GroupLayout(jPanelDadosAtendimento);
        jPanelDadosAtendimento.setLayout(jPanelDadosAtendimentoLayout);
        jPanelDadosAtendimentoLayout.setHorizontalGroup(
            jPanelDadosAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosAtendimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCodigoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAnimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDiasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSituacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDadosAtendimentoLayout.setVerticalGroup(
            jPanelDadosAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosAtendimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jTextFieldCodigoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAnimal)
                    .addComponent(jComboBoxAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDiasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSituacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDadosServicos.setBorder(javax.swing.BorderFactory.createTitledBorder("Serviços"));

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jTableServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Serviço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableServicos);
        if (jTableServicos.getColumnModel().getColumnCount() > 0) {
            jTableServicos.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonIniciarAtendimento.setText("Iniciar Atendimento");
        jButtonIniciarAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarAtendimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDadosServicosLayout = new javax.swing.GroupLayout(jPanelDadosServicos);
        jPanelDadosServicos.setLayout(jPanelDadosServicosLayout);
        jPanelDadosServicosLayout.setHorizontalGroup(
            jPanelDadosServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosServicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                    .addGroup(jPanelDadosServicosLayout.createSequentialGroup()
                        .addComponent(jComboBoxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemover)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosServicosLayout.createSequentialGroup()
                        .addComponent(jButtonIniciarAtendimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)))
                .addContainerGap())
        );
        jPanelDadosServicosLayout.setVerticalGroup(
            jPanelDadosServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosServicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadosServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIniciarAtendimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDadosServicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCancelar)
                        .addComponent(jButtonGravar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelMainDadosAtendimentoViewLayout = new javax.swing.GroupLayout(jPanelMainDadosAtendimentoView);
        jPanelMainDadosAtendimentoView.setLayout(jPanelMainDadosAtendimentoViewLayout);
        jPanelMainDadosAtendimentoViewLayout.setHorizontalGroup(
            jPanelMainDadosAtendimentoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainDadosAtendimentoViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainDadosAtendimentoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDadosAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDadosServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainDadosAtendimentoViewLayout.setVerticalGroup(
            jPanelMainDadosAtendimentoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainDadosAtendimentoViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDadosAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDadosServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMainDadosAtendimentoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMainDadosAtendimentoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:
        Object o = jComboBoxServicos.getSelectedItem();
        
        for (int i = 0; i < jTableServicos.getRowCount(); i++) {
            if (jTableServicos.getValueAt(i, 1).toString().equals(jComboBoxServicos.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Serviço já adicionado. Por favor selecione outro.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        DefaultTableModel tabela = (DefaultTableModel) jTableServicos.getModel();
        Servico s = (Servico) jComboBoxServicos.getSelectedItem();
        Object[] dados = {s.getCodigo(), s.getNome()};
        tabela.addRow(dados);
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        // TODO add your handling code here:
        if (jTableServicos.getSelectedRow() != -1) {
            DefaultTableModel tabela = (DefaultTableModel) jTableServicos.getModel();
            tabela.removeRow(jTableServicos.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione um servico para remover.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonIniciarAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarAtendimentoActionPerformed
        if (jComboBoxSituacoes.getSelectedItem().toString().equals("Em andamento")) {
            JOptionPane.showMessageDialog(null, "Atendimento já iniciado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (jComboBoxSituacoes.getSelectedItem().toString().equals("Finalizado")) {
            JOptionPane.showMessageDialog(null, "Atendimento já finalizado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        controller.inicarAtendimento(Integer.parseInt(jTextFieldCodigoAtendimento.getText()), "Em andamento");
        this.dispose();
    }//GEN-LAST:event_jButtonIniciarAtendimentoActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        // TODO add your handling code here:
        Atendimento atendimento = new Atendimento();        
        atendimento.setAnimal((Animal) jComboBoxAnimal.getSelectedItem());
        atendimento.setDiaSemana(jComboBoxDiasDaSemana.getSelectedItem().toString());        
        atendimento.setFuncionario((Funcionario) jComboBoxFuncionario.getSelectedItem());
        
        if(jTableServicos.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Por favor informe um serviço.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (isEdicao) {
            atendimento.setCodigo(Integer.parseInt(jTextFieldCodigoAtendimento.getText()));
            if (controller.atualizaDadosAtendimento(atendimento)) {
                controller.deleteServicosByAtendimento(atendimento.getCodigo());
                for (int i = 0; i < jTableServicos.getRowCount(); i++) {
                    controller.inserirServico(idAtendimento, Integer.parseInt(jTableServicos.getValueAt(i, 0).toString()));
                }
            }
        } else {
            int codigoUltimoAtendimento = controller.inserirAtendimento(atendimento);
            for (int i = 0; i < jTableServicos.getRowCount(); i++) {
                controller.inserirServico(codigoUltimoAtendimento, Integer.parseInt(jTableServicos.getValueAt(i, 0).toString()));
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButtonGravarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonIniciarAtendimento;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JComboBox<Object> jComboBoxAnimal;
    private javax.swing.JComboBox<String> jComboBoxDiasDaSemana;
    private javax.swing.JComboBox<Object> jComboBoxFuncionario;
    private javax.swing.JComboBox<Object> jComboBoxServicos;
    private javax.swing.JComboBox<Object> jComboBoxSituacoes;
    private javax.swing.JLabel jLabelAnimal;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JPanel jPanelDadosAtendimento;
    private javax.swing.JPanel jPanelDadosServicos;
    private javax.swing.JPanel jPanelMainDadosAtendimentoView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableServicos;
    private javax.swing.JTextField jTextFieldCodigoAtendimento;
    // End of variables declaration//GEN-END:variables
}

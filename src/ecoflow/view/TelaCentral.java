/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoflow.view;

import ecoflow.controle.ControleCentral;
import ecoflow.controle.ControleConexao;
import ecoflow.modelo.Central;
import ecoflow.modelo.CentraisTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import net.wimpi.modbus.net.TCPMasterConnection;
import util.outros.View;

/**
 *
 * @author vinicius
 */
public class TelaCentral extends javax.swing.JInternalFrame {
    
    private JDesktopPane        desktopPane         = new JDesktopPane();
    private CentraisTableModel  centralTableModel   = new CentraisTableModel();
    
    private List<Central>       listaCentral        = new ArrayList<>();
    
    private ControleCentral     controleCentral     = new ControleCentral();
    private ControleConexao     controleConexao     = new ControleConexao();
    
    /**
     * Creates new form TelaCentral
     */
    public TelaCentral(JDesktopPane dp) {
        initComponents();
        
        this.desktopPane = dp;
        TCPMasterConnection tcp;
        
        //Configurando tbCentral
        tbCentral.setModel(centralTableModel);
        tbCentral.setRowSorter(new TableRowSorter(centralTableModel) ); // Ordenar tbCentral
        
        //Verifica se arquivo existe senão existir cria um arquivo com ListaCentral
        controleCentral.criarLista(listaCentral);
        
        //Mostra lista de centrais já cadastrado
        listaCentral = controleCentral.getLista();
        centralTableModel.setCentrais(listaCentral);
        
        //Configurando a conexao
        tcp = controleConexao.getTcpMasterConnection();
        controleCentral.setTcpMasterConnection(tcp);
        
        
    }
    
    public Central getCentral(){
        return listaCentral.get(tbCentral.getSelectedRow() );
    }
    
    private void adicionarNovaCentral(Central c){
        if( !controleCentral.igual(c, listaCentral) ){
            //Escrever na central
            controleCentral.setIdCentral(c);
            
            //Adiciona listaCentral
            listaCentral.add(c);

            //Salvar listaCentral no xml
            controleCentral.saveLista(listaCentral);

            //Atualizar tbCentral
            centralTableModel.setCentrais(listaCentral);

        }else{
            JOptionPane.showMessageDialog(null, "Identificador já existe. Tente outro número.", "Alerta", JOptionPane.WARNING_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        btAlterar = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfId = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCentral = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(600, 400));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Identificador:");

        jLabel2.setText("Nome:");

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btAdicionar.setText("Adicionar Nova Central");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jLabel3.setText("*Identificador é um valor único e numérico");

        tfId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar)
                    .addComponent(btAdicionar)
                    .addComponent(btExcluir))
                .addContainerGap())
        );

        tbCentral.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCentral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCentralMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCentral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        // TODO add your handling code here:
        Central c = new Central();
        
        //Verifica se campos textFiel não estão em branco
        if(
            !tfId.getText().isEmpty() &&
            !tfNome.getText().isEmpty()
        ){  
             //Verifica se central possui id
            if(controleCentral.getIdCentral() == 0){   
                //Configura objeto central
                c.setId( Integer.parseInt(tfId.getText().trim() ) );
                c.setNome(tfNome.getText().trim() );

                adicionarNovaCentral(c);
            }else{
                //Configura objeto central
                c.setId(controleCentral.getIdCentral() );
                c.setNome(tfNome.getText().trim() );
                
                //Verifica se central já esta cadastrado
                if(!controleCentral.igual(c, listaCentral) ){   
                    //Altera lista de centrais
                    listaCentral.remove(tbCentral.getSelectedRow() );                

                    adicionarNovaCentral(c);                    
                }else{
                    JOptionPane.showMessageDialog(null, "Central já cadastrado.", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
            }            
            
        }else{
            JOptionPane.showMessageDialog(null, "Identificador ou Nome em branco", "Inválido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void tbCentralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCentralMouseClicked
        // TODO add your handling code here:
        //Verifica se uma linha foi selecionada
        if(tbCentral.getSelectedRow() != -1 ){
            //Verifica o duplo click do mouse
            if(evt.getClickCount() < 2){
                tfId.setText( tbCentral.getValueAt(tbCentral.getSelectedRow(), 0).toString() );
                tfNome.setText(tbCentral.getValueAt(tbCentral.getSelectedRow(), 1).toString() );                    
            }else{
                //Verifica se central selecionada na tabela é mesma conectada
                if(controleCentral.getIdCentral() == listaCentral.get(tbCentral.getSelectedRow() ).getId() ){
                    TelaRemota telaRemota = new TelaRemota(listaCentral.get( tbCentral.getSelectedRow() ) );
                    View.chamarInternalFrame(desktopPane,telaRemota, true);
                }else{
                    JOptionPane.showMessageDialog(null, "Central selecionada inválida.", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_tbCentralMouseClicked

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:
        Central c = new Central();
        
        //Verifica se campos são não nulos e se uma linha na tabela central foi selecionado
        if(
            tbCentral.getSelectedRow() != -1 &&
            !tfId.getText().isEmpty() &&
            !tfNome.getText().isEmpty() &&
            !controleCentral.igual(c, listaCentral)
        ){
            //Verifica se central selecionada na tabela e a mesma central conectada
            if(controleCentral.getIdCentral() == listaCentral.get(tbCentral.getSelectedRow() ).getId() ){
                //configurar objeto central
                c.setId( Integer.parseInt(tfId.getText().trim()) );
                c.setNome(tfNome.getText().trim() );

                //Escrever na central
                controleCentral.setIdCentral(c);

                //Altera lista de centrais
                controleCentral.setCentralLista( tbCentral.getSelectedRow(), c, listaCentral);

                //Atualiza tabela
                centralTableModel.setCentrais(listaCentral);

                //Salva lista
                controleCentral.saveLista(listaCentral);

                //limpar textField
                tfId.setText("");
                tfNome.setText("");
                
            }else{
                JOptionPane.showMessageDialog(null, "Central selecionada inválida.", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Identicador ou nome invalido ou linha na tabela não selecionada.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        if(tbCentral.getSelectedRow() != -1){
            
            //Altera lista de centrais
            listaCentral.remove(tbCentral.getSelectedRow() );
            
            //Atualiza tabela
            centralTableModel.setCentrais(listaCentral);
            
            //Salva lista
            controleCentral.saveLista(listaCentral);
            
            //limpar textField
            tfId.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha na tabela.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCentral;
    private javax.swing.JFormattedTextField tfId;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoflow.view;

import ecoflow.controle.ControleCentral;
import ecoflow.controle.ControleConexao;
import ecoflow.modelo.Central;
import ecoflow.modelo.Remota;
import ecoflow.modelo.RemotasTableModel;
import ecoflow.modelo.Unidade;
import ecoflow.modelo.UnidadesTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import net.wimpi.modbus.net.TCPMasterConnection;
import util.outros.CampoInt;
import util.outros.CampoStringIntUpperCase;
import util.outros.CampoStringUpperCase;

/**
 *
 * @author vinicius
 */
public class TelaCadastroRemota extends javax.swing.JInternalFrame {
    
    
    private Central             centralSelcionada = new Central();
    private Remota              remotaSelecionada  = new Remota();
    
    private RemotasTableModel   remotasTableModel   = new RemotasTableModel();
    private UnidadesTableModel  unidadesTableModel  = new UnidadesTableModel();
    
    private ControleCentral     controleCentral     = new ControleCentral();
    private ControleConexao     controleConexao     = new ControleConexao();
        
    private TCPMasterConnection tcp;
    
    private Boolean flag = true;
    

    /**
     * Creates new form TelaRemota
     */
    public TelaCadastroRemota(Central c) {
        initComponents();
                
        //Configurando a conexao
        tcp = controleConexao.getTcpMasterConnection();
        controleCentral.setTcpMasterConnection(tcp);
                
        //Senão existir o arquivo cria um xml
        controleCentral.criarCentralXML(c);
        
        //Le a central toda
        centralSelcionada = controleCentral.getCentral();
        //Salva o xml da central
        controleCentral.saveCentralXML(centralSelcionada);
    
        
        //Configurar tbRemota
        tbRemota.setModel(remotasTableModel);
        tbRemota.setRowSorter(new TableRowSorter(remotasTableModel) ); //Ordena tbRemota
        remotasTableModel.setRemotas(centralSelcionada.getRemotas() );
        
        //Configurar tbUnidade
        tbUnidade.setModel(unidadesTableModel);
        tbUnidade.setRowSorter(new TableRowSorter(unidadesTableModel) ); //Ordena tbUnidade
        tbUnidade.getColumnModel().removeColumn(tbUnidade.getColumnModel().getColumn(5) ); //Remove coluna leitura
                        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRemota = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUnidade = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ccServicoUnidade = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btAterarUnidade = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfNomeUnidade = new javax.swing.JTextField();
        tfNumeroUnidade = new javax.swing.JTextField();
        tfMatriculaUnidade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ccServicoRemota = new javax.swing.JComboBox<>();
        btAdicionarRemota = new javax.swing.JButton();
        tfMatriculaRemota = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNumeroRemota = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tfNomeRemota = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        tbRemota.setModel(new javax.swing.table.DefaultTableModel(
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
        tbRemota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRemotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRemota);

        tbUnidade.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUnidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUnidadeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbUnidade);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidade"));

        jLabel5.setText("Serviço:");

        ccServicoUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        ccServicoUnidade.setPreferredSize(new java.awt.Dimension(37, 20));

        jLabel8.setText("Nome:");

        btAterarUnidade.setText("Alterar");
        btAterarUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAterarUnidadeActionPerformed(evt);
            }
        });

        jLabel11.setText("N. Hidrometro:");

        jLabel10.setText("Mat. Hidrometro:");

        tfNomeUnidade.setDocument(new CampoStringIntUpperCase(10));

        tfNumeroUnidade.setDocument(new CampoStringIntUpperCase(12));

        tfMatriculaUnidade.setDocument(new CampoInt(8));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tfNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ccServicoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfMatriculaUnidade))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfNumeroUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAterarUnidade)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ccServicoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAterarUnidade)
                            .addComponent(tfNumeroUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMatriculaUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Remota"));

        jLabel1.setText("Nome:");

        jLabel3.setText("Serviço:");

        ccServicoRemota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        ccServicoRemota.setPreferredSize(new java.awt.Dimension(37, 20));

        btAdicionarRemota.setText("Adicionar");
        btAdicionarRemota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarRemotaActionPerformed(evt);
            }
        });

        tfMatriculaRemota.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfMatriculaRemota.setEnabled(false);

        jLabel2.setText("Mat. Hidrometro:");
        jLabel2.setEnabled(false);

        tfNumeroRemota.setEnabled(false);

        jLabel9.setText("N. Hidrometro:");
        jLabel9.setEnabled(false);

        tfNomeRemota.setDocument(new CampoStringUpperCase(6));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfNomeRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ccServicoRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMatriculaRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfNumeroRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAdicionarRemota)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccServicoRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionarRemota)
                    .addComponent(tfMatriculaRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumeroRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbRemotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRemotaMouseClicked
        // TODO add your handling code here:
                    
        //Verifica se uma linha foi selecionada
        if(tbRemota.getSelectedRow() != -1){

            //Seleciona remota
            remotaSelecionada = centralSelcionada.getRemota(tbRemota.getSelectedRow() );
            //Atualiza tabela
            unidadesTableModel.setUnidades(remotaSelecionada.getUnidades() );

        }        
        
    }//GEN-LAST:event_tbRemotaMouseClicked

    private void btAdicionarRemotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarRemotaActionPerformed
        // TODO add your handling code here:
        
        if(flag){
            flag = false;
            
            if(!tfNomeRemota.getText().trim().isEmpty() ){
                        
                //Adicionar remota nova
                controleCentral.addRemota(
                        centralSelcionada, 
                        tfNomeRemota.getText().trim(),
                        Integer.parseInt(ccServicoRemota.getSelectedItem().toString() )
                );            
                //Recupera a ultima remota da lista
                remotaSelecionada = centralSelcionada.getRemota(centralSelcionada.getRemotas().size() - 1);
                //Atualiza tbRemota
                remotasTableModel.setRemotas(centralSelcionada.getRemotas() );
                //Atualiza tbUnidade
                unidadesTableModel.setUnidades(remotaSelecionada.getUnidades() );
                //Salva xml da Central
                controleCentral.saveCentralXML(centralSelcionada);

            }else{
                JOptionPane.showMessageDialog(null, "Nome inválido! \n Caracteres válidos A-Z, 0-9.", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
            
            flag = true;
        }
                
    }//GEN-LAST:event_btAdicionarRemotaActionPerformed

    private void btAterarUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAterarUnidadeActionPerformed
        // TODO add your handling code here:
        Unidade un = new Unidade();
        
        if(flag){
            flag = false;
            
            if(
                !tfNomeUnidade.getText().trim().isEmpty() &&
                !tfMatriculaUnidade.getText().trim().isEmpty() &&
                !tfNumeroUnidade.getText().trim().isEmpty()
            ){
                if(tbUnidade.getSelectedRow() != -1){
                    //Seleciona unidade
                    un = remotaSelecionada.getUnidade(tbUnidade.getSelectedRow() );

                    //Altera unidade
                    un.setNome(tfNomeUnidade.getText().trim().toUpperCase() );
                    un.setServico( Integer.parseInt(ccServicoUnidade.getSelectedItem().toString() ) );
                    un.setMatriculaHidrometro( Integer.parseInt(tfMatriculaUnidade.getText()) );
                    un.setNumeroHidrometro(tfNumeroUnidade.getText().trim().toUpperCase() );

                    //Escreve na central
                    controleCentral.setUnidades( remotaSelecionada );
                    //Atualiza tbUnidade
                    unidadesTableModel.setUnidades(remotaSelecionada.getUnidades() );
                    //Salva xml da Central
                    controleCentral.saveCentralXML(centralSelcionada);
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela de unidades!", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Preencha corretamente os campos!", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
            
            flag = true;
        }
                
    }//GEN-LAST:event_btAterarUnidadeActionPerformed

    private void tbUnidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUnidadeMouseClicked
        
        Unidade un = remotaSelecionada.getUnidade(tbUnidade.getSelectedRow() );
        
        tfNomeUnidade.setText(un.getNome() );
        if(un.getServico() > 1 && un.getServico() < 3 )
            ccServicoUnidade.setSelectedIndex(un.getServico() - 1 );
        else
            ccServicoUnidade.setSelectedIndex(0);
        tfMatriculaUnidade.setText( Integer.toString(un.getMatriculaHidrometro() )  );
        tfNumeroUnidade.setText(un.getNumeroHidrometro() );
        
    }//GEN-LAST:event_tbUnidadeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarRemota;
    private javax.swing.JButton btAterarUnidade;
    private javax.swing.JComboBox<String> ccServicoRemota;
    private javax.swing.JComboBox<String> ccServicoUnidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbRemota;
    private javax.swing.JTable tbUnidade;
    private javax.swing.JFormattedTextField tfMatriculaRemota;
    private javax.swing.JTextField tfMatriculaUnidade;
    private javax.swing.JTextField tfNomeRemota;
    private javax.swing.JTextField tfNomeUnidade;
    private javax.swing.JFormattedTextField tfNumeroRemota;
    private javax.swing.JTextField tfNumeroUnidade;
    // End of variables declaration//GEN-END:variables
}

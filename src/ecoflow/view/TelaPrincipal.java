/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoflow.view;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author vinicius
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        
        //Maximiza tela
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    //Metodo para chamar internal frames
    private void chamarInternalFrame(JInternalFrame jiFrame, Boolean maximizado){
        for(JInternalFrame frame: patTelaPrincipal.getAllFrames() ){
            if(frame.getClass().toString().equalsIgnoreCase(jiFrame.getClass().toString() ) ){
                return;
            }
        }
        
        //Resolução da DesktopPane
        Dimension resolucao = patTelaPrincipal.getSize();
        if(maximizado){
            jiFrame.setSize(resolucao);   
            jiFrame.setLocation(0, 0);
        }
        patTelaPrincipal.add(jiFrame);
        jiFrame.setVisible(true);
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
        patTelaPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        imConexao = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        imSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ecoflow Studio");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout patTelaPrincipalLayout = new javax.swing.GroupLayout(patTelaPrincipal);
        patTelaPrincipal.setLayout(patTelaPrincipalLayout);
        patTelaPrincipalLayout.setHorizontalGroup(
            patTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        patTelaPrincipalLayout.setVerticalGroup(
            patTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(patTelaPrincipal);

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Em Campo");

        jMenuItem1.setText("Buscar Leituras da Central");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Editar");

        imConexao.setText("Conexão");
        imConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imConexaoActionPerformed(evt);
            }
        });
        jMenu2.add(imConexao);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");

        imSobre.setText("Sobre");
        imSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imSobreActionPerformed(evt);
            }
        });
        jMenu3.add(imSobre);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void imSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imSobreActionPerformed
        Sobre sobre = new Sobre();
        chamarInternalFrame(sobre, false);
    }//GEN-LAST:event_imSobreActionPerformed

    private void imConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imConexaoActionPerformed
        // TODO add your handling code here:
        EditarConexao editarConexao = new EditarConexao();
        chamarInternalFrame(editarConexao, false);
    }//GEN-LAST:event_imConexaoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaUnidade telaUnidade = new TelaUnidade();
        chamarInternalFrame(telaUnidade, false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem imConexao;
    private javax.swing.JMenuItem imSobre;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDesktopPane patTelaPrincipal;
    // End of variables declaration//GEN-END:variables
}
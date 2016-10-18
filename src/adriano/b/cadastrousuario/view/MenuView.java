/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adriano.b.cadastrousuario.view;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Administrador
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form MenuView
     */
    public MenuView() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        itemMarcaOpen = new javax.swing.JMenuItem();
        itemAbreGrupo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        itemProduto = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuários");
        setResizable(false);

        fileMenu.setMnemonic('C');
        fileMenu.setText("Cadastros");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("1 - Usuário");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        itemMarcaOpen.setMnemonic('M');
        itemMarcaOpen.setText("2 - Marca");
        itemMarcaOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMarcaOpenActionPerformed(evt);
            }
        });
        fileMenu.add(itemMarcaOpen);

        itemAbreGrupo.setMnemonic('G');
        itemAbreGrupo.setText("3 - Grupo");
        itemAbreGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbreGrupoActionPerformed(evt);
            }
        });
        fileMenu.add(itemAbreGrupo);

        jMenuItem1.setText("5 - Usuário (senha criptogradada)");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        itemProduto.setText("4 - Produto");
        itemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProdutoActionPerformed(evt);
            }
        });
        fileMenu.add(itemProduto);

        jMenuItem2.setText("6 -Cliente (avaliação)");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        menuBar.add(fileMenu);

        jMenu1.setText("Sistema");

        jMenuItem3.setText("Serviços do sistema");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(desktopPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(desktopPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        UsuarioView usuarioView = new UsuarioView();
        this.desktopPane.add(usuarioView);
        usuarioView.setVisible(true);
        this.centralizaForm(usuarioView);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void itemMarcaOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMarcaOpenActionPerformed
        MarcaView mv = new MarcaView();
        this.desktopPane.add(mv);
        mv.setVisible(true);
        this.centralizaForm(mv);
    }//GEN-LAST:event_itemMarcaOpenActionPerformed

    private void itemAbreGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbreGrupoActionPerformed
     GrupoView gv = new GrupoView();
     this.desktopPane.add(gv);
     gv.setVisible(true);
     this.centralizaForm(gv);
    }//GEN-LAST:event_itemAbreGrupoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        UsuarioView1 uv = new UsuarioView1();
        this.desktopPane.add(uv);
        uv.setVisible(true);
        this.centralizaForm(uv);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProdutoActionPerformed
        ProdutoView pv = new ProdutoView();
        this.desktopPane.add(pv);
        pv.setVisible(true);
        this.centralizaForm(pv);
    }//GEN-LAST:event_itemProdutoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ClienteView cv = new ClienteView();
        this.desktopPane.add(cv);
        cv.setVisible(true);
        this.centralizaForm(cv);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ServicoDoSistemaView sv = new ServicoDoSistemaView();
        this.desktopPane.add(sv);
        sv.setVisible(true);
        this.centralizaForm(sv);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itemAbreGrupo;
    private javax.swing.JMenuItem itemMarcaOpen;
    private javax.swing.JMenuItem itemProduto;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    // End of variables declaration//GEN-END:variables

    private void centralizaForm(JInternalFrame form) {
        Dimension desktopPanel = this.desktopPane.getSize();
        Dimension jifSize = form.getSize();
        form.setLocation( ( desktopPanel.width - jifSize.width  )/2 ,
                ( desktopPanel.height - jifSize.height )/2 );
    }

}

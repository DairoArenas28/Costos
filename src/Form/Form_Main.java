/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import Tools.PanelManager;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author DanielSantiago
 */
public class Form_Main extends javax.swing.JFrame {

    /**
     * Creates new form Form_Main
     */
    public Form_Main() {
        initComponents();
        
        buttonPanel(btnMaestro, panelMaestro);
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
        menuPanel = new javax.swing.JPanel();
        panelMaestro = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnIngrediente = new javax.swing.JButton();
        btnMaestro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnMaestro1 = new javax.swing.JButton();
        btnReceta = new javax.swing.JButton();
        btnConectar = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        bodyPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPanel.setBackground(new java.awt.Color(0, 71, 171));

        panelMaestro.setBackground(new java.awt.Color(173, 216, 230));
        panelMaestro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelMaestro.setEnabled(false);

        jButton4.setForeground(new java.awt.Color(0, 71, 171));
        jButton4.setText("jButton3");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setDefaultCapable(false);
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton5.setForeground(new java.awt.Color(0, 71, 171));
        jButton5.setText("jButton3");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setDefaultCapable(false);
        jButton5.setFocusPainted(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnIngrediente.setForeground(new java.awt.Color(0, 71, 171));
        btnIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ingredientes.png"))); // NOI18N
        btnIngrediente.setText("Ingredientes");
        btnIngrediente.setBorderPainted(false);
        btnIngrediente.setContentAreaFilled(false);
        btnIngrediente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        btnIngrediente.setDefaultCapable(false);
        btnIngrediente.setFocusPainted(false);
        btnIngrediente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnIngrediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngredienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMaestroLayout = new javax.swing.GroupLayout(panelMaestro);
        panelMaestro.setLayout(panelMaestroLayout);
        panelMaestroLayout.setHorizontalGroup(
            panelMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMaestroLayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(panelMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
        );
        panelMaestroLayout.setVerticalGroup(
            panelMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaestroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIngrediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnMaestro.setForeground(new java.awt.Color(255, 255, 255));
        btnMaestro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnMaestro.setText("Maestros");
        btnMaestro.setBorderPainted(false);
        btnMaestro.setContentAreaFilled(false);
        btnMaestro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaestro.setDefaultCapable(false);
        btnMaestro.setFocusPainted(false);
        btnMaestro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("jButton1");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setDefaultCapable(false);
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnMaestro1.setForeground(new java.awt.Color(255, 255, 255));
        btnMaestro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inicio.png"))); // NOI18N
        btnMaestro1.setText("Home");
        btnMaestro1.setBorderPainted(false);
        btnMaestro1.setContentAreaFilled(false);
        btnMaestro1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaestro1.setDefaultCapable(false);
        btnMaestro1.setFocusPainted(false);
        btnMaestro1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnReceta.setForeground(new java.awt.Color(255, 255, 255));
        btnReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/receta.png"))); // NOI18N
        btnReceta.setText("Receta");
        btnReceta.setBorderPainted(false);
        btnReceta.setContentAreaFilled(false);
        btnReceta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReceta.setDefaultCapable(false);
        btnReceta.setFocusPainted(false);
        btnReceta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnConectar.setForeground(new java.awt.Color(255, 255, 255));
        btnConectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/basedatos_24.png"))); // NOI18N
        btnConectar.setText("Conectar");
        btnConectar.setBorderPainted(false);
        btnConectar.setContentAreaFilled(false);
        btnConectar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConectar.setDefaultCapable(false);
        btnConectar.setFocusPainted(false);
        btnConectar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMaestro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMaestro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReceta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMaestro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(btnMaestro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReceta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaestro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jPanel1.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 690));

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 1160, 50));

        bodyPanel.setBackground(new java.awt.Color(204, 204, 255));
        bodyPanel.setPreferredSize(new java.awt.Dimension(1050, 510));
        bodyPanel.setLayout(new java.awt.BorderLayout());
        jPanel1.add(bodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 1160, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnIngredienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngredienteMouseClicked
        //JOptionPane.showMessageDialog(null, "Hola");
        PanelManager panelManager = new PanelManager(bodyPanel);
        Form_Ingrediente formIngrediente = new Form_Ingrediente();
        panelManager.showForm(formIngrediente);
    }//GEN-LAST:event_btnIngredienteMouseClicked

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        Form_Conexion fomConexion = new Form_Conexion();
        fomConexion.setVisible(true);
        fomConexion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fomConexion.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnConectarActionPerformed
    
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
            java.util.logging.Logger.getLogger(Form_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Main().setVisible(true);
            }
        });
    }
    
    public void animatePanel(JPanel panel, java.util.List<JComponent> componentsBelow) {
        if (panel.getHeight() == 0) { // Mostrar el panel
            new Thread(() -> {
                for (int i = 0; i <= 150; i++) { // Cambia 150 por la altura deseada
                    panel.setBounds(panel.getX(), panel.getY(), panel.getWidth(), i);

                    // Mueve los componentes debajo del panel
                    for (JComponent component : componentsBelow) {
                        component.setBounds(component.getX(), panel.getY() + i + 10, component.getWidth(), component.getHeight());
                    }

                    try {
                        Thread.sleep(3); // Ajusta este valor para cambiar la velocidad
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        } else { // Ocultar el panel
            new Thread(() -> {
                for (int i = panel.getHeight(); i >= 0; i--) {
                    panel.setBounds(panel.getX(), panel.getY(), panel.getWidth(), i);

                    // Mueve los componentes debajo del panel
                    for (JComponent component : componentsBelow) {
                        component.setBounds(component.getX(), panel.getY() + i + 10, component.getWidth(), component.getHeight());
                    }

                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        }
    }

    
    public void setupButtonAction(JButton btn, JPanel panel, java.util.List<JComponent> componentsBelow) {
        btn.addActionListener(e -> animatePanel(panel, componentsBelow));
    }
    
    public void buttonPanel(JButton btn, JPanel pal) {
        pal.setVisible(false);
        btn.addActionListener(e -> pal.setVisible(!pal.isVisible()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnIngrediente;
    private javax.swing.JButton btnMaestro;
    private javax.swing.JButton btnMaestro1;
    private javax.swing.JButton btnReceta;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel panelMaestro;
    // End of variables declaration//GEN-END:variables
}

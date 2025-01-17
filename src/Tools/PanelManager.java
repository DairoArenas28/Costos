/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author DanielSantiago
 */
public class PanelManager {
    private JPanel bodyPanel;

    // Constructor para inicializar el panel principal
    public PanelManager(JPanel bodyPanel) {
        this.bodyPanel = bodyPanel;
        //this.bodyPanel.setLayout(new BorderLayout());
    }

    // Método para mostrar un formulario en el panel
    public void showForm(JPanel form) {
        // Limpiar el contenido previo del bodyPanel
        bodyPanel.removeAll();

        bodyPanel.add(form, BorderLayout.CENTER);
        // Agregar el nuevo formulario
        form.setPreferredSize(bodyPanel.getSize());

        // Actualizar el layout y refrescar el panel
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}

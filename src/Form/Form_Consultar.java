 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import Clases.CallBack;
import Clases.Item;
import Clases.Query;
import Tools.DescripTable;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanielSantiago
 */
public class Form_Consultar extends javax.swing.JFrame {

    /**
     * Creates new form Form_Consultar
     */
    
    private CallBack callback;
    
    private static String tableName;
    
    private boolean checkinactivo;
    
    private List<String> itemSearch;
    
    private List<String> descrip;
    
    private static Map<String, Object> firstItem;
    
    private static String[] columnNames;
    
    List<Map<String, Object>> data;
    
    //JComboBox<String> comboSearch = new JComboBox<>();
    
    DescripTable descripTable = new DescripTable();
    
    Query qry = new Query();
    
    public Form_Consultar(CallBack callback, String tableName, List<String> itemSearch ) {
        initComponents();
        this.callback = callback;
        this.tableName = tableName;
        this.itemSearch = itemSearch;
        
        tableEncabezado.getTableHeader().setOpaque(false);
        tableEncabezado.getTableHeader().setBackground(new Color(0,71,171));
        tableEncabezado.getTableHeader().setForeground(Color.white);
        tableEncabezado.setRowHeight(25);
        
        try {
            checkinactivo = checkInactivo.isSelected();
            data = qry.obtenerRegistrosComoMap(tableName,itemSearch,checkinactivo);
        } catch (Exception e) {
        }
        
        fillTableFromList();
        SeletedRowTable();
        llenarComboBox();
        
        
    }
    
    private void SeletedRowTable() {
        tableEncabezado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Obtener la fila seleccionada
                int filaSeleccionada = tableEncabezado.getSelectedRow();

                // Verificar que haya una fila seleccionada
                if (filaSeleccionada != -1) {
                    List<String> dato = new ArrayList<>();
                    for (int i = 0; i < tableEncabezado.getColumnCount(); i++) {
                        Object cellValue = tableEncabezado.getValueAt(filaSeleccionada, i);
                        String data;

                        if (cellValue == null) {
                            data = "N/A";
                        } else {
                            data = cellValue.toString();
                        }

                        dato.add(data);
                    }
                    if (callback != null) {
                        callback.onDataReceived(dato);
                    }
                    dispose(); // Cerrar el formulario secundario
                }
            }
        });
    }
    
    public void llenarComboBox() {
        // Lista para almacenar las descripciones
        ArrayList<String> descrip = new ArrayList<>();

        // Llenar la lista según la tabla
        switch (tableName) {
            case "Proveedor":
                descrip.add("Hola");
                descrip.add("Proveedor 1");
                descrip.add("Proveedor 2");
                break;
            case "TipoIngrediente":
                descrip.add("Cliente 1");
                descrip.add("Cliente 2");
                break;
            default:
                descrip.add("Sin datos");
                break;
        }

        // Limpiar el combo box antes de llenarlo
        comboSearch.removeAllItems();

        // Agregar cada elemento de la lista al combo box
        for (String item : descrip) {
            comboSearch.addItem(item);
        }
    }
    
    public void fillTableFromList() {
        if (data == null || data.isEmpty()) {
            return;
        }

        // Obtener los nombres de las columnas del primer mapa (esto asume que todos los mapas tienen las mismas claves)
        firstItem = data.get(0);
        columnNames = firstItem.keySet().toArray(new String[0]);
        //System.out.println(firstItem);
        // Crear el modelo de la tabla con los nombres de las columnas
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }
        };

        // Llenar el modelo con los datos
        for (Map<String, Object> rowMap : data) {
            Object[] row = new Object[columnNames.length];

            for (int i = 0; i < columnNames.length; i++) {
                row[i] = rowMap.get(columnNames[i]); // Obtener el valor de cada celda utilizando la clave
            }

            // Agregar la fila al modelo
            tableModel.addRow(row);
        }

        // Asignar el modelo al JTable
        tableEncabezado.setModel(tableModel);
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
        textCodigo = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        comboSearch = new javax.swing.JComboBox<>();
        checkInactivo = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEncabezado = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 71, 171));

        textCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnConsultar.setBackground(new java.awt.Color(204, 204, 255));
        btnConsultar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        btnConsultar.setDefaultCapable(false);
        btnConsultar.setFocusPainted(false);
        btnConsultar.setFocusable(false);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        checkInactivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkInactivo.setForeground(new java.awt.Color(255, 255, 255));
        checkInactivo.setText("Inactivo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkInactivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkInactivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 360));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        tableEncabezado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableEncabezado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableEncabezado.setAutoscrolls(false);
        tableEncabezado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableEncabezado.setFocusable(false);
        tableEncabezado.setOpaque(false);
        tableEncabezado.setRowHeight(25);
        tableEncabezado.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tableEncabezado.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableEncabezado);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 3, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 540, 360));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/close_32.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setDefaultCapable(false);
        jButton3.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(706, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 750, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // Obtener el campo seleccionado y el término de búsqueda
        //JOptionPane.showMessageDialog(null, "Hola");
        String campoSeleccionado = (String) comboSearch.getSelectedItem();
        String terminoBusqueda = textCodigo.getText();
        itemSearch = Arrays.asList("sNombre",terminoBusqueda);
        try {
            data = qry.obtenerRegistrosComoMap(tableName,itemSearch,checkinactivo);
        } catch (Exception e) {
        }

        // Filtrar los datos según el campo y término de búsqueda
        /*List<Map<String, Object>> resultados = new ArrayList<>();
        for (Map<String, Object> row : data) {
            Object valor = row.get(campoSeleccionado);
            if (valor != null && valor.toString().toLowerCase().contains(terminoBusqueda)) {
                resultados.add(row);
            }
        }*/

        // Mostrar los resultados en la tabla
        fillTableFromList();
    }//GEN-LAST:event_btnConsultarActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Consultar(this).setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JCheckBox checkInactivo;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableEncabezado;
    private javax.swing.JTextField textCodigo;
    // End of variables declaration//GEN-END:variables
}

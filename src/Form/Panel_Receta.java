/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form;

import Clases.CallBack;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanielSantiago
 */
public class Panel_Receta extends javax.swing.JPanel {

    /**
     * Creates new form Panel_Receta
     */
    DefaultTableModel modelo;
    private boolean actualizando = false;
    float countTotal;
    public Panel_Receta() {
        initComponents();
        
        tableDetalle.getTableHeader().setOpaque(false);
        tableDetalle.getTableHeader().setBackground(new Color(0,71,171));
        tableDetalle.getTableHeader().setForeground(Color.white);
        tableDetalle.setRowHeight(25);
        /*JTextField textField = new  JTextField();
        textField.setPreferredSize(new Dimension(200,30));
        panelGeneral.add(textField);
        
        panelGeneral.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Permite que se expanda horizontalmente
        gbc.insets = new Insets(0, 0, 0, 0); // Márgenes
        panelGeneral.add(textField, gbc);
        panelGeneral.add(textField, gbc);*/
        
        modelo = (DefaultTableModel) tableDetalle.getModel();
        
        modelo.addTableModelListener(e -> {
            if (actualizando) return; // Si estamos actualizando, no ejecutar el evento nuevamente

            int filaSeleccionada = tableDetalle.getSelectedRow();
            if (e.getType() == TableModelEvent.UPDATE) {
                int fila = e.getFirstRow();
                int columna = e.getColumn();
                Object nuevoValor = modelo.getValueAt(fila, columna);
                String valorString = (nuevoValor != null) ? nuevoValor.toString() : "";

                // Si la columna seleccionada es la 1 (índice 0 en base 0)
                if (columna == 0) {
                    //System.out.println("Celda modificada en fila: " + fila + ", columna: " + columna);
                    //System.out.println("Nuevo valor: " + nuevoValor);

                    Form_Consultar formConsultar = new Form_Consultar(new CallBack() {
                        @Override
                        public void onDataReceived(List<String> data) {
                            actualizando = true; // Evita que el evento se dispare otra vez

                            modelo.setValueAt(data.get(4), filaSeleccionada, 0);
                            modelo.setValueAt(data.get(5), filaSeleccionada, 1);
                            modelo.setValueAt(Float.parseFloat(data.get(6).toString()), filaSeleccionada, 4);

                            actualizando = false; // Reactiva el evento después de actualizar
                        }
                    }, "Ingrediente", Arrays.asList("sCodigo", valorString));

                    formConsultar.setVisible(true);
                    formConsultar.setLocationRelativeTo(null);
                    formConsultar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
                if(columna == 3){
                    Object precio = modelo.getValueAt(filaSeleccionada, 4);
                    float precioFloat = 0.0f; // Valor por defecto

                    if(precio instanceof Number) {  
                        precioFloat = ((Number) precio).floatValue(); // Conversión directa si ya es un número
                    } else if (precio instanceof String && !((String) precio).isEmpty()) {
                        precioFloat = Float.parseFloat((String) precio); // Convertir si es un String válido
                    }
                    
                    Object bruto = modelo.getValueAt(filaSeleccionada, 3);
                    float brutoFloat = 0.0f; // Valor por defecto

                    if(bruto instanceof Number) {  
                        brutoFloat = ((Number) bruto).floatValue(); // Conversión directa si ya es un número
                    } else if (bruto instanceof String && !((String) bruto).isEmpty()) {
                        brutoFloat = Float.parseFloat((String) bruto); // Convertir si es un String válido
                    }

                    // Multiplicar por 5 y actualizar la tabla
                    modelo.setValueAt(brutoFloat * precioFloat, filaSeleccionada, 5);
                    
                    Calcular();
                }
            }
        });
        /*tableDetalle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tableDetalle.getSelectedRow();  // Obtener fila seleccionada
                int columna = tableDetalle.getSelectedColumn();  // Obtener columna seleccionada

                // Si la columna seleccionada es la 2 (índice 1 en base 0)
                if (columna == 1) {
                    abrirFormulario(fila);  // Llamar al formulario
                }
            }
        });*/
    }

    
    private void abrirFormulario(int fila) {
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog((Frame) parentWindow, "Formulario", true);
        dialog.setSize(250, 150);
        dialog.setLayout(new FlowLayout());
        dialog.add(new JLabel("Formulario para la fila: " + (fila + 1)));
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dialog.dispose());
        dialog.add(cerrar);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        addMenuTable = new javax.swing.JMenuItem();
        deleteMenuTable = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDetalle = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        textCodigo = new javax.swing.JTextField();
        textDescrip = new javax.swing.JTextField();
        textFecha = new javax.swing.JTextField();
        floatCostoUnitario = new javax.swing.JFormattedTextField();
        floatCostoTotal = new javax.swing.JFormattedTextField();
        realGanancia = new javax.swing.JFormattedTextField();
        floatPrecioVenta = new javax.swing.JFormattedTextField();
        floatPrecioVentaIVA = new javax.swing.JFormattedTextField();
        realIVA = new javax.swing.JFormattedTextField();
        Código = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        floatTotal = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        addMenuTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/boton-agregar_24.png"))); // NOI18N
        addMenuTable.setText("Agregar");
        addMenuTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuTableActionPerformed(evt);
            }
        });
        popupMenu.add(addMenuTable);

        deleteMenuTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar_24_1.png"))); // NOI18N
        deleteMenuTable.setText("Eliminar");
        deleteMenuTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuTableActionPerformed(evt);
            }
        });
        popupMenu.add(deleteMenuTable);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new java.awt.BorderLayout());

        tableDetalle.setAutoCreateRowSorter(true);
        tableDetalle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Neto", "Bruto", "Precio Unitario", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDetalle.setAutoscrolls(false);
        tableDetalle.setComponentPopupMenu(popupMenu);
        tableDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableDetalle.setOpaque(false);
        tableDetalle.setRowHeight(25);
        tableDetalle.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tableDetalle.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableDetalle);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        textCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        textDescrip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textDescrip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        textFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        floatCostoUnitario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        floatCostoUnitario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        floatCostoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        realGanancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        floatPrecioVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        floatPrecioVenta.setPreferredSize(new java.awt.Dimension(64, 22));

        floatPrecioVentaIVA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        floatPrecioVentaIVA.setMinimumSize(new java.awt.Dimension(64, 22));

        realIVA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        realIVA.setMinimumSize(new java.awt.Dimension(64, 22));

        Código.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Código.setText("Código");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Fecha");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Descripción");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Costo Unitario");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Costo Total");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ganancia");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Precio Venta");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Precio Venta IVA");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("IVA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Código))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(floatCostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(floatCostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(realGanancia, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(floatPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(floatPrecioVentaIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(realIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Código)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFecha)
                        .addComponent(textDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(floatCostoTotal)
                            .addComponent(realGanancia)
                            .addComponent(floatCostoUnitario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(floatPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(floatPrecioVentaIVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(realIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        floatTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        floatTotal.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        floatTotal.setEnabled(false);
        floatTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setLabelFor(floatTotal);
        jLabel1.setText("TOTAL");

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Guardar");

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Cancelar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(floatTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addGap(5, 5, 5)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(floatTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addMenuTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuTableActionPerformed
        modelo.addRow(new Object[]{"", "", 0, 0, 0, 0}); // Agrega una fila vacía
    }//GEN-LAST:event_addMenuTableActionPerformed

    private void deleteMenuTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuTableActionPerformed
        int filaSeleccionada = tableDetalle.getSelectedRow();
        // Verificar que haya una fila seleccionada
        if (filaSeleccionada != -1) {
            int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar el registro?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                if(modelo.getRowCount() > 1){
                    modelo.removeRow(filaSeleccionada);
                } else {
                    JOptionPane.showMessageDialog(this, "Debes dejar una fila en la tabla", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteMenuTableActionPerformed

    public void Calcular() {
        BigDecimal countTotal = BigDecimal.ZERO;
        DecimalFormat formato = new DecimalFormat("#,##0.00"); // Usa separador de miles y 2 decimales

        for (int i = 0; i < modelo.getRowCount(); i++) {  // Itera sobre las filas
            Object valor = modelo.getValueAt(i, 5);  // Obtiene el valor de la celda

            try {
                if (valor instanceof Number number) {  
                    countTotal = countTotal.add(new BigDecimal(number.toString()));
                } else if (valor instanceof String && !((String) valor).trim().isEmpty()) {
                    countTotal = countTotal.add(new BigDecimal(((String) valor).replace(",", "."))); // Convierte cadena a número
                }
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir valor en fila " + i + ": " + valor);
            }

            System.out.println("Fila " + i + ", Columna " + 5 + ": " + countTotal);
        }

        floatTotal.setText(formato.format(countTotal)); // Formato con separador de miles
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Código;
    private javax.swing.JMenuItem addMenuTable;
    private javax.swing.JMenuItem deleteMenuTable;
    private javax.swing.JFormattedTextField floatCostoTotal;
    private javax.swing.JFormattedTextField floatCostoUnitario;
    private javax.swing.JFormattedTextField floatPrecioVenta;
    private javax.swing.JFormattedTextField floatPrecioVentaIVA;
    private javax.swing.JFormattedTextField floatTotal;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JFormattedTextField realGanancia;
    private javax.swing.JFormattedTextField realIVA;
    private javax.swing.JTable tableDetalle;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textDescrip;
    private javax.swing.JTextField textFecha;
    // End of variables declaration//GEN-END:variables
}

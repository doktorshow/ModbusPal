/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modbuspal.master;

/**
 *
 * @author jmc15
 */
public class ModbusRequestDialog 
extends javax.swing.JDialog 
{
    private boolean isOK = false;

    /**
     * Creates new form ModbusRequestDialog
     */
    public ModbusRequestDialog() 
    {
        setModalityType(ModalityType.DOCUMENT_MODAL);
        initComponents();
    }

    
    ModbusMasterRequest getRequest()
    {
        if( actionSelectorTabbedPane.getSelectedComponent()==x03_readHoldingRegistersPanel )
        {
            int startingAddress = x03_startingAddressTextField.getInteger();
            int quantityOfRegisters = x03_quantityToReadTextField.getInteger();
            return ModbusMasterRequest.getReadHoldingRegistersRequest(startingAddress, quantityOfRegisters);
        }
        
        else if( actionSelectorTabbedPane.getSelectedComponent()==x10_writeHoldingRegistersPanel )
        {
            int startingAddress = x10_startingAddressTextField.getInteger();
            int quantityOfRegisters = x10_quantityToReadTextField.getInteger();
            return ModbusMasterRequest.getWriteMultipleRegistersRequest(startingAddress, quantityOfRegisters);
        }
        
        return null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        actionSelectorTabbedPane = new javax.swing.JTabbedPane();
        x03_readHoldingRegistersPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        x03_startingAddressTextField = new modbuspal.toolkit.NumericTextField();
        jLabel1 = new javax.swing.JLabel();
        x03_quantityToReadTextField = new modbuspal.toolkit.NumericTextField();
        x10_writeHoldingRegistersPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        x10_startingAddressTextField = new modbuspal.toolkit.NumericTextField();
        jLabel4 = new javax.swing.JLabel();
        x10_quantityToReadTextField = new modbuspal.toolkit.NumericTextField();
        jPanel1 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Request");
        setMinimumSize(new java.awt.Dimension(300, 300));

        x03_readHoldingRegistersPanel.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Starting address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 2, 2);
        x03_readHoldingRegistersPanel.add(jLabel2, gridBagConstraints);

        x03_startingAddressTextField.setColumns(5);
        x03_startingAddressTextField.setText("numericTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 2, 5);
        x03_readHoldingRegistersPanel.add(x03_startingAddressTextField, gridBagConstraints);

        jLabel1.setText("Quantity of registers :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 5, 2);
        x03_readHoldingRegistersPanel.add(jLabel1, gridBagConstraints);

        x03_quantityToReadTextField.setColumns(5);
        x03_quantityToReadTextField.setText("numericTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 5, 5);
        x03_readHoldingRegistersPanel.add(x03_quantityToReadTextField, gridBagConstraints);

        actionSelectorTabbedPane.addTab("Read Holding registers", x03_readHoldingRegistersPanel);

        x10_writeHoldingRegistersPanel.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Starting address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 2, 2);
        x10_writeHoldingRegistersPanel.add(jLabel3, gridBagConstraints);

        x10_startingAddressTextField.setColumns(5);
        x10_startingAddressTextField.setText("numericTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 2, 5);
        x10_writeHoldingRegistersPanel.add(x10_startingAddressTextField, gridBagConstraints);

        jLabel4.setText("Quantity of registers :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 5, 2);
        x10_writeHoldingRegistersPanel.add(jLabel4, gridBagConstraints);

        x10_quantityToReadTextField.setColumns(5);
        x10_quantityToReadTextField.setText("numericTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 5, 5);
        x10_writeHoldingRegistersPanel.add(x10_quantityToReadTextField, gridBagConstraints);

        actionSelectorTabbedPane.addTab("Write Holding registers", x10_writeHoldingRegistersPanel);

        getContentPane().add(actionSelectorTabbedPane, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel1.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        isOK = false;
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        isOK = true;
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    public boolean isOK()
    {
        return isOK;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane actionSelectorTabbedPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private modbuspal.toolkit.NumericTextField x03_quantityToReadTextField;
    private javax.swing.JPanel x03_readHoldingRegistersPanel;
    private modbuspal.toolkit.NumericTextField x03_startingAddressTextField;
    private modbuspal.toolkit.NumericTextField x10_quantityToReadTextField;
    private modbuspal.toolkit.NumericTextField x10_startingAddressTextField;
    private javax.swing.JPanel x10_writeHoldingRegistersPanel;
    // End of variables declaration//GEN-END:variables
}
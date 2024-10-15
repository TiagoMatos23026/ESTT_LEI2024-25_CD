/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CD_ProjCurriculumDigital.menus;

import CD_ProjCurriculumDigital.classes.Evento;
import CD_ProjCurriculumDigital.classes.Blockchain;
import CD_ProjCurriculumDigital.classes.Hash;
import static CD_ProjCurriculumDigital.classes.Hash.getHash;
import CD_ProjCurriculumDigital.classes.MerkleTree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

/**
 *
 * @author tiago
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }
    
    private Blockchain bc = new Blockchain();
    private MerkleTree tree = new MerkleTree();

    private JList<String> list;
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 350));

        jLabel1.setBackground(new java.awt.Color(200, 200, 200));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Currículo Digital");

        jLabel2.setText("Nome Completo");

        jList1.setModel(listModel);
        jScrollPane1.setViewportView(jList1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Evento");

        jButton1.setText("Adicionar Evento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Listar Currículos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Acerca de...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Extract data from text fields
        String nomePessoa = jTextField1.getText();
        String infoEvento = jTextField2.getText();
        
        String hash = getHash(infoEvento);
        JOptionPane.showMessageDialog(this, hash);


        // Call the separate method to handle the event creation and saving
        saveEventoToFile(nomePessoa, infoEvento);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadFromFile();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadListaCurriculos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(this, "Tiago Matos, 23026\nJosé Sousa, 20488");
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
    private String getHashFromEvento (String evento){
        String evt = getHash(evento);
        return evt;
    }

    //
    // Método para adicionar novo Evento ao Currículo da pessoa
    //
    private void saveEventoToFile(String nomePessoa, String infoEvento) {
        // Split infoEvento into nomeEvento and dataEvento
        String[] parts = infoEvento.split(";", 2); // Split into two parts
        if (parts.length < 2) {
            JOptionPane.showMessageDialog(this, "Por favor insira o nome do evento e a data em que este ocorreu separados por um ';' ");
            return;
        }

        String nomeEvento = parts[0];
        String dataEvento = parts[1];

        // Create a new Evento object
       // Evento evento = new Evento(nomePessoa, nomeEvento, dataEvento);

        // Generate the filename of the person
        String fileName = nomePessoa.toLowerCase().replace(" ", "") + "curriculum.txt";
        File file = new File(fileName);

        // Check if the event already exists in the curriculum
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Check if the event already exists by comparing the event name (ignores date)
                    if (line.contains(nomeEvento)) {
                        JOptionPane.showMessageDialog(this, "Este evento já existe no currículo!");
                        return;  // Exit if the event already exists
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao ler o ficheiro: " + e.getMessage());
                return;
            }
        }

        // File operations: Append new event to the file
        try (FileWriter writer = new FileWriter(file, true)) {
            //writer.write(evento.toString() + "\n");
            JOptionPane.showMessageDialog(this, "Evento inserido com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao inserir evento: " + e.getMessage());
        }

        // Update the list of curriculums (listaCurriculos)
        updateListaCurriculos(nomePessoa);
    }

    //
    // Método para atualizar lista de Currículos ao ser inserido um novo nome
    //
    private void updateListaCurriculos(String nomePessoa) {
        File listaFile = new File("listaCurriculos.txt");

        // If the file doesn't exist, create it and add the name immediately
        if (!listaFile.exists()) {
            try (FileWriter writer = new FileWriter(listaFile)) {
                writer.write(nomePessoa + "\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao criar uma lista de Currículos: " + e.getMessage());
            }
            return;
        }

        // If the file exists, check if the name is already listed
        try (BufferedReader reader = new BufferedReader(new FileReader(listaFile))) {
            String line;
            boolean nameExists = false;

            // Read each line to check if the person's name already exists
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(nomePessoa)) {
                    nameExists = true;
                    break;
                }
            }

            // If the name does not exist, append it to the file
            if (!nameExists) {
                try (FileWriter writer = new FileWriter(listaFile, true)) {
                    writer.write(nomePessoa + "\n");
                    JOptionPane.showMessageDialog(this, nomePessoa + " adiciona à lista de Currículos.");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar a lista de Currículos: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao ler a lista de Currículos: " + e.getMessage());
        }
    }

    //
    // Método para listar as pessoas que têm Currículos
    //
    private void loadListaCurriculos() {
        // Create list model to hold the content
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        // Reference the listaCurriculos.txt file
        File listaFile = new File("listaCurriculos.txt");

        // Check if the file exists
        if (!listaFile.exists()) {
            JOptionPane.showMessageDialog(this, "O ficheiro 'listaCurriculos.txt' não existe.");
            return;
        }

        // Read the file and populate the JList with its content
        try (BufferedReader reader = new BufferedReader(new FileReader(listaFile))) {
            // Clear the previous content in the list
            if (listModel != null) {
                listModel.clear();
            }

            // Read the file line by line and add each line (person's name) to the list
            String line;
            while ((line = reader.readLine()) != null) {
                listModel.addElement(line);  // Add each name from listaCurriculos.txt
            }

            JOptionPane.showMessageDialog(this, "Sucesso ao carregar a lista de currículos!");
        } catch (IOException ex) {
            // Handle any I/O exceptions
            JOptionPane.showMessageDialog(this, "Erro ao ler o ficheiro 'listaCurriculos.txt': " + ex.getMessage());
        }

        // Set the model for the jList to display the loaded names
        jList1.setModel(listModel);

    }

    //
    // Método para carregar Currículo da pessoa selecionada
    //
    private void loadFromFile() {
        // Check if any item is selected in the list
        String selectedPerson = jList1.getSelectedValue();

        if (selectedPerson == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma pessoa da lista.");
            return;
        }

        // Convert the person's name to the format of the file name
        String fileName = selectedPerson.toLowerCase().replace(" ", "") + "curriculum.txt";
        File file = new File(fileName);

        // Check if the file exists for the selected person
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "Erro: O ficheiro para " + selectedPerson + " não existe.");
            return;
        }

        // Create list model to hold the content
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        // Read the file and populate the JList with its content
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Clear the previous content in the list
            if (listModel != null) {
                listModel.clear();
            }

            // Read the file line by line and add each event (line) to the list
            String line;
            while ((line = reader.readLine()) != null) {
                listModel.addElement(line);  // Add each event from the file
            }

            JOptionPane.showMessageDialog(this, "Currículo de " + selectedPerson + " carregado com sucesso!");
        } catch (IOException ex) {
            // Handle any I/O exceptions
            JOptionPane.showMessageDialog(this, "Erro ao ler o ficheiro: " + ex.getMessage());
        }

        // Set the model for the jList to display the loaded curriculum events
        jList1.setModel(listModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

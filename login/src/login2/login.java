/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login2;


import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;


public class login extends javax.swing.JFrame {

    private Component confirmation;
    private String usuario,password;
    Conexion cx;
    public login() {
        initComponents();
        this.setTitle("Login");
        this.setSize(400, 500);
        Image img=Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo3.png"));
        lblLogo.setIcon(new ImageIcon(img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
        this.setIconImage(img);
        this.setLocationRelativeTo(null);
        cx = new Conexion("login_hookah");
        txtUsuario.setFocusable(true);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        Registrarme = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Correo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 60, 20));

        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 183, 236, 30));

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 136, 33));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 125, 33));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo3.png"))); // NOI18N
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 220, 150));
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 242, 240, 30));

        jLabel3.setText("Aun no tienes cuentas?");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 140, -1));

        Registrarme.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Registrarme.setText("Registrarme");
        Registrarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarmeActionPerformed(evt);
            }
        });
        getContentPane().add(Registrarme, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(confirmation,"Desea salir?","Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
            if (eleccion == JOptionPane.YES_OPTION)
            {
            System.exit(0);
            }else{

            }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        try {
             
             usuario=txtUsuario.getText();
             password=String.valueOf(txtPass.getPassword());
             
            if(txtUsuario.getText().equals("") &&  String.valueOf(txtPass.getPassword()).equals("")){
                JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña estan vacios\nIngrese los por favor.");
                txtUsuario.setFocusable(true);
            }else if(txtUsuario.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Usuario está vacio\nIngrese lo por favor.");
                txtUsuario.setFocusable(true);
            }else if(String.valueOf(txtPass.getPassword()).equals("")){
                JOptionPane.showMessageDialog(this,"Contraseña está vacio\nIngrese lo por favor.");
                txtPass.setFocusable(true);
            }
            else if(txtUsuario.getText().compareTo(usuario)!=0 && String.valueOf(txtPass.getPassword()).compareTo(password)!=0){
                JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña no válidos\nIngrese nuevamente.");
                 txtUsuario.setFocusable(true);
            }
            else if(txtUsuario.getText().compareTo(usuario)!=0){
                JOptionPane.showMessageDialog(this,"Usuario no válido\nIngrese nuevamente.");
                txtUsuario.setFocusable(true);
            }else if(String.valueOf(txtPass.getPassword()).compareTo(password)!=0){
                JOptionPane.showMessageDialog(this,"Contraseña no válida\nIngrese nuevamente.");
                txtPass.setFocusable(true);
            }else{
            
            String query = "SELECT * FROM usuario WHERE Estado='Activo' AND Estatus=1";
            Statement st= cx.conectar().createStatement();
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next()){
               Object [] opciones ={"Aceptar","Cancelar"};
               int eleccion = JOptionPane.showOptionDialog(confirmation,"Hay un usuario activo debe esperar que cierre","Confirmacion",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
                    if (eleccion == JOptionPane.YES_OPTION)
                    {
                    eleccion = JOptionPane.showOptionDialog(confirmation,"Deseas cerrar el programa e ingresar más tarde","Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
                    if (eleccion == JOptionPane.YES_OPTION)
                    {
                       System.out.println(0);
                    }else{
                    }
                    }else{
                    }
            }else{
                
            query = "SELECT * FROM usuario WHERE Correo='"+usuario+"' and Password='"+password+"' AND Estatus=1";
            rs=st.executeQuery(query);
            
            if(rs.next()){
                query = "UPDATE usuario SET Estado='Activo' WHERE Correo='"+usuario+"' AND Estatus=1";
                st.executeQuery(query);
                JOptionPane.showMessageDialog(this, "El usuario exite en la base de datos");
               

            }else{
                JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña invalidos.");
                txtUsuario.setFocusable(true);
            }
           }
          }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void RegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarmeActionPerformed
        // TODO add your handling code here:
        registrar Registrar= new registrar();
        Registrar.setVisible(true);
        Registrar.pack();
        Registrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_RegistrarmeActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                login lf = new login();
                lf.setVisible(true);
                lf.pack();
                lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            }

            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Registrarme;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}



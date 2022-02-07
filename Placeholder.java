/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.af.placeholder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Ismael Farinango
 * 
 * This class is used to place placeholders in JTextField and JPasswordField components.
 */
public class Placeholder {
    private JTextField textField;
    private String txt_textField;
    private static JPasswordField passwordField;
    private static String txt_passwordField;

    public Placeholder() {
    }
    public Placeholder(JTextField jTextField, String text) {
        textField=jTextField;
        this.txt_textField=text;
        textField.setText(text);
        textField.setForeground(new Color(184,186,186));
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent event){
                jTextFieldMouseClicked(event);
            }
        });
        
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFocusLost(evt);
            }
        });
    }

    public Placeholder(JPasswordField passwordField, String text) {
        Placeholder.passwordField=passwordField;
        Placeholder.txt_passwordField=text;
        Placeholder.passwordField.setText(text);
        Placeholder.passwordField.setEchoChar((char)0);
        Placeholder.passwordField.setForeground(new Color(184,186,186));
        Placeholder.passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent event){
                jPasswordFieldClicked(event);
            }
        });
        
        Placeholder.passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusLost(evt);
            }
        });
    }
    
    private void jPasswordFieldClicked(java.awt.event.MouseEvent event){
         passwordField.setEchoChar('*');
         passwordField.setForeground(new Color(0,0,0));
        if(!isModifiedPassword()){
            passwordField.setText("");
        }
    }
    
    private void jPasswordFieldFocusLost(java.awt.event.FocusEvent evt){
        if(isEmpetyPassword()){
            passwordField.setText(txt_passwordField);
            passwordField.setEchoChar((char)0);
            passwordField.setForeground(new Color(184,186,186));
        }
    }
    
    private void jTextFieldMouseClicked(java.awt.event.MouseEvent event){
        textField.setForeground(new Color(0,0,0));
        if(!isModified()){
          textField.setText("");
        }
    }
    
    private void jTextFieldFocusLost(java.awt.event.FocusEvent evt){
        if(isEmpety()){
            textField.setText(txt_textField);
            textField.setForeground(new Color(184,186,186));
        }
    }
    
    private boolean isEmpety(){
        return textField.getText().equals("");
    }
    
    private boolean isModified(){
        return !textField.getText().equals(txt_textField);
    }
    
    private boolean isEmpetyPassword(){
        return passwordField.getText().equals("");
    }
    
    private boolean isModifiedPassword(){
        return !passwordField.getText().equals(txt_passwordField);
    }

    public String getTxt_textField() {
        return txt_textField;
    }

    public static String getTxt_passwordField() {
        return txt_passwordField;
    }
    
    
}

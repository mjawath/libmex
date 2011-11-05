/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.components.util;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import org.components.parent.Documents.DoubleDocument;
import org.components.parent.Documents.NumberDocument;

/**
 *
 * @author mjawath
 */
public class ComponentFactory {

    public static  void createDoubleTextField(JTextField field){
        field.setDocument(new DoubleDocument());
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                try {
                    String txt= ((JTextField)input).getText();
                    if (txt.isEmpty()) {
                        return true;
                    }
                      Double ver= Double.parseDouble(txt);
                return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }
    public static  void createDoubleTextField(JTextField field,boolean zero){
        field.setDocument(new DoubleDocument());
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                try {
                    String txt= ((JTextField)input).getText();
                    if (txt.isEmpty()) {
                        return true;
                    }
                      Double ver= Double.parseDouble(txt);
                return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }

    public static  void createLongTextField(JTextField field){
        field.setDocument(new NumberDocument());
        field.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                try {
                    String txt= ((JTextField)input).getText();
                    if (txt.isEmpty()) {
                        return true;
                    }
                      Long ver= Long.parseLong(txt);
                return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        field.setHorizontalAlignment(JTextField.RIGHT);
    }
    public static  void createLongTextField(JTextField field,boolean  zero){
        field.setDocument(new NumberDocument(zero));
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                try {
                    String txt= ((JTextField)input).getText();
                    if (txt.isEmpty()) {
                        return true;
                    }
                      Long ver= Long.parseLong(txt);
                return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CLabel.java
 *
 * Created on Dec 27, 2010, 10:34:55 PM
 */
package org.components.controls;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;
import org.components.parent.controls.PLabel;

/**
 *
 * @author mjawath
 */
public class TimerLable extends PLabel {

    /** Creates new form BeanForm */
    public TimerLable() {
        initComponents();

        Action updatetime = new AbstractAction() {

            boolean shouldDraw = false;

            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat(" hh : mm : ss  ");
              setText(  sdf.format( date ));
            }
        };

        new Timer(1000, updatetime).start();

    }


/** This method is called from within the constructor to
 * initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is
 * always regenerated by the Form Editor.
 */
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
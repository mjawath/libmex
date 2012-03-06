/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LineItemPanel.java
 *
 * Created on Feb 23, 2012, 10:21:43 PM
 */
package invoicingsystem;

import com.sun.awt.AWTUtilities;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.biz.app.ui.util.TableUtil;
import org.biz.app.ui.util.uiEty;

/**
 *
 * @author nnjj
 */
public class LineItemPanel extends javax.swing.JDialog {

    Object lineitem;
    public LineItemPanel(JFrame jf) {
        super(jf,true);
    }
    /** Creates new form LineItemPanel */
    public LineItemPanel() {
        super();

        setModal(true);

        this.setModalityType(ModalityType.MODELESS);
        setFocusableWindowState(false);
        setUndecorated(true);
//        setLocationRelativeTo(fr);
//        initComponents();
        getRootPane().setOpaque(false);
//        AWTUtilities.setWindowOpacity(this, 0.8f);
        setFocusableWindowState(true);
        setSize(900, 100);
        setPreferredSize(new Dimension(900, 100));
        initComponents();

    }


    
    public void showWithoutFocus() {
               
                int x = (int) jt.getLocationOnScreen().x;
                int y = (int) jt.getLocationOnScreen().y;
                int sr = jt.getSelectedRow();
                int hight = (sr + 1) * jt.getRowHeight();
                LineItemPanel.this.setLocation(x, y + hight);
//                lineItemDialogPanel.setFocusable(false);
//                LineItemPanel.this.showWithoutFocus();
//                    LineItemPanel.this.
                    selectEty();
                
               
//        setFocusableWindowState(false);
        this.setVisible(true);
//        setFocusableWindowState(true);
//        setFocus();
    }

    public void setFocus() {
        cTextField1.requestFocus();
    }
    JTable jt;

    public void setTable(JTable tbl) {
        this.jt = tbl;

        ///press esc to close 
//Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener(){
//public void eventDispatched(AWTEvent event) {
//if(((KeyEvent)event).getKeyCode()==KeyEvent.VK_ESCAPE && MyDialog.this.isFocused()){
//MyDialog.this.setVisible(false);
//};
//}}, AWTEvent.KEY_EVENT_M
//
//Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
//
//            public void eventDispatched(AWTEvent event) {
//                if (((KeyEvent) event).getKeyCode() == KeyEvent.VK_ESCAPE && LineItemPanel.this.isShowing()) {
//                    LineItemPanel.this.setVisible(false);
//                    ((KeyEvent) event).consume();
//                    System.out.println("line item escaped called");
//                };
//            }
//        }, AWTEvent.KEY_EVENT_MASK);
        uiEty.setKeyAction(this.getRootPane(), new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                LineItemPanel.this.setVisible(false);
//                ((KeyEvent)e).consume();
            }
        }, KeyEvent.VK_ESCAPE);
        uiEty.setKeyAction(this.getRootPane(), new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                TableUtil.selectNextRow(jt, KeyEvent.VK_UP);
            }
        }, KeyEvent.VK_UP);

        uiEty.setKeyAction(this.getRootPane(), new AbstractAction() {

            public void actionPerformed(ActionEvent e) {

                TableUtil.selectNextRow(jt, KeyEvent.VK_DOWN);
            }
        }, KeyEvent.VK_DOWN);

        
        jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                
                if(!e.getValueIsAdjusting()){       
                    showWithoutFocus();
                }
            }
        });
//        addFocusListener(new FocusAdapter() {
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                LineItemPanel.this.setVisible(false);
//            }
//        });
//        addw
//        cTextField1.addKeyListener(new KeyAdapter() {
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                System.out.println(e);
//            }
//        });
    }
 
    public Object panelToEty() {
    return null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setComponent(JComponent jc, int x, int y, int width, int hieht) {
        jc.setBounds(x, y, width, hieht);
        this.getContentPane().add(jc);
        pack();
    }

    public JTextField getcTextField1() {
        return cTextField1;
    }
      public void dispatchEventx(KeyEvent event) {
        System.out.println("qffffff" + event + event.getComponent());
                cTextField1.requestFocus();
        KeyboardFocusManager.getCurrentKeyboardFocusManager().redispatchEvent(cTextField1, event);

        event.consume();
    }

    public void setcTextField1(JTextField cTextField1) {
        this.cTextField1 = cTextField1;
    }

      protected JTextField cTextField1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public  void selectEty() {
    
    }
}

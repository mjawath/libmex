package invoicingsystem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on Dec 13, 2010, 10:16:22 PM
 */
import invoicingsystem.posted.PostedSalesInvoiceUI;
import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import org.biz.invoicesystem.master.ui.CategoryMasterUI;
import org.biz.invoicesystem.master.ui.ItemMasterUI;
import org.biz.invoicesystem.master.ui.ProductMasterUI;
import org.components.util.Sessions;
import org.components.windows.TabPanelUI;

/**
 *
 * @author mjawath
 */
public class MainAppWindow extends app.AppMainWindow {

    public MainAppWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
//            UIManager.put("javax.swing.plaf.FontUIResource","'Tahoma', 0, 24");
            UIManager.put("Table.font", new FontUIResource("Tahoma", 0, 20));
            UIManager.put("Table.background", new ColorUIResource(240, 140, 100));
//            System.setProperty("sun.awt.exception.handler", AwtHandler.class.getName());
        } catch (Exception e) {
        }
        initComponents();
        System.out.println("ddddddddd");
        init();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        cButton1 = new org.components.controls.CButton();
        cstattus = new org.components.controls.CLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(600, 600));

        cButton1.setText("LogOut");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });

        cstattus.setText("");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cstattus, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cstattus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed
//        showlogin();
    }//GEN-LAST:event_cButton1ActionPerformed

    public void init() {
//
//        dbsu = new DBServerUtil();
//        dbsu.init();
//        dbsu.startServer();
//        Sessions.create();
//        Sessions.addToSession("mainui", this);
//        addToTabpanelToUI(new ItemMasterUI(), "Item master");
    }

    public void init2() {

        setjTabbedPane1(jTabbedPane1);
        Sessions.create();

        Sessions.addToSession("mainui", this);
        addToTabpanelToUI(new ItemMasterUI(), "Item master");
//        addToTabpanelToUI(new AccountsCreationUI(), "acoouts master");
        addToTabpanelToUI(new SalesInvoiceUI(), "Invoice master");
        addToTabpanelToUI(new PurchaseInvoiceUI(), " purchase Invoice ");
        addToTabpanelToUI(new ItemInventorySummary(), "item summery");
        addToTabpanelToUI(new CategoryMasterUI(), "cateogory ui");
        addToTabpanelToUI(new ProductMasterUI(), "product master ui");
        addToTabpanelToUI(new PostedSalesInvoiceUI(), "poseted sales invoice");
        addToTabpanelToUI(new GRNUI(), "GRN invoice");
        addToTabpanelToUI(new GDNUI(), "GDN invoice");
        events();
    }

    void showError(Throwable e) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] trace = e.getStackTrace();
        for (int i = 0; i < trace.length; i++) {
            sb.append("\t\nat " + trace[i]);
        }

        Throwable cause = e.getCause();

        sb.append(cause);

        StackTraceElement[] causeTrace = cause.getStackTrace();
        for (int i = 0; i < causeTrace.length; i++) {
            sb.append("\t\nat " + causeTrace[i]);
        }


    }

    public void events() {
        jTabbedPane1.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {



                Component jsp = (Component) jTabbedPane1.getSelectedComponent();
                if (jsp == null) {
                    return;
                }
//                for (Component component : jsp.getComponents()) {
                if (jsp instanceof TabPanelUI) {
                    TabPanelUI tc = (TabPanelUI) jsp;
                    tc.updateEntityUI();
                }
            }
//            }
        });




    }

    public void showlogin() {
        JDialog dd = new JDialog(this, JDialog.ModalityType.MODELESS);
        dd.setSize(400, 300);
        dd.setLocationRelativeTo(null);

        dd.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                final MainAppWindow amw = new MainAppWindow() {
                };
                amw.init2();

                amw.setVisible(true);
                amw.showlogin();
            }
        });




    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CLabel cstattus;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}

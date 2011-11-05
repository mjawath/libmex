package org.components.windows;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on Dec 13, 2010, 10:16:22 PM
 */
import java.awt.Component;
import java.awt.Container;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import org.components.util.Sessions;


/**
 *
 * @author mjawath
 */
public class MainWindow extends JFrame {

    public MainWindow() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
//            UIManager.put("javax.swing.plaf.FontUIResource","'Tahoma', 0, 24");
            UIManager.put("Table.font", new FontUIResource("Tahoma", 0, 20));
            UIManager.put("Table.background", new ColorUIResource(240, 140, 100));
//            System.setProperty("sun.awt.exception.handler", AwtHandler.class.getName());
        } catch (Exception e) {
        }
//        initComponents();
        init();
    }
    String propfile;
    private final String tabBill = "Bill Counter";
    private final String tabviewBill = "View Bills ";
    private final String tabCashier = "Cashier Counter";
    private final String tabParcel = "Parcel Counter";
    private final String tabViewParcel = "View Parcel Counter Bills";
    private final String tabCasBill = "Cashier Bill Counter";
    private final String tab = " Counter";

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cButton1 = new org.components.controls.CButton();
        cstattus = new org.components.controls.CLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mbill = new javax.swing.JMenuItem();
        mcashier = new javax.swing.JMenuItem();
        mitem = new javax.swing.JMenuItem();
        mwaiter = new javax.swing.JMenuItem();
        mwaitertips = new javax.swing.JMenuItem();
        mmenualCash = new javax.swing.JMenuItem();
        mparcelcounter = new javax.swing.JMenuItem();
        msummery = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mdbstart = new javax.swing.JMenuItem();
        mLogin = new javax.swing.JMenuItem();
        mcomptye = new javax.swing.JMenuItem();
        museradmin = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cButton1.setText("LogOut");
        cButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButton1ActionPerformed(evt);
            }
        });

        cstattus.setText("");

        jButton1.setText("jButton1");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Hotel");

        mbill.setText("Bill");
        mbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbillActionPerformed(evt);
            }
        });
        jMenu3.add(mbill);

        mcashier.setText("Cashier");
        jMenu3.add(mcashier);

        mitem.setText("Item");
        jMenu3.add(mitem);

        mwaiter.setText("Staff");
        jMenu3.add(mwaiter);

        mwaitertips.setText("Waiter Tips");
        jMenu3.add(mwaitertips);

        mmenualCash.setText("Menual Cash Entry");
        mmenualCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmenualCashActionPerformed(evt);
            }
        });
        jMenu3.add(mmenualCash);

        mparcelcounter.setText("Parcell Counter");
        jMenu3.add(mparcelcounter);

        msummery.setText("Summery");
        jMenu3.add(msummery);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Admin");

        mdbstart.setText("DB Startup");
        jMenu4.add(mdbstart);

        mLogin.setText("Login");
        jMenu4.add(mLogin);

        mcomptye.setText("Computer Type");
        jMenu4.add(mcomptye);

        museradmin.setText("User Admin");
        jMenu4.add(museradmin);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jButton1)
                .addGap(70, 70, 70)
                .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cstattus, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(630, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cstattus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mmenualCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmenualCashActionPerformed

    }//GEN-LAST:event_mmenualCashActionPerformed

    private void cButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButton1ActionPerformed


        Sessions.remove("user");
        cstattus.setText("You have to login ....");
        Set<String> st = new HashSet<String>();
        for (String string : Sessions.keys()) {
            st.add(string);
        }
        for (String object : st) {
            int s = getjTabbedPane1().indexOfTab(object);
            if (s != -1) {
                System.out.println("s " + s);
                Sessions.remove(object);
            }
        }
        getjTabbedPane1().removeAll();
//        showlogin();
    }//GEN-LAST:event_cButton1ActionPerformed

    private void mbillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbillActionPerformed

    public void init() {
//
//        dbsu = new DBServerUtil();
//        dbsu.init();
//        dbsu.startServer();


        


    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
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
        getjTabbedPane1().addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {

                if (getjTabbedPane1().getSelectedComponent() == null) {
                    return;
                }

                Component jsp = (Component) getjTabbedPane1().getSelectedComponent();

//                for (Component component : jsp.getComponents()) {
                if (jsp instanceof TabPanelUI) {
                    TabPanelUI tc = (TabPanelUI) jsp;
                    tc.updateEntityUI();
                }
            }
//            }
        });



        
    }

    public void addToTabpanelToUI(String tabName, Class cls) {
        addToTabpanelToUI(tabName, cls, null);
    }

    public void addToTabpanelToUI(final String tabName, final Class cls, final Object obj) {

//        SwingWorker swingWorker = new SwingWorker() {
//
//            @Override
//            protected Object doInBackground() throws Exception {
//            this code has bugs becasuse when we add tabs this throws exceptions /
        //    beacase many swingw workers update tabs
        try {
            TabPanelUI tpui = (TabPanelUI) Sessions.getObj(tabName);
            int ix = getjTabbedPane1().indexOfTab(tabName);
            if (tpui == null) {
                tpui = (TabPanelUI) Class.forName(cls.getName()).newInstance();
                getjTabbedPane1().add(tabName, tpui);
                int sx = getjTabbedPane1().indexOfTab(tabName);
                getjTabbedPane1().setSelectedIndex(sx);
                Sessions.addToSession(tabName, tpui);

            } else {
                getjTabbedPane1().setSelectedIndex(ix);
                tpui.setobj(obj);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//                return null;
//            }
//        };
//        swingWorker.execute();

    }

    public void addToTabpanelToUI(TabPanelUI tab, String title, final Object obj) {
        try {
            TabPanelUI tpui = (TabPanelUI) Sessions.getObj(title);
       
            if (tpui == null) {
                tpui = tab;
                getjTabbedPane1().add(title, tpui);
                int sx = getjTabbedPane1().indexOfTab(title);
                Sessions.addToSession(title, tpui);
                getjTabbedPane1().setSelectedIndex(sx);

            } else {
                 int ix = getjTabbedPane1().indexOfTab(title);
                 getjTabbedPane1().setSelectedIndex(ix);
              tpui.setobj(obj);
            }
         
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void addToTabpanelToUI(TabPanelUI tab, String title) {

        addToTabpanelToUI(tab, title, null);
    }

    public void selectTab(String title) {
        int sx = getjTabbedPane1().indexOfTab(title);
        if (sx != -1) {
            getjTabbedPane1().setSelectedIndex(sx);
        }
    }

    public void addToTabpdddanelToUI(String title, Container jp) {

        int ix = getjTabbedPane1().indexOfTab(title);
        if (ix == -1) {
            getjTabbedPane1().add(title, jp);
            int sx = getjTabbedPane1().indexOfTab(title);
            getjTabbedPane1().setSelectedIndex(sx);
        } else {
            getjTabbedPane1().setSelectedIndex(ix);
        }

    }

    public void removeTab() {
        int x = getjTabbedPane1().getSelectedIndex();
        if (x < 0) {
            return;
        }

        String tit = getjTabbedPane1().getTitleAt(x);
        Sessions.remove(tit);
        getjTabbedPane1().remove(x);

    }

    public void selectNextTab(){
        int x=getjTabbedPane1().getSelectedIndex();
        int y=getjTabbedPane1().getTabCount();
        if (x== -1) {
            x=0;
            getjTabbedPane1().setSelectedIndex(x);
        }else{
            if (y>(x+1)) {
                 getjTabbedPane1().setSelectedIndex(++x);
            }
           
        }

    }
    public void selectPreviousTab(){
        int x=getjTabbedPane1().getSelectedIndex();
         int y=getjTabbedPane1().getTabCount();
         if (x== -1) {
            x=0;
            getjTabbedPane1().setSelectedIndex(x);
        }else{
             if (x>0) {
                  getjTabbedPane1().setSelectedIndex(--x);
             }
 
          
        }

    }


    
    public void closeLogin() {
        JDialog dialog = (JDialog) Sessions.getObj("login");        
        dialog.dispose();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cButton1;
    private org.components.controls.CLabel cstattus;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mLogin;
    private javax.swing.JMenuItem mbill;
    private javax.swing.JMenuItem mcashier;
    private javax.swing.JMenuItem mcomptye;
    private javax.swing.JMenuItem mdbstart;
    private javax.swing.JMenuItem mitem;
    private javax.swing.JMenuItem mmenualCash;
    private javax.swing.JMenuItem mparcelcounter;
    private javax.swing.JMenuItem msummery;
    private javax.swing.JMenuItem museradmin;
    private javax.swing.JMenuItem mwaiter;
    private javax.swing.JMenuItem mwaitertips;
    // End of variables declaration//GEN-END:variables

    JTabbedPane jTabbedPane1;
    public javax.swing.JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }
}

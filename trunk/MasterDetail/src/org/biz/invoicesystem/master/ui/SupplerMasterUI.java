
package org.biz.invoicesystem.master.ui;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.biz.app.ui.util.MessageBoxes;
import org.biz.app.ui.util.uiEty;
import org.biz.dao.util.EntityService;
import org.biz.invoicesystem.entity.master.Supplier;
import org.biz.invoicesystem.service.master.SupplierService;
import org.components.windows.TabPanelUI;

/**
 *
 * @author Administrator
 */
public class SupplerMasterUI extends TabPanelUI {

    SupplierService supplierService;
    
    
    public SupplerMasterUI() {
        initComponents();
    }
public void init(){
    try {
        supplierService=new SupplierService();
        
    
    } catch (Exception e) {
    }
}

public Supplier uiToEntity(Supplier s)throws Exception{
    try { 


  s.setId(EntityService.getEntityService().getKey(""));     
  s.setCode(uiEty.tcToStr(tSuppId));
  s.setTitle(uiEty.cmbtostr(tSuppTitle));
  s.setName(uiEty.tcToStr(tSuppName));
  s.setDob(cSuppDob.getDate());
  s.setCurDate(new Date());
  s.setCompany(uiEty.tcToStr(tSuppCompanyName));
  s.setReligion(tSuppReligion.getSelectedItem()==null?"":tSuppReligion.getSelectedItem().toString());
  s.setType(uiEty.cmbtostr(tSuppType));

  s.setAddress1(uiEty.tcToStr(tSuppAddress1));
  s.setAddress2(uiEty.tcToStr(tSuppAddress2));
  s.setCity(uiEty.tcToStr(tSuppCity));
  
  s.setPhone(uiEty.tcToStr(tSuppPhone));
  s.setMobilePhone(uiEty.tcToStr(tSuppMobile));
  
  
  s.setEmail(uiEty.tcToStr(tSuppEmail));
    

        
    } catch (Exception x) {
   
    x.printStackTrace();
    throw x;
    }
    return s;
}

public void entityToUi(Supplier s)throws Exception{
try{
//   s.setId(EntityService.getEntityService().getKey(""));     
uiEty.objToUi(tSuppId, s.getCode());//  s.setCode(uiEty.tcToStr(tSuppId));
uiEty.objToUi(tSuppTitle, s.getTitle());    //  s.setTitle(uiEty.cmbtostr(tSuppTitle));
uiEty.objToUi(tSuppTitle, s.getTitle());//  s.setName(uiEty.tcToStr(tSuppName));
cSuppDob.setDate(s.getDob());//  s.setDob(cSuppDob.getDate());
//  s.setCurDate(new Date());
uiEty.objToUi(tSuppCompanyName, s.getCompany());//  s.setCompany(uiEty.tcToStr(tSuppCompanyName));
uiEty.objToUi(tSuppReligion, s.getReligion());//  s.setReligion(tSuppReligion.getSelectedItem()==null?"":tSuppReligion.getSelectedItem().toString());
uiEty.objToUi(tSuppType, s.getType());//  s.setType(uiEty.cmbtostr(tSuppType));
//
uiEty.objToUi(tSuppAddress1, s.getAddress1());//  s.setAddress1(uiEty.tcToStr(tSuppAddress1));
uiEty.objToUi(tSuppAddress2, s.getAddress2());//  s.setAddress2(uiEty.tcToStr(tSuppAddress2));
uiEty.objToUi(tSuppCity, s.getCity());//  s.setCity(uiEty.tcToStr(tSuppCity));
//  
uiEty.objToUi(tSuppPhone, s.getPhone());//  s.setPhone(uiEty.tcToStr(tSuppPhone));
uiEty.objToUi(tSuppMobile, s.getMobilePhone());//  s.setMobilePhone(uiEty.tcToStr(tSuppMobile));
//  
//  
uiEty.objToUi(tSuppEmail, s.getEmail());//  s.setEmail(uiEty.tcToStr(tSuppEmail));
//    
  
} catch (Exception e) {
    throw e;
   }
}

public void clear(){
    try {
   entityToUi(new Supplier());             
    } catch (Exception e) {
    e.printStackTrace();
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cLabel6 = new org.components.controls.CLabel();
        tSuppType = new org.components.controls.CComboBox();
        cLabel7 = new org.components.controls.CLabel();
        cLabel2 = new org.components.controls.CLabel();
        cLabel8 = new org.components.controls.CLabel();
        cLabel4 = new org.components.controls.CLabel();
        tSuppName = new org.components.controls.CTextField();
        cLabel3 = new org.components.controls.CLabel();
        tSuppTitle = new org.components.controls.CComboBox();
        cSuppDob = new org.components.controls.CDatePicker();
        cLabel5 = new org.components.controls.CLabel();
        cClose = new org.components.controls.CButton();
        cSave = new org.components.controls.CButton();
        cClear = new org.components.controls.CButton();
        cDelete = new org.components.controls.CButton();
        tSuppAddress1 = new org.components.controls.CTextField();
        tSuppAddress2 = new org.components.controls.CTextField();
        tSuppCity = new org.components.controls.CTextField();
        tSuppPhone = new org.components.controls.CTextField();
        cLabel9 = new org.components.controls.CLabel();
        tSuppMobile = new org.components.controls.CTextField();
        cLabel10 = new org.components.controls.CLabel();
        tSuppEmail = new org.components.controls.CTextField();
        cLabel12 = new org.components.controls.CLabel();
        tSuppCompanyName = new org.components.controls.CTextField();
        cLabel13 = new org.components.controls.CLabel();
        tSuppReligion = new org.components.controls.CComboBox();
        tSuppId = new org.components.controls.CTextField();
        cLabel14 = new org.components.controls.CLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cLabel6.setText("Address");
        add(cLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 63, -1));

        tSuppType.setEditable(true);
        add(tSuppType, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 160, -1));

        cLabel7.setText("City");
        add(cLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 31, -1));

        cLabel2.setText("Supplier Code");
        add(cLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 239, -1));

        cLabel8.setText("Phone");
        add(cLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 48, -1));

        cLabel4.setText("Name ");
        add(cLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 119, -1));

        tSuppName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSuppNameActionPerformed(evt);
            }
        });
        add(tSuppName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 275, -1));

        cLabel3.setText("Title");
        add(cLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 40, -1));

        tSuppTitle.setEditable(true);
        add(tSuppTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 63, -1));
        add(cSuppDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));

        cLabel5.setText("DOB");
        add(cLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 110, -1));

        cClose.setText("Close");
        add(cClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, 40));

        cSave.setText("Save");
        cSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSaveActionPerformed(evt);
            }
        });
        add(cSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 40));

        cClear.setText("Clear");
        add(cClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, 40));

        cDelete.setText("Delete");
        cDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDeleteActionPerformed(evt);
            }
        });
        add(cDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, 40));

        tSuppAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSuppAddress1ActionPerformed(evt);
            }
        });
        add(tSuppAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 284, -1));

        tSuppAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSuppAddress2ActionPerformed(evt);
            }
        });
        add(tSuppAddress2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 284, -1));

        tSuppCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSuppCityActionPerformed(evt);
            }
        });
        add(tSuppCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 284, -1));

        tSuppPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSuppPhoneActionPerformed(evt);
            }
        });
        add(tSuppPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 284, -1));

        cLabel9.setText("Mobile");
        add(cLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 48, -1));

        tSuppMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSuppMobileActionPerformed(evt);
            }
        });
        add(tSuppMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 284, -1));

        cLabel10.setText("Email");
        add(cLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 48, -1));

        tSuppEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSuppEmailActionPerformed(evt);
            }
        });
        add(tSuppEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 284, -1));

        cLabel12.setText("Company Name");
        add(cLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 119, -1));

        tSuppCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSuppCompanyNameActionPerformed(evt);
            }
        });
        add(tSuppCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 90, 190, -1));

        cLabel13.setText("Type");
        add(cLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 119, -1));

        tSuppReligion.setEditable(true);
        add(tSuppReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 160, -1));

        tSuppId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSuppIdActionPerformed(evt);
            }
        });
        add(tSuppId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 240, -1));

        cLabel14.setText("Religion");
        add(cLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 119, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tSuppNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSuppNameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tSuppNameActionPerformed

    private void cSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSaveActionPerformed
       try {
            if(uiEty.tcToStr(tSuppId)==null || uiEty.tcToStr(tSuppId).equals("")){
           MessageBoxes.wrnmsg(null,"Please Type Customer Code","Empty Customer Code");                 
                return;
            }       
      //saving customer             
     Supplier s=uiToEntity(new Supplier());//from ui....
     Supplier exist=supplierService.getDao().findSupplierByCode(s.getCode());
    if(exist==null){
    
      supplierService.getDao().save(s);
      
        
    }else{
        
         String[] ObjButtons = { "Yes", "No" };
  int PromptResult = JOptionPane.showOptionDialog(null, "Supplier Exist Do You Want to Update it?", getTabName(), -1, 2, null, ObjButtons, ObjButtons[1]);
 
      if (PromptResult == 0) {
          s.setId(exist.getId());
     supplierService.getDao().update(s);
      
       }
    }         
      //updating customers       
   clear();
 
   tSuppId.requestFocus();
       
        } catch (Exception e) {
        e.printStackTrace();
        MessageBoxes.errormsg(null, e.getMessage(), "Error");
        }
}//GEN-LAST:event_cSaveActionPerformed

    private void tSuppAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSuppAddress1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tSuppAddress1ActionPerformed

    private void tSuppAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSuppAddress2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tSuppAddress2ActionPerformed

    private void tSuppCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSuppCityActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tSuppCityActionPerformed

    private void tSuppPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSuppPhoneActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tSuppPhoneActionPerformed

    private void tSuppMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSuppMobileActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tSuppMobileActionPerformed

    private void tSuppEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSuppEmailActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tSuppEmailActionPerformed

    private void tSuppCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSuppCompanyNameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_tSuppCompanyNameActionPerformed

    private void tSuppIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSuppIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSuppIdActionPerformed

    private void cDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDeleteActionPerformed
       try {
           
      //delete the selected customer...     
      Supplier s=uiToEntity(new Supplier());//from ui....
     Supplier exist=supplierService.getDao().findSupplierByCode(s.getCode());
    if(exist!=null){
    
      supplierService.getDao().delete(exist);
        
    }else{
        
    MessageBoxes.warn(null,"No Supplier Found.", getTabName());
    return;
   
    }      
   clear();
 
   tSuppId.requestFocus();
       
        } catch (Exception e) {
        e.printStackTrace();
        MessageBoxes.errormsg(null, e.getMessage(), "Error");
        }
    }//GEN-LAST:event_cDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.components.controls.CButton cClear;
    private org.components.controls.CButton cClose;
    private org.components.controls.CButton cDelete;
    private org.components.controls.CLabel cLabel10;
    private org.components.controls.CLabel cLabel12;
    private org.components.controls.CLabel cLabel13;
    private org.components.controls.CLabel cLabel14;
    private org.components.controls.CLabel cLabel2;
    private org.components.controls.CLabel cLabel3;
    private org.components.controls.CLabel cLabel4;
    private org.components.controls.CLabel cLabel5;
    private org.components.controls.CLabel cLabel6;
    private org.components.controls.CLabel cLabel7;
    private org.components.controls.CLabel cLabel8;
    private org.components.controls.CLabel cLabel9;
    private org.components.controls.CButton cSave;
    private org.components.controls.CDatePicker cSuppDob;
    private org.components.controls.CTextField tSuppAddress1;
    private org.components.controls.CTextField tSuppAddress2;
    private org.components.controls.CTextField tSuppCity;
    private org.components.controls.CTextField tSuppCompanyName;
    private org.components.controls.CTextField tSuppEmail;
    private org.components.controls.CTextField tSuppId;
    private org.components.controls.CTextField tSuppMobile;
    private org.components.controls.CTextField tSuppName;
    private org.components.controls.CTextField tSuppPhone;
    private org.components.controls.CComboBox tSuppReligion;
    private org.components.controls.CComboBox tSuppTitle;
    private org.components.controls.CComboBox tSuppType;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabName() {
       return "Suppler Master";
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }
}

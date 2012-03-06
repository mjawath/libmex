/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.invoicesystem.entity.transactions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.biz.invoicesystem.entity.BEO;
import org.biz.invoicesystem.entity.master.Customer;
import org.biz.invoicesystem.entity.master.Staff;

/**
 *
 * @author mjawath
 */
@Entity
public class SalesInvoice extends BEO implements Serializable {

    @Id
    private String id;//timestamp + random string + domain level generated string 
    private static final long serialVersionUID = 1L;
    @ManyToOne
    Customer customer;
    @ManyToOne
    Staff staff;
    @JoinColumn(name = "sales_invoice_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<SalesInvoiceLineItem> lineItems;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date docdate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date saveddate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date editeddate;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setLineItems(List<SalesInvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Date getDocdate() {
        return docdate;
    }

    public void setDocdate(Date docdate) {
        this.docdate = docdate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<SalesInvoiceLineItem> getLineItems() {
        return lineItems;
    }

    public String getId() {
        return id;
    }

    public Date getEditeddate() {
        return editeddate;
    }

    public void setEditeddate(Date editeddate) {
        this.editeddate = editeddate;
    }

    public Date getSaveddate() {
        return saveddate;
    }

    public void setSaveddate(Date saveddate) {
        this.saveddate = saveddate;
    }

    public void setId(String id) {
        this.id = id;
    }

    static public SalesInvoice createNewInvoice() {
        SalesInvoice sl = new SalesInvoice();
        sl.setLineItems(new ArrayList<SalesInvoiceLineItem>());
        return sl;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.invoicesystem.entity.transactions;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import org.biz.invoicesystem.entity.master.Customer;

/**
 *
 * @author mjawath
 */
@Entity
public class SalesInvoice implements Serializable   {
    @Id
    private String id;

    private static final long serialVersionUID = 1L;
    @ManyToOne
    Customer customer;
    @JoinColumn(name = "sales_invoice_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<SalesInvoiceLineItem> lineItems;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date editeddate;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date docdate;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date saveddate;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setLineItems(List<SalesInvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<SalesInvoiceLineItem> getLineItems() {
        return lineItems;
    }

    public void setSaveddate(Date saveddate) {
        this.saveddate = saveddate;
    }

    public Date getSaveddate() {
        return saveddate;
    }

    public void setEditeddate(Date editeddate) {
        this.editeddate = editeddate;
    }

    public Date getEditeddate() {
        return editeddate;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

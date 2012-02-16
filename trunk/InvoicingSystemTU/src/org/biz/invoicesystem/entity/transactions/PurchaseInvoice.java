/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.invoicesystem.entity.transactions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.biz.invoicesystem.entity.master.Supplier;

/**
 *
 * @author mjawath
 */
@Entity
public class PurchaseInvoice implements Serializable {

    @Id
    private String id;
    private static final long serialVersionUID = 1L;
    @ManyToOne
    Supplier supplier;
    @JoinColumn(name = "purchase_invoice_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<PurchaseInvoiceLineItem> lineItems;

    public List<PurchaseInvoiceLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<PurchaseInvoiceLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    static public PurchaseInvoice createNewInvoice() {
        PurchaseInvoice sl = new PurchaseInvoice();
        sl.setLineItems(new ArrayList<PurchaseInvoiceLineItem>());
        return sl;
    }
}

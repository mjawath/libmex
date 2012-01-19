/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.invoicesystem.entity.transactions;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.biz.invoicesystem.entity.master.Item;

/**
 *
 * @author mjawath
 */
@Entity
public class SalesInvoiceLineItem implements Serializable  {
    @Id
    private String id;
    private String description;
    @OneToOne
    private Item item;
    private Double qty;
    private String unit;
    private Double price;
    private Double lineAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    

    public void setLineAmount(Double lineAmount) {
        this.lineAmount = lineAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

    public Double getPrice() {
        return price;
    }

    public Double getLineAmount() {
        return lineAmount;
    }

    public String getDescription() {
        return description;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    
    
}

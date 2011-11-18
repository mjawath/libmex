 
package org.biz.invoicesystem.entity.master;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author mjawath
 */
@Entity
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String code;
    private String name;
    @OneToOne
    private Product product;
    @OneToOne
    private ItemVariation variation;
    private String description;
    private String inventoryType;
    @ManyToOne(cascade=CascadeType.ALL)
    private UOM unitOne;
    @ManyToOne(cascade=CascadeType.ALL)
    private UOM unitTwo;
    //item has many mariation
    //variation has name value --colur = red/colur = yellow , size = 15 ,size = 20 
    
    private String itemID;
    private String warehouse;   
    private String category;
    private String extraCategory;
    private String type;
    private String sections;
    private String vendorID;
    private Double minimumSalesPrice;
    private Double itemsDicount;
    private Double difference;
    private Double minimumStock;
    private String location;
    private Boolean manufacturingItem;
    private String itemExtraInfo;
    private String pic1;
    private String pic2;
    private String pic3;
    private String measureUnit1;
    private String measureUnit2;
    private Double salesPrice2;
    private Double landCost;
    private Double avgCost;
    private Double cost1;
    private Double salesPrice1;
    private Double reOrder;
    private Double carton;
    private Boolean nonStockItems;
    private Boolean active;
    private Boolean itemcol;
    private Boolean trackingItem;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date crtDate;
    private Boolean isSentToMaster;
    private Boolean isDeleted;
    private String loggedinStaff;
    private List itemtexCollection;
    private List extrasalespriceCollection;


    public static Item find(String code, List<Item> lst) {


        Comparator<Item> com = new Comparator<Item>() {

            public int compare(Item o1, Item o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };

        Collections.sort(lst, com);

        Item s = new Item();
        s.setId(code);
        int num = Collections.binarySearch(lst, s, com);

        if (num > -1) {
            return lst.get(num);
        } else {
            return null;
        }
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public void setUnitOne(UOM unitOne) {
        this.unitOne = unitOne;
    }

    public void setUnitTwo(UOM unitTwo) {
        this.unitTwo = unitTwo;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public UOM getUnitOne() {
        return unitOne;
    }

    public UOM getUnitTwo() {
        return unitTwo;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

  

}

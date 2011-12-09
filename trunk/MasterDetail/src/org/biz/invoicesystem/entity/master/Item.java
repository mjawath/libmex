 
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
 //   private String name;
//    @OneToOne
//    private Product product;
    @OneToOne
    private ItemVariation variation;
    private String description;
   // private String inventoryType;

    private String category;
    
    private String unitOne;
    
    private int different; 
            
    private String unitTwo;
    //item has many mariation
    //variation has name value --colur = red/colur = yellow , size = 15 ,size = 20 
    
  //  private String itemID;
  //  private String warehouse;   
 //   private String extraCategory;
    private String supplierId;
    private Double cost;
    private Double salesPrice;
    private Double unit2SalesPrice;
    
    private String type;
 //   private String sections;
    private Double minSalesPrice;
    private Double dicount;
 //   private Double difference;
    private Double minStock;
    private String location;
    private Boolean manufactItem;
//    private String itemExtraInfo;
    private String pic1;
//    private String pic2;
//    private String pic3;
   
//    private Double salesPrice2;
    private Double landCost;
 //   private Double avgCost;
    private Double wholesalePrice;
    private Double commission;
    private Double reOrder;
    private Double carton;
    private Boolean nonStockItems;
    private Boolean inactive;
    private Boolean itemcol;
    private Boolean trackingItem;
    private Boolean trackSerial;
    private Boolean trackExpiry;

//      @OneToMany(cascade={javax.persistence.CascadeType.ALL, javax.persistence.CascadeType.REMOVE}, mappedBy="item")
//    private List<ItemTex> itemtexCollection;
//  
//      @OneToMany(cascade={javax.persistence.CascadeType.ALL, javax.persistence.CascadeType.REMOVE}, mappedBy="item")
//   private List<ExtraSalesPrice> extrasalespriceCollection;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
            
     @Temporal(javax.persistence.TemporalType.DATE)
    Date crDate;
//    private Boolean isSentToMaster;
    private Boolean isDeleted;
//    private String loggedinStaff;
//    private List itemtexCollection;
    private List extrasalespriceCollection;


    
    
    public static Item find(String code, List<Item> lst) {


        Comparator<Item> com = new Comparator<Item>() {

            public int compare(Item o1, Item o2) {
                return o1.getCode().compareTo(o2.getCode());
            }
        };

        Collections.sort(lst, com);

        Item s = new Item();
        s.setCode(code);
        int num = Collections.binarySearch(lst, s, com);

        if (num > -1) {
            return lst.get(num);
        } else {
            return null;
        }
    }
    
   

    
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    
   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//   
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }

    public Double getCarton() {
        return carton;
    }

    public void setCarton(Double carton) {
        this.carton = carton;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getCrDate() {
        return crDate;
    }

    public void setCrDate(Date crDate) {
        this.crDate = crDate;
    }

    public Double getDicount() {
        return dicount;
    }

    public void setDicount(Double dicount) {
        this.dicount = dicount;
    }

    public List getExtrasalespriceCollection() {
        return extrasalespriceCollection;
    }

    public void setExtrasalespriceCollection(List extrasalespriceCollection) {
        this.extrasalespriceCollection = extrasalespriceCollection;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getItemcol() {
        return itemcol;
    }

    public void setItemcol(Boolean itemcol) {
        this.itemcol = itemcol;
    }

   

    public Double getLandCost() {
        return landCost;
    }

    public void setLandCost(Double landCost) {
        this.landCost = landCost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getManufactItem() {
        return manufactItem;
    }

    public void setManufactItem(Boolean manufactItem) {
        this.manufactItem = manufactItem;
    }

    public Double getMinSalesPrice() {
        return minSalesPrice;
    }

    public void setMinSalesPrice(Double minSalesPrice) {
        this.minSalesPrice = minSalesPrice;
    }

    public Double getMinStock() {
        return minStock;
    }

    public void setMinStock(Double minStock) {
        this.minStock = minStock;
    }

    public Boolean getNonStockItems() {
        return nonStockItems;
    }

    public void setNonStockItems(Boolean nonStockItems) {
        this.nonStockItems = nonStockItems;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public Double getReOrder() {
        return reOrder;
    }

    public void setReOrder(Double reOrder) {
        this.reOrder = reOrder;
    }

   

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Boolean getTrackingItem() {
        return trackingItem;
    }

    public void setTrackingItem(Boolean trackingItem) {
        this.trackingItem = trackingItem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnitOne() {
        return unitOne;
    }

    public void setUnitOne(String unitOne) {
        this.unitOne = unitOne;
    }

    public String getUnitTwo() {
        return unitTwo;
    }

    public void setUnitTwo(String unitTwo) {
        this.unitTwo = unitTwo;
    }

     

    public Double getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(Double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    /**
     * @return the different
     */
    public int getDifferent() {
        return different;
    }

    /**
     * @param different the different to set
     */
    public void setDifferent(int different) {
        this.different = different;
    }
 
    
}

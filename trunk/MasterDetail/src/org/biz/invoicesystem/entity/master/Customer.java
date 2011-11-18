/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.entity.master;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author mjawath
 */
@Entity
public class Customer implements Serializable {
  
    @Id 
    private String id;
    private String name;
    private String code;
      private String customerID;
    private String warehouse;
    private String customerName;
    private String companyName;
    private String designation;
    private String type;
    private Double creditLimit;
    private String salesRep;
    private String address;
    private String city;
    private String area;
    private String district;
    private String nicno;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date   crtDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date   uptDate;
    Boolean isSentToMaster;
    private Boolean isDeleted;
    private String loggedinStaff;
    private String religion;
    private String groupOfCustomer;
    private String signatureImage;
    private String landPhone;
    private String handPhone;
    private String email;
    private String picLocation;
    private String loyaltyCardNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupOfCustomer() {
        return groupOfCustomer;
    }

    public void setGroupOfCustomer(String groupOfCustomer) {
        this.groupOfCustomer = groupOfCustomer;
    }

    public String getHandPhone() {
        return handPhone;
    }

    public void setHandPhone(String handPhone) {
        this.handPhone = handPhone;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Boolean getIsSentToMaster() {
        return isSentToMaster;
    }

    public void setIsSentToMaster(Boolean isSentToMaster) {
        this.isSentToMaster = isSentToMaster;
    }

    public String getLandPhone() {
        return landPhone;
    }

    public void setLandPhone(String landPhone) {
        this.landPhone = landPhone;
    }

    public String getLoggedinStaff() {
        return loggedinStaff;
    }

    public void setLoggedinStaff(String loggedinStaff) {
        this.loggedinStaff = loggedinStaff;
    }

    public String getLoyaltyCardNo() {
        return loyaltyCardNo;
    }

    public void setLoyaltyCardNo(String loyaltyCardNo) {
        this.loyaltyCardNo = loyaltyCardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNicno() {
        return nicno;
    }

    public void setNicno(String nicno) {
        this.nicno = nicno;
    }

    public String getPicLocation() {
        return picLocation;
    }

    public void setPicLocation(String picLocation) {
        this.picLocation = picLocation;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }

    public String getSignatureImage() {
        return signatureImage;
    }

    public void setSignatureImage(String signatureImage) {
        this.signatureImage = signatureImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getUptDate() {
        return uptDate;
    }

    public void setUptDate(Date uptDate) {
        this.uptDate = uptDate;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
    
    public static Customer find(String code, List<Customer> lst) {


        Comparator<Customer> com = new Comparator<Customer>() {

            public int compare(Customer o1, Customer o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };

        Collections.sort(lst, com);

        Customer s = new Customer();
        s.setId(code);
        int num = Collections.binarySearch(lst, s, com);

        if (num > -1) {
            return lst.get(num);
        } else {
            return null;
        }
    }
}

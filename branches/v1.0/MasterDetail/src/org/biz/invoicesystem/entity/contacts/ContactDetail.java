/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.invoicesystem.entity.contacts;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.PrivateOwned;

/**
 *
 * @author mjawath
 */
@Entity
//@DiscriminatorColumn
public class ContactDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade=CascadeType.ALL)
    List<Address> addresses;

    @OneToMany(cascade=CascadeType.ALL)
    @PrivateOwned  
    List<Phone> phones;
    @OneToMany(cascade=CascadeType.ALL)
    List<Fax> faxs;


    @OneToMany(cascade=CascadeType.ALL)
    List<Website> websites;    @OneToMany(cascade=CascadeType.ALL)
    List<Email> emails;


    @OneToMany(cascade=CascadeType.ALL)
    List<SocialWebsite> socialWebsites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public List<Fax> getFaxs() {
        return faxs;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public List<SocialWebsite> getSocialWebsites() {
        return socialWebsites;
    }

    public List<Website> getWebsites() {
        return websites;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void setFaxs(List<Fax> faxs) {
        this.faxs = faxs;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void setWebsites(List<Website> websites) {
        this.websites = websites;
    }

    public void setSocialWebsites(List<SocialWebsite> socialWebsites) {
        this.socialWebsites = socialWebsites;
    }

}

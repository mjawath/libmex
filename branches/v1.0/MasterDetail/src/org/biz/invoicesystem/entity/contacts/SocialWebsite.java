/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.entity.contacts;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mjawath
 */
@Entity
public class SocialWebsite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String webSite;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    
    
    public String getWebSite() {
        return webSite;
    }

    public SocialWebsite() {
    }

    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.dao.contacts;

import org.biz.dao.service.GenericDAO;
import org.biz.invoicesystem.entity.contacts.Phone;

/**
 *
 * @author mjawath
 */
public class PhoneDAO extends GenericDAO<Phone>{

    
    public PhoneDAO() {
    setCls(Phone.class);
    }


}

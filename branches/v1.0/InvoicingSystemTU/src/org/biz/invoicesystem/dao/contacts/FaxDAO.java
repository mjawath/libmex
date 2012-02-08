/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.dao.contacts;

import org.biz.dao.service.GenericDAO;
import org.biz.invoicesystem.entity.contacts.Fax;

/**
 *
 * @author mjawath
 */
public class FaxDAO extends GenericDAO<Fax>{

    
    public FaxDAO() {
    setCls(Fax.class);
    }


}

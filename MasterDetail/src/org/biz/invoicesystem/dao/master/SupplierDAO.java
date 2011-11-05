/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.dao.master;

import org.biz.dao.service.GenericDAO;
import org.biz.invoicesystem.entity.master.Supplier;

/**
 *
 * @author mjawath
 */
public class SupplierDAO extends GenericDAO<Supplier>{

    
    public SupplierDAO() {
    setCls(Supplier.class);
    }


}

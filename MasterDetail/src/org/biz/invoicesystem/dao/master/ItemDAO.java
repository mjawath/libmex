/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.dao.master;

import org.biz.dao.service.GenericDAO;
import org.biz.invoicesystem.entity.master.Item;

/**
 *
 * @author mjawath
 */
public class ItemDAO extends GenericDAO<Item>{

    
    public ItemDAO() {
    setCls(Item.class);
    }


}

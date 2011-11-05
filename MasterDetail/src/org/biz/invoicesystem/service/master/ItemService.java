/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.service.master;

import org.biz.dao.service.Service;
import org.biz.invoicesystem.dao.master.ItemDAO;

/**
 *
 * @author mjawath
 */
public class ItemService extends Service{
    ItemDAO dao;

    public ItemService() {
    dao = new ItemDAO();
    }

    public ItemDAO getDao() {
        return dao;
    }

}

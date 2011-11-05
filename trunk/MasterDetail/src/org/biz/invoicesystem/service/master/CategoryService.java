/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.service.master;

import org.biz.dao.service.Service;
import org.biz.invoicesystem.dao.master.CategoryDAO;

/**
 *
 * @author mjawath
 */
public class CategoryService extends Service{
    CategoryDAO dao;

    public CategoryService() {
    dao = new CategoryDAO();
    }

    public CategoryDAO getDao() {
        return dao;
    }

}

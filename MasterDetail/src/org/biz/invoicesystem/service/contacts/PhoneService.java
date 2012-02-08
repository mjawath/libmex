/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.service.contacts;

import org.biz.dao.service.Service;
import org.biz.invoicesystem.dao.contacts.PhoneDAO;

/**
 *
 * @author mjawath
 */
public class PhoneService extends Service {
    PhoneDAO dao;

    public PhoneService() {
    dao = new PhoneDAO();
    }

    @Override
    public PhoneDAO getDao() {
        return dao;
    }

}

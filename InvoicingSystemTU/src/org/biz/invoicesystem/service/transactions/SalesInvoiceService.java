/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.invoicesystem.service.transactions;

import org.biz.dao.service.Service;
import org.biz.invoicesystem.dao.transactions.SalesInvoiceDAO;

/**
 *
 * @author mjawath
 */
public class SalesInvoiceService extends Service {
    SalesInvoiceDAO dao;

    public SalesInvoiceService() {
    dao = new SalesInvoiceDAO();
    }

    public SalesInvoiceDAO getDao() {
        return dao;
    }

}

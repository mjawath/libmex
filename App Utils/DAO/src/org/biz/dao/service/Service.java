/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.biz.dao.service;

import org.biz.dao.util.EntityService;

/**
 *
 * @author mjawath
 */
public class Service {
    EntityService es;

    public Service() {
    es =  EntityService.getEntityService();
    }

    

    public GenericDAO getDao() {
        return new GenericDAO();
    }
}

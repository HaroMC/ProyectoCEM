/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cem.intecambios.controlador;

import cem.intecambios.entidades.PostulacionesCel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kevin
 */
@Stateless
public class PostulacionesCelFacade extends AbstractFacade<PostulacionesCel> {

    @PersistenceContext(unitName = "cem.intecambios_ProyectoCEM_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostulacionesCelFacade() {
        super(PostulacionesCel.class);
    }
    
}

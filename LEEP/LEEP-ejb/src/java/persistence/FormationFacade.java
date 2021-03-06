/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import entity.Enseignement;
import entity.Formation;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fayize Kaimou
 */
@Stateless
public class FormationFacade extends AbstractFacade<Formation> implements FormationFacadeLocal {
    @EJB
    private FormationEnseignementFacadeLocal formationEnseignementFacade;
    @EJB
    private FormationFacadeLocal formationFacade;
    @EJB
    private EnseignementFacadeLocal enseignementFacade;
    @PersistenceContext(unitName = "LEEP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormationFacade() {
        super(Formation.class);
    }
    
    public Formation create(String nom){
        Formation f = new Formation();
        f.setNom(nom);
        create(f);
        return f;
    }
    public void addEnseignement(Formation formation, Enseignement enseignement){
        //formationEnseignementFacade.create(formation, enseignement);
        formation.getEnseignementCollection().add(enseignement);
        enseignement.getFormationCollection().add(formation);
        formationFacade.edit(formation); 
        enseignementFacade.edit(enseignement);
    }
    
}

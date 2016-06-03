package org.mdacc.rists.bdi.fm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.mdacc.rists.bdi.fm.models.SpecimenTb;

public class SpecimenDao {
	EntityManager entityManager;

	public SpecimenDao() {
		super();
	}

	public SpecimenDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public boolean persistSpecimen(SpecimenTb specimen) {
		EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(specimen);
            transaction.commit();
            return true;
        } catch (Exception e) {
        	String fmId = specimen.getFmReportTbs().get(0).getFrFmId();
        	System.err.println("Loading " + fmId + " failed");
        	e.printStackTrace();
            transaction.rollback();
            return false;
        }
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	

}

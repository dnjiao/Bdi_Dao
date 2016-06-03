package org.mdacc.rists.bdi.fm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.mdacc.rists.bdi.fm.models.FileLoadTb;

public class FileLoadDao {

	EntityManager entityManager;

	public FileLoadDao() {
		super();
	}

	public FileLoadDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public boolean persistFileLoad(FileLoadTb fileLoad) {
		EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(fileLoad);
            transaction.commit();
            return true;
        } catch (Exception e) {
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

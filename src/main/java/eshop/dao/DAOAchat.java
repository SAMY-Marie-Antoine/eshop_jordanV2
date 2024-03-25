package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eshop.context.Singleton;
import eshop.model.Achat;


public class DAOAchat implements IDAO<Achat, Integer>{

	@Override
	public Achat findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Achat achat = em.find(Achat.class, id);
		em.close();
		return achat;
	}

	@Override
	public List<Achat> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Achat> achats = em.createQuery("from Achat").getResultList();
		em.close();
		return achats;
	}

	@Override
	public Achat save(Achat achat) {
		EntityManager em = null;
		EntityTransaction tx  = null;

		try 
		{
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			achat = em.merge(achat);
			tx.commit();

		}catch(Exception e) 
		{
			if(tx!=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally {
			if(em!=null) 
			{
				em.close();
			}
		}
		return achat;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Achat achat = em.find(Achat.class, id);
		em.getTransaction().begin();
		em.remove(achat);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Achat achat) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		achat = em.merge(achat);
		em.getTransaction().begin();
		em.remove(achat);
		em.getTransaction().commit();
		em.close();
		
	}

	

	

}

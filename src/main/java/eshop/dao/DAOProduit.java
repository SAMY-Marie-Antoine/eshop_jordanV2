package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eshop.context.Singleton;
import eshop.model.Produit;

public class DAOProduit implements IDAOProduit{

	@Override
	public Produit findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Produit Produit = em.find(Produit.class, id);
		em.close();
		return Produit;
	}

	@Override
	public List<Produit> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Produit> Produits = em.createQuery("from Produit").getResultList();
		em.close();
		return Produits;
	}

	@Override
	public Produit save(Produit Produit) {
		EntityManager em = null;
		EntityTransaction tx  = null;

		try 
		{
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Produit = em.merge(Produit);
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
		return Produit;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Produit Produit = em.find(Produit.class, id);
		em.getTransaction().begin();
		em.remove(Produit);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Produit Produit) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Produit = em.merge(Produit);
		em.getTransaction().begin();
		em.remove(Produit);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Produit> findByLib(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit findByIdWithVentes(Integer idProduit) {
		// TODO Auto-generated method stub
		return null;
	}


}

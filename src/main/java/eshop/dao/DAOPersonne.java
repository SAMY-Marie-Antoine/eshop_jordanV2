package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import eshop.context.Singleton;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;


public class DAOPersonne implements IDAOPersonne{

	@Override
	public Personne findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Personne Personne = em.find(Personne.class, id);
		em.close();
		return Personne;
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Personne> Personnes = em.createQuery("from Personne").getResultList();
		em.close();
		return Personnes;
	}

	@Override
	public Personne save(Personne Personne) {
		EntityManager em = null;
		EntityTransaction tx  = null;

		try 
		{
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			Personne = em.merge(Personne);
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
		return Personne;
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Personne Personne = em.find(Personne.class, id);
		em.getTransaction().begin();
		em.remove(Personne);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void delete(Personne Personne) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Personne = em.merge(Personne);
		em.getTransaction().begin();
		em.remove(Personne);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Fournisseur> findAllFournisseur() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Fournisseur> fournisseurs = em.createQuery("from Fournisseur").getResultList();
		
		/*for(Fournisseur f : fournisseurs) {
			System.out.println( f.getNom()+ " " + f.getPrenom() +" " + f.getAdresse() + " " + .getClass().getSimpleName());
		}*/
		em.close();
		return fournisseurs;
	}

	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findByIdWithAchats(Integer idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur findByIdWithStock(Integer idFournisseur) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}

package eshop.test;

import java.util.List;

import eshop.context.Singleton;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Adresse;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class TestDAO {

	public static void main(String[] args) {
		
		IDAOPersonne daoPersonne = Singleton.getInstance().getDaoPersonne();
		IDAOProduit daoProduit = Singleton.getInstance().getDaoProduit();
		
		
		
		Adresse adresse = new Adresse("2 bis","rue de paris","Paris","75001");
		
		Fournisseur fournisseur = new Fournisseur("Doe","John",adresse,"societe");
		
		Produit produit = new Produit("Cahier",50.50,fournisseur);
		
		daoProduit.save(produit);
		
		fournisseur = (Fournisseur) daoPersonne.save(fournisseur);
		
		
		
		for(Fournisseur f : daoPersonne.findAllFournisseur()) 
		{
			System.out.println(f);
		}
		
		
		daoPersonne.delete(fournisseur);
		

		for(Fournisseur f : daoPersonne.findAllFournisseur()) 
		{
			System.out.println(f);
		}
		
		
		
		
		String recherche = "Cahier";
		
		System.out.println("Liste des produit dont le nom est : "+recherche);
		List<Produit> resultat = daoProduit.findByLib(recherche);
		if(resultat.isEmpty()) {System.out.println("Aucun produit ne porte ce nom !");}
		for(Produit p : resultat) 
		{
			System.out.println(p);
		}
		
		
		
	}

}

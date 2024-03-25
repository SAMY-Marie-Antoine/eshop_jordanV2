package eshop.dao;

import java.util.List;

import eshop.model.Fournisseur;
import eshop.model.Produit;

public interface IDAOProduit extends IDAO<Produit,Integer>{
	
	public List<Produit> findByLib(String libelle);
	public Produit findByIdWithVentes(Integer idProduit);
	

}

package eshop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne {

	@Column(name="company",length = 40)
	private String societe;

	
	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> stock;
	
	public Fournisseur() {}
	
	public Fournisseur(String nom, String prenom, Adresse adresse, String societe) {
		super(nom, prenom, adresse);
		this.societe = societe;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}
	

	public List<Produit> getStock() {
		return stock;
	}

	public void setStock(List<Produit> stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", societe="
				+ societe + "]";
	}
	
	
	
}

package eshop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="achat")
public class Achat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_achat",nullable = false)
	private LocalDate dateAchat;
	
	private int quantite;
	
	@Column(columnDefinition = "DOUBLE(6,2)", nullable = false)
	private double prix;
	
	
	@ManyToOne
	@JoinColumn(name="client",nullable = false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="produit",nullable = false)
	private Produit produit;

	public Achat() {}
	 
	public Achat( Client client, Produit produit,int quantite) {
		this.quantite = quantite;
		this.client = client;
		this.produit = produit;
		this.dateAchat=LocalDate.now();
		this.prix = produit.getPrix();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "Achat [id=" + id + ", dateAchat=" + dateAchat + ", quantite=" + quantite + ", prix=" + prix
				+ ", client=" + client + ", produit=" + produit + "]";
	}
	
	
	
	
	
	
	
	
	
	
}

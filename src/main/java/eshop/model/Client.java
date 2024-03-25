package eshop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {

	@Column(columnDefinition = "int(2)")
	private int age;
	@Column(name="date_naissance")
	private LocalDate dateNaissance;
	
	@OneToMany(mappedBy = "client" )
	//@JoinTable(name="achats",joinColumns = @JoinColumn(name="acheteur"),inverseJoinColumns = @JoinColumn(name="achat"))
	private List<Achat> achats = new ArrayList();
	
	public Client() {}

	public Client(String nom, String prenom, Adresse adresse, int age, LocalDate dateNaissance) {
		super(nom, prenom, adresse);
		this.age = age;
		this.dateNaissance = dateNaissance;
	}



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
	
	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", age=" + age
				+ ", dateNaissance=" + dateNaissance + "]";
	}
	
	
	
}

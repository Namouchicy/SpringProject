package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String motDePasse;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String adresse; //prop
	private Double budget; //colo
	private String prefenrences; //colo
	public Utilisateur(String nom, String prenom, String email, String telephone, String motDePasse, Role role,
			String adresse, Double budget, String prefenrences) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.motDePasse = motDePasse;
		this.role = role;
		this.adresse = adresse;
		this.budget = budget;
		this.prefenrences = prefenrences;
	}
	
	
}

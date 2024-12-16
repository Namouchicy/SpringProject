package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferencesColocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double budget;
	private String typeLogement;
	private String localisation;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	public PreferencesColocation(Double budget, String typeLogement, String localisation) {
		super();
		this.budget = budget;
		this.typeLogement = typeLogement;
		this.localisation = localisation;
	}

	public PreferencesColocation(Double budget, String typeLogement, String localisation, Utilisateur utilisateur) {
		super();
		this.budget = budget;
		this.typeLogement = typeLogement;
		this.localisation = localisation;
		this.utilisateur = utilisateur;
	}
	
	
	
}

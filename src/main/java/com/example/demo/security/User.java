package com.example.demo.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.PreferencesColocation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Utilisateur")
public class User implements UserDetails {

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

    private String adresse; // prop
    private static Double budget; // colo
    private String preferences; // colo

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PreferencesColocation> preferencesColocation;

    // Constructeur personnalisé
    public User(String nom, String prenom, String email, String telephone, String motDePasse, Role role,
                       String adresse, Double budget, String preferences) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.role = role;
        this.adresse = adresse;
        this.budget = budget;
        this.preferences = preferences;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retourne la liste des rôles ou autorités associées à l'utilisateur
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        // Retourne le mot de passe de l'utilisateur
        return motDePasse;
    }

    @Override
    public String getUsername() {
        // Retourne l'identifiant de l'utilisateur (dans ce cas, l'email)
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Retourne true si le compte de l'utilisateur n'a pas expiré
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Retourne true si le compte de l'utilisateur n'est pas verrouillé
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Retourne true si les informations d'identification de l'utilisateur n'ont pas expiré
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Retourne true si l'utilisateur est activé
        return true;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public List<PreferencesColocation> getPreferencesColocation() {
		return preferencesColocation;
	}

	public void setPreferencesColocation(List<PreferencesColocation> preferencesColocation) {
		this.preferencesColocation = preferencesColocation;
	}
	
    
    
    
	 public static class Builder {
	        private String nom;
	        private String prenom;
	        private String email;
	        private String motDePasse;
	        private Role role;

	        public Builder nom(String nom) {
	            this.nom = nom;
	            return this;
	        }

	        public Builder prenom(String prenom) {
	            this.prenom = prenom;
	            return this;
	        }

	        public Builder email(String email) {
	            this.email = email;
	            return this;
	        }

	        public Builder password(String motDePasse) {
	            this.motDePasse = motDePasse;
	            return this;
	        }

	        public Builder role(Role role) {
	            this.role = role;
	            return this;
	        }

	        public User build() {
	            User user = new User(email, email, email, email, email, role, email, budget, email);
	            user.nom = this.nom;
	            user.prenom = this.prenom;
	            user.email = this.email;
	            user.motDePasse = this.motDePasse;
	            user.role = this.role;
	            return user;
	        }
	    }

	    public static Builder builder() {
	        return new Builder();
	    }
	}

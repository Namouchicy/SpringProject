package com.example.demo.service;

import com.example.demo.entity.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Create a new utilisateur
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Get all utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Get utilisateur by ID
    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    // Update utilisateur
    public Optional<Utilisateur> updateUtilisateur(Long id, Utilisateur utilisateurDetails) {
        return utilisateurRepository.findById(id).map(utilisateur -> {
            utilisateur.setNom(utilisateurDetails.getNom());
            utilisateur.setPrenom(utilisateurDetails.getPrenom());
            utilisateur.setEmail(utilisateurDetails.getEmail());
            utilisateur.setTelephone(utilisateurDetails.getTelephone());
            utilisateur.setMotDePasse(utilisateurDetails.getMotDePasse());
            utilisateur.setRole(utilisateurDetails.getRole());
            utilisateur.setAdresse(utilisateurDetails.getAdresse());
            utilisateur.setBudget(utilisateurDetails.getBudget());
            utilisateur.setPrefenrences(utilisateurDetails.getPrefenrences());
            return utilisateurRepository.save(utilisateur);
        });
    }

    // Delete utilisateur
    public boolean deleteUtilisateur(Long id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

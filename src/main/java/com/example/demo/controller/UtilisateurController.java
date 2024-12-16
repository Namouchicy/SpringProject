
//CONTROLLER
package com.example.demo.controller;

import com.example.demo.entity.Utilisateur;
import com.example.demo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

@Autowired
private UtilisateurService utilisateurService;

// Create a new utilisateur
@PostMapping
public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
   Utilisateur createdUtilisateur = utilisateurService.createUtilisateur(utilisateur);
   return ResponseEntity.ok(createdUtilisateur);
}

// Get all utilisateurs
@GetMapping
public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
   List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
   return ResponseEntity.ok(utilisateurs);
}

// Get utilisateur by ID
@GetMapping("/{id}")
public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
   Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateurById(id);
   return utilisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}

// Update utilisateur
@PutMapping("/{id}")
public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) {
   Optional<Utilisateur> updatedUtilisateur = utilisateurService.updateUtilisateur(id, utilisateurDetails);
   return updatedUtilisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}

// Delete utilisateur
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
   boolean isDeleted = utilisateurService.deleteUtilisateur(id);
   if (isDeleted) {
       return ResponseEntity.noContent().build();
   } else {
       return ResponseEntity.notFound().build();
   }
}
}

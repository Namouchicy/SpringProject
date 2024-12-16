package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UtilisateurRepository extends JpaRepository <Utilisateur, Long>{

}

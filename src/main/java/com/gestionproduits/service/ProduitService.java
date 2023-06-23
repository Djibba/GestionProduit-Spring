package com.gestionproduits.service;

import com.gestionproduits.dto.ProduitDTO;
import com.gestionproduits.entities.Categorie;
import com.gestionproduits.entities.Produit;

import java.util.List;

public interface ProduitService {
	
	ProduitDTO saveProduit(ProduitDTO p);
	ProduitDTO getProduit(Long id);
	List<ProduitDTO> getAllProduits();
	ProduitDTO updateProduit(ProduitDTO p);
	void deleteProduit(Produit p);


	void deleteProduitById(Long id);
	List<Produit> findByNomProduit(String nom);
	List<Produit> findByNomProduitContains(String nom);
	List<Produit> findByNomEtPrix(String nom, Double prix);
	List<Produit> findByCategorie(Categorie categorie);
	List<Produit> findByCategorieIdCat(Long id);
	List<Produit> findByOrderByNomProduitAsc();
	List<Produit> trierProduitsNomsPrix();

	ProduitDTO convertEntityToDto(Produit produit);

	Produit convertDtoToEntity(ProduitDTO p);
}

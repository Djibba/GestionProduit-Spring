package com.gestionproduits.service;

import com.gestionproduits.dto.ProduitDTO;
import com.gestionproduits.entities.Categorie;
import com.gestionproduits.entities.Produit;
import com.gestionproduits.repos.ProduitRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {
	
	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ProduitDTO saveProduit(ProduitDTO p) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public ProduitDTO getProduit(Long id) {
		return convertEntityToDto(produitRepository.findById(id).get());
	}

	@Override
	public List<ProduitDTO> getAllProduits() {
		return produitRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);
	}

	@Override
	public List<Produit> findByNomProduit(String nom) {
		return produitRepository.findByNomProduit(nom);
	}

	@Override
	public List<Produit> findByNomProduitContains(String nom) {
		return produitRepository.findByNomProduitContains(nom);
	}

	@Override
	public List<Produit> findByNomEtPrix(String nom, Double prix) {
		return produitRepository.findByNomEtPrix(nom, prix);
	}

	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie);
	}

	@Override
	public List<Produit> findByCategorieIdCat(Long id) {
		return produitRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc();
	}

	@Override
	public List<Produit> trierProduitsNomsPrix() {
		return produitRepository.trierProduitsNomsPrix();
	}

	@Override
	public ProduitDTO convertEntityToDto(Produit produit) {

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);
		return produitDTO;

//		ProduitDTO produitDTO = new ProduitDTO();

//		produitDTO.setIdProduit(produit.getIdProduit());
//		produitDTO.setNomProduit(produit.getNomProduit());
//		produitDTO.setPrixProduit(produit.getPrixProduit());
//		produitDTO.setDateCreation(produit.getDateCreation());
//		produitDTO.setCategorie(produit.getCategorie());

//		return ProduitDTO.builder()
//				.idProduit(produit.getIdProduit())
//				.nomProduit(produit.getNomProduit())
//				.prixProduit(produit.getPrixProduit())
//				.dateCreation(produit.getDateCreation())
//				.categorie(produit.getCategorie())
//				.build();
	}

	@Override
	public Produit convertDtoToEntity(ProduitDTO pDto) {

		Produit produit = modelMapper.map(pDto, Produit.class);
		return produit;

//		Produit prod = new Produit();
//
//		prod.setIdProduit(pDto.getIdProduit());
//		prod.setNomProduit(pDto.getNomProduit());
//		prod.setPrixProduit(pDto.getPrixProduit());
//		prod.setDateCreation(pDto.getDateCreation());
//		prod.setCategorie(pDto.getCategorie());
//
//		return prod;

	}


}

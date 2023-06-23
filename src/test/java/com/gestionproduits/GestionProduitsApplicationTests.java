package com.gestionproduits;

import com.gestionproduits.entities.Categorie;
import com.gestionproduits.entities.Produit;
import com.gestionproduits.repos.CategorieRepository;
import com.gestionproduits.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GestionProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;

	// Test Categories
	@Test
	public void testCreateCategory() {
		Categorie cat = new Categorie();
		cat.setNomCat("Apple");
		cat.setDescriptionCat("Apple Store");
		categorieRepository.save(cat);
	}

	//Test Products
	@Test
	public void testCreateProduit() {
//		Produit prod = new Produit("Mac",22.500,new Date());
//		produitRepository.save(prod);
	}

	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);

	}
	
	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
		
	}
	
	@Test
	public void testDeleteProduit(){ 
		produitRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousProduits(){
		List<Produit> prods = produitRepository.findAll();
		for(Produit p : prods) System.out.println(p);
	}

	@Test
	public void testFindByNomProduit() {
		List<Produit> prods = produitRepository.findByNomProduit("Iphone X");
		for(Produit p : prods) System.out.println(p);
	}

	@Test
	public void testfindByNomProduitContaining() {
		List<Produit> prods = produitRepository.findByNomProduitContains("phone");
		for(Produit p : prods) System.out.println(p);
	}

	@Test
	public void testfindByNomAndPrix() {
		List<Produit> prods = produitRepository.findByNomEtPrix("Iphone 15", 5000.0);
		for(Produit p : prods) System.out.println(p);
	}

	@Test
	public void testFindByCategories() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for(Produit p : prods) System.out.println(p);
	}

	@Test
	public void testFindByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for(Produit p : prods) System.out.println(p);
	}

	@Test
	public void testfindByOrderByNomProduitAsc()
	{
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}

	@Test public void testTrierProduitsNomsPrix()
	{
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	}
}

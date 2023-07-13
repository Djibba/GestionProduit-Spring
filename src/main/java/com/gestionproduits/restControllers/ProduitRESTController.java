package com.gestionproduits.restControllers;

import com.gestionproduits.dto.ProduitDTO;
import com.gestionproduits.entities.Produit;
import com.gestionproduits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {

    @Autowired
    ProduitService produitService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProduitDTO> getAllProduits() {
        return produitService.getAllProduits();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ProduitDTO getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ProduitDTO createProduit(@RequestBody ProduitDTO p) {
        return produitService.saveProduit(p);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ProduitDTO updateProduit(@RequestBody ProduitDTO p) {
        return produitService.updateProduit(p);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id) {
        produitService.deleteProduitById(id);
    }

    @RequestMapping(value = "/prodsCat/{idCat}",method = RequestMethod.GET)
    public List<Produit> getProduitByCategorie(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

    @RequestMapping(value = "/prodsByNom/{nom}",method = RequestMethod.GET)
    public List<Produit> findByNomProduitContains(@PathVariable("nom") String nom) {
        return produitService.findByNomProduitContains(nom);
    }
}

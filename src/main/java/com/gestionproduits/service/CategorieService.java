package com.gestionproduits.service;

import com.gestionproduits.entities.Categorie;

public interface CategorieService {

    Categorie saveCategorie(Categorie c);
    Categorie getAllCategories();
}

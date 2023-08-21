package com.gestionproduits.service;

import com.gestionproduits.entities.Categorie;
import com.gestionproduits.repos.CategorieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CategorieServiceImpl implements CategorieService{

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Categorie saveCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public Categorie getAllCategories() {
        return null;
    }
}

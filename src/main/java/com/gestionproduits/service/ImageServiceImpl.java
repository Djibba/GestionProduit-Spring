package com.gestionproduits.service;

import com.gestionproduits.entities.Image;
import com.gestionproduits.entities.Produit;
import com.gestionproduits.repos.ImageRepository;
import com.gestionproduits.repos.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ProduitService produitService;

    @Autowired
    ProduitRepository produitRepository;
    @Override
    public Image uploadImage(MultipartFile file) throws IOException {
        return imageRepository.save(Image.builder()

                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .build());
    }

    @Override
    public Image getImageDetails(Long id) throws IOException {

        final Optional<Image> retrievedImage = imageRepository.findById(id);
        return Image.builder()
                .idImage(retrievedImage.get().getIdImage())
                .name(retrievedImage.get().getName())
                .type(retrievedImage.get().getType())
                .image(retrievedImage.get().getImage())
                .build();
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException {
        final Optional<Image> retrievedImage = imageRepository.findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(retrievedImage.get().getType()))
                .body(retrievedImage.get().getImage());
    }

    @Override
    public void deleteImage(Long id) throws IOException {

        imageRepository.deleteById(id);

    }

    @Override
    public Image uploadImageProd(MultipartFile file, Long id) throws IOException {

        Produit p = new Produit();
        p.setIdProduit(id);

        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .produit(p)
                .build());
    }

    @Override
    public List<Image> getImagesByProd(Long id) throws IOException {
        Produit p = produitRepository.findById(id).get();

        return p.getImages();
    }


}

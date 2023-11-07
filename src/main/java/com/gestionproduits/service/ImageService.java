package com.gestionproduits.service;

import com.gestionproduits.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    Image uploadImage(MultipartFile file  ) throws IOException;
    Image getImageDetails(Long id) throws IOException;
    ResponseEntity<byte[]> getImage(Long id) throws IOException;
    void deleteImage(Long id) throws IOException;

    Image uploadImageProd(MultipartFile file, Long id) throws IOException;
    List<Image> getImagesByProd(Long id) throws IOException;

}

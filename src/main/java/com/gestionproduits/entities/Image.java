package com.gestionproduits.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;
    private String name;
    private String type;
    @Column(name = "Image", length = 4048576)
    @Lob
    private byte[] image;
    @OneToOne
    private Produit produit;
}

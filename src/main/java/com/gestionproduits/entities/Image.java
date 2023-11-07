package com.gestionproduits.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "image", length = 5242880)
    @Lob
    private byte[] image;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

//    @OneToOne
//    private Produit produit;
//   // 5242880
      //      4048576
}

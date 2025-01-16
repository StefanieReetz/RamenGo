package br.com.alura.ramengo.model;

import jakarta.persistence.*;
@Entity
@Table(name = "orders")
public class Order {

    private Long externalId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ManyToOne(optional = false)  Garantir que não permite valores nulos
//    @JoinColumn(name = "broth_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Broth broth;

//     @ManyToOne(optional = false) Garantir que não permite valores nulos
//    @JoinColumn(name = "protein_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Protein protein;

    public Order() {
    }

    // Construtor
    public Order(Broth broth, Protein protein) {
        this.broth = broth;
        this.protein = protein;
    }
    public Order(Long id, Broth broth, Protein protein) {
        this.id = id;
        this.broth = broth;
        this.protein = protein;
    }
//@Entity
//@Table(name="orders")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Broth broth;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Protein protein;
//
//    public Order(Broth broth, Protein protein) {
//
//    }


    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public Long getId() {
        return id;
    }

    public Broth getBroth() {
        return broth;
    }

    public void setBroth(Broth broth) {
        this.broth = broth;
    }

    public Protein getProtein() {
        return protein;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }


}
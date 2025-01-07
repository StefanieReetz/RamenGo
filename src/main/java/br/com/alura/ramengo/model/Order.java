package br.com.alura.ramengo.model;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Broth broth;
    @ManyToOne(fetch = FetchType.LAZY)
    private Protein protein;

    public Order(Broth broth, Protein protein) {

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
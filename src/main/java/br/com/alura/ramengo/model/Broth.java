package br.com.alura.ramengo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "broths")
public class Broth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  image ;
    private String name;
    private String description;
    private Integer price;
    @OneToMany(mappedBy = "broth")
    private List<Order> order;

    public Broth(Long id) {
        this.id = id;
    }

    public Broth(Long id, String image, String name, String description, Integer price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Broth() {
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public String getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public Integer getPrice() {
        return price;
    }
}

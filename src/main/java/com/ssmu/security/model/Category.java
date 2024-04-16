package com.ssmu.security.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "logoUrl"),
        @UniqueConstraint(columnNames = "id")
})
public class Category {

    @Id
    @Column(name = "id", nullable = false, length = 50, insertable = true, updatable = true)
    private Long id;

    @Column(name = "name", nullable = false, length = 50, insertable = true, updatable = true)
    private String name;
    
    @Column(name = "logoUrl", nullable = false, length = 1000, insertable = true, updatable = true)
    private String logoUrl;


    public Category() {
    }

    public Category(String name, Long id, String logoUrl) {
        this.name = name;
        this.id = id;
        this.logoUrl=logoUrl;
        
    }

    public Category(Long id, String logoUrl) {
        this.id = id;
        this.logoUrl=logoUrl;
    }

    public Category(String name, String logoUrl) {
      this.name = name;
      this.logoUrl=logoUrl;
  }

    public Category(int id, String name, String logoUrl) {
        this.id = Long.valueOf(id);
        this.name = name;
        this.logoUrl = logoUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", logoUrl=" + logoUrl + "]";
    }

}

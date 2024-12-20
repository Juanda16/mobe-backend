package com.ssmu.security.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;


@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "products", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "name"),
    @UniqueConstraint(columnNames = "type"),
    @UniqueConstraint(columnNames = "picUrl"),
    @UniqueConstraint(columnNames = "price"),
    @UniqueConstraint(columnNames = "store")    
    
})


public class Product {
  @Id
  @Column(name = "id", nullable = false, length = 50, insertable = true, updatable = true)
  private Long id;

  @Column(name = "name", nullable = false, length = 50, insertable = true, updatable = true)
  private String name;

  @Column(name = "type", nullable = false, length = 100, insertable = true, updatable = true)
  private String type;

  @Column(name = "picUrl", nullable = false, length = 1000, insertable = true, updatable = true)
  private String picUrl;

  @Column(name = "store", nullable = false, length = 100, insertable = true, updatable = true)
  private String store;

  @Column(name = "price", nullable = false, length = 100, insertable = true, updatable = true)
  private String price;


  @ManyToOne
  @JoinColumn(name = "store_id")
  private Store store2;


  public Product() {
  }

  public Product(Long id, String name,  String type, String picUrl, String store, String price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.picUrl = picUrl;
    this.store = store;
    this.price = price;

  }

  public Product(String name) {
    this.name = name;
  }

  public Product(Long id) {
    this.id = id;

  }

  public Product(int id, String name, String picUrl) {
    this.id = Long.valueOf(id);
    this.name = name;
    this.picUrl = picUrl;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getPicUrl() {
    return picUrl;
  }

  public String getStore() {
    return store;
  }

  public String getPrice() {
    return price;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  public void setStore(String store) {
    this.store = store;
  }

  public void setPrice(String price) {
    this.price = price;
  }



  @Override
  public String toString() {
    return "Store [id=" + id + ", name=" + name + ", type=" + type + ", picUrl=" + picUrl + ", store=" + store +", price=" + price +"]";
  }

}

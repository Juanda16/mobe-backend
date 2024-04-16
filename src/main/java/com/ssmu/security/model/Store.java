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
@Table(name = "stores", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "name"),
    @UniqueConstraint(columnNames = "address"),
    @UniqueConstraint(columnNames = "picUrl"),
    @UniqueConstraint(columnNames = "phone"),
    @UniqueConstraint(columnNames = "description"),
    @UniqueConstraint(columnNames = "rating")
    
})

public class Store {
  @Id
  @Column(name = "id", nullable = false, length = 50, insertable = true, updatable = true)
  private Long id;

  @Column(name = "name", nullable = false, length = 50, insertable = true, updatable = true)
  private String name;

  @Column(name = "address", nullable = false, length = 100, insertable = true, updatable = true)
  private String address;

  @Column(name = "picUrl", nullable = false, length = 1000, insertable = true, updatable = true)
  private String picUrl;

  @Column(name = "phone", nullable = false, length = 100, insertable = true, updatable = true)
  private Integer phone;

  @Column(name = "description", nullable = false, length = 100, insertable = true, updatable = true)
  private String description;

  @Column(name = "rating", nullable = false, length = 100, insertable = true, updatable = true)
  private Float rating;

 
  public Store() {
  }

  public Store(Long id, String name, String address, String picUrl, Integer phone, Float rating, String description) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.picUrl = picUrl;
    this.phone = phone;
    this.rating = rating;
    this.description = description;
  }
  public Store(String name) {
    this.name = name;
  }
  public Store(Long id) {
    this.id = id;

  }
  
  public Store(int id, String name, String picUrl) {
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

public String getAddress() {
    return address;
}

public String getPicUrl() {
    return picUrl;
}

public Integer getPhone() {
  return phone;
}

public Float getRating() {
  return rating;
}

public String getDescription() {
  return description;
}

public void setId(Long id) {
  this.id = id;
}
public void setName(String name) {
  this.name = name;
}
public void setAddress(String address) {
  this.address = address;
}

public void setPicUrl(String picUrl) {
  this.picUrl = picUrl;
}

public void setPhone(Integer phone) {
  this.phone = phone;
}

public void setRating(Float rating) {
  this.rating = rating;
}

public void setDescription(String description) {
  this.description = description;
}

@Override
    public String toString() {
        return "Store [id=" + id + ", name=" + name + ", address=" + address + ", picUrl=" + picUrl + ", phone=" + phone + ", rating=" + rating+ "]";
    }

}

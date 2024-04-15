package com.ssmu.security.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stores", uniqueConstraints = {
    @UniqueConstraint(columnNames = "id"),
    @UniqueConstraint(columnNames = "name"),
    @UniqueConstraint(columnNames = "address"),
    @UniqueConstraint(columnNames = "pic"),
    @UniqueConstraint(columnNames = "phone"),
    @UniqueConstraint(columnNames = "rating"),
    @UniqueConstraint(columnNames = "description")
})

public class Store {
  @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String address;
  private String pic;
  private Integer phone;
  private Float rating;
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private EStore name;

  public Store() {

  }

  public Store(EStore name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EStore getName() {
    return name;
  }

  public void setName(EStore name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  public Integer getPhone() {
    return phone;
  }

  public void setPhone(Integer phone) {
    this.phone = phone;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Float getRating() {
    return rating;
  }

  public void setRating(Float rating) {
    this.rating = rating;
  }

}

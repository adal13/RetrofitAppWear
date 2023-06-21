package com.example.retrofitappwear.entity;

public class User {
   private int id;
   private String name;
   private String username;
   private String email;
   private Address address;
   private String phone;
   private String website;
   private Company company;

   @Override
   public String toString() {
      return "User {" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", username='" + username + '\'' +
              ", email='" + email + '\'' +
              ", address=" + address.toString() +
              ", phone='" + phone + '\'' +
              ", website='" + website + '\'' +
              ", company=" + company.toString() +
              '}';
   }
}

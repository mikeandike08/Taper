package io.github.mikeandike08.taper.model;
import java.util.HashSet;
import java.util.Set;

import io.github.mikeandike08.taper.dto.AddressDTO;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Barber {
    // Barber Personal Info
    private String name;
    private String shopName;
    private String email;
    private String phoneNumber;
    private String bio;

    // Barber Address Info
    private AddressDTO address;
    
    // links to our s3 storage
    private String profileImageUrl;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Decide whether to get ID from postgres, or generate one ourselves.

    // The styles the barber is experienced in
    @ElementCollection
    private Set<String> styles = new HashSet<>();

    protected Barber() {
    }

    // Initialize the object
    public Barber(String name, String shopName, String email, String phoneNumber, String street, String city, String state, String zipCode, String bio) {
        this.name = name;
        this.shopName = shopName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = new AddressDTO(street, city, state, zipCode);
        this.bio = bio;
    }

    // Create our Setters
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImageUrl(String url){
        this.profileImageUrl = url;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStyles(Set<String> newStyles){
        this.styles = new HashSet<>(newStyles);
    }

    public void addStyle(String style){
        // adds one style at a time
        this.styles.add(style);
    }

    public void setAddress(String street, String city, String state, String zipCode){
        this.address = new AddressDTO(street, city, state, zipCode);
    }

    // Create our Getters
    public String getName() {
        return this.name;
    }

    public AddressDTO getAddress() {
        return this.address;
    }

    public String getBio() {
        return this.bio;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getImageUrl(){
        return this.profileImageUrl;
    }

    public String getShopName() {
        return this.shopName;
    }

    public Long getId(){
        return this.id;
    }

    public Set<String> getStyles(){
        return Set.copyOf(styles);
    }

    public String getProfileImageUrl() {
        return this.profileImageUrl;
    }
}

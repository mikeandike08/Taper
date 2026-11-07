package io.github.mikeandike08.taper.model;
import java.util.HashSet;
import java.util.Set;

public class Barber {
    // Barber Personal Info
    private String name;
    private String shopName;
    private String email;
    private String phoneNumber;
    private String city;
    private String state;
    private String bio;
    
    // links to our s3 storage
    private String profileImageUrl;

    private long id; // Decide whether to get ID from postgres, or generate one ourselves.

    // The styles the barber is experienced in
    private Set<String> styles = new HashSet<>();

    // Initialize the object
    public Barber(String name, String shopName, String email, String phoneNumber, String city, String state, long id, String bio) {
        this.name = name;
        this.shopName = shopName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.id = id;
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

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStyles(Set<String> newStyles){
        this.styles = new HashSet<>(newStyles);
    }

    public void addStyle(String style){
        // adds one style at a time
        this.styles.add(style);
    }

    // Create our Getters
    public String getName() {
        return this.name;
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

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
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
        return Set.copyOf(this.styles);
    }

    public String getProfileImageUrl() {
        return this.profileImageUrl;
    }
}

package io.github.mikeandike08.taper.model;
import java.util.Set;
import java.util.HashSet;

public class Barber {
    // Barber Personal Info
    private String name;
    private String email;
    private String phoneNumber;
    private String city;
    private String state;
    
    // links to our s3 storage
    private String profileImageUrl;

    private Long id; // Decide whether to get ID from postgres, or generate one ourselves.

    // The styles the barber is experienced in
    private Set<String> styles = new HashSet<>();

    // Initialize the object
    public Barber(String name, String email, String phoneNumber, String city, String state) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
    }

    // Create our Setters
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

    public Long getID(){
        return this.id;
    }

    public Set<String> getStyles(){
        return Set.copyOf(this.styles);
    }
}

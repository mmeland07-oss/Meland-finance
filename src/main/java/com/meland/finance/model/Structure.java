package com.meland.finance.model;

public class Structure {
    private String id;
    private String name;
    private String logo;
    private String description;
    private String email;
    private String phone;
    private boolean premium;

    public Structure() {
    }

    public Structure(String id, String name, String logo, String description, String email, String phone,
            boolean premium) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.premium = premium;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}

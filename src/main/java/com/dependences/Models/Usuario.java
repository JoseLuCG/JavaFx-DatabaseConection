package com.dependences.Models;

public class Usuario {
    // Attributes:
    private String email;
    private String password;
    private String state;
    private Rol rol = Rol.INVITADO;
    // Constructors:
    public Usuario() {}

    public Usuario(String email, String password, String state, Rol rol) {
        this.email = email;
        this.password = password;
        this.state = state;
        this.rol = rol;
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public String getState() { return state; }

    public Rol getRol() { return rol; }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    // ToString

    @Override
    public String toString() {
        return "Usuario:" +
                "\nCorreo: " + email +
                "\nConstraseña: " + password +
                "\nEstado: " + state +
                "\nRol: " + rol;
    }
}

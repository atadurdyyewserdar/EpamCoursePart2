package com.company.entity;

import java.util.Objects;

public class User {
    private int idUser;
    private String role;
    private String fio;
    private String login;
    private String password;
    private boolean access;

    public User() {
    }

    public User(int idUser, String role, String fio, String login, String password, boolean access) {
        this.idUser = idUser;
        this.role = role;
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.access = access;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idUser == user.idUser &&
                access == user.access &&
                role.equals(user.role) &&
                fio.equals(user.fio) &&
                login.equals(user.login) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, role, fio, login, password, access);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User{")
                .append("idUser=").append(idUser)
                .append(", role='").append(role)
                .append(", fio='").append(fio)
                .append(", login='").append(login)
                .append(", password='").append(password)
                .append(", access=").append(access)
                .append('}');
        return stringBuilder.toString();
    }
}

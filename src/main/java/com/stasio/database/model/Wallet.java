package com.stasio.database.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "wallet_nr")
    private String walletNr;

    @ManyToOne(cascade = CascadeType.REFRESH, targetEntity = User.class)
    private User user;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.DETACH,}, targetEntity = Film.class)
    private Set<Film> films;

    public Wallet(String walletNr) {
        this.walletNr = walletNr;
    }

    public Wallet() {
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", walletNr='" + walletNr + '\'' +
                ", user=" + user +
                ", films=" + films +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWalletNr() {
        return walletNr;
    }

    public void setWalletNr(String walletNr) {
        this.walletNr = walletNr;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}

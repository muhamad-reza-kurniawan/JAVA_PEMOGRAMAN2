package com.hotel.reservasi; // Sesuaikan nama package Anda

import jakarta.persistence.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String namaTamu;
    private String tipeKamar;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalCheckIn;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalCheckOut;

    // OOP: Constructor
    public Reservasi() {}

    // OOP: Getter dan Setter (Encapsulation)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNamaTamu() { return namaTamu; }
    public void setNamaTamu(String namaTamu) { this.namaTamu = namaTamu; }
    public String getTipeKamar() { return tipeKamar; }
    public void setTipeKamar(String tipeKamar) { this.tipeKamar = tipeKamar; }
    public LocalDate getTanggalCheckIn() { return tanggalCheckIn; }
    public void setTanggalCheckIn(LocalDate tanggalCheckIn) { this.tanggalCheckIn = tanggalCheckIn; }
    public LocalDate getTanggalCheckOut() { return tanggalCheckOut; }
    public void setTanggalCheckOut(LocalDate tanggalCheckOut) { this.tanggalCheckOut = tanggalCheckOut; }
}
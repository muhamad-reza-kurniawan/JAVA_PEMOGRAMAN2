package com.hotel.reservasi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservasiController {

    @Autowired
    private ReservasiService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("daftarReservasi", service.getAllReservasi());
        return "index"; // Menampilkan index.html
    }

    @GetMapping("/tambah")
    public String formTambah(Model model) {
        model.addAttribute("reservasi", new Reservasi());
        return "form"; // Menampilkan form.html
    }

    @PostMapping("/simpan")
    public String simpanReservasi(@ModelAttribute("reservasi") Reservasi reservasi, Model model) {
        try {
            service.simpanReservasi(reservasi); // Mencoba menyimpan
            return "redirect:/";
        } catch (Exception e) {
            // Menangkap (Catch) Exception jika gagal/kamar penuh
            model.addAttribute("errorMessage", e.getMessage());
            return "form";
        }
    }
}
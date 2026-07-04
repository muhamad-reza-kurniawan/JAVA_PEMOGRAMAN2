package com.hotel.reservasi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservasiService {

    @Autowired
    private ReservasiRepository repository;

    public List<Reservasi> getAllReservasi() {
        return repository.findAll();
    }

    // Exception Handling dilempar di sini
    public void simpanReservasi(Reservasi reservasi) throws Exception {
        if (reservasi.getTanggalCheckOut().isBefore(reservasi.getTanggalCheckIn())) {
            throw new Exception("Error: Tanggal Check-out tidak boleh lebih awal dari Check-in.");
        }
        
        // Simulasi jika kamar penuh (Maksimal 5 reservasi)
        if (repository.count() >= 5) {
            throw new Exception("Error: Mohon maaf, seluruh kamar saat ini sudah penuh.");
        }
        
        repository.save(reservasi);
    }
}
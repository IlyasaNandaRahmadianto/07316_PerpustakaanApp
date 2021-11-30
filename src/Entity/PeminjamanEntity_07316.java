package Entity;

import java.util.Date;

public class PeminjamanEntity_07316 {
    private String idPinjam;
    
    BukuEntity_07316 buku = new BukuEntity_07316();
    AnggotaEntity_07316 anggota = new AnggotaEntity_07316();
    Date tglPinjam;
    Date tglKembali;
    private Boolean statusPinjam;
}
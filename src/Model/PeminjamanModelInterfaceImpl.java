package Model;

import Entity.*;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;

public class PeminjamanModelInterfaceImpl implements PeminjamanModelInterface{
    
    private String generateIdPeminjaman(){
            String newId = null;
            String data;
            
            try {
                String sql = "SELECT peminjaman_id FROM peminjaman ORDER BY peminjaman_id DESC LIMIT 1 ";
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql);
                if(rs.next()){
                    data = rs.getString("peminjaman_id");
                } else{
                    data = "PJM000";
                }
                int angka = Integer.parseInt(data.substring(3));
                angka++;
                newId = "PJM" + String.format("%03", angka);
            } catch (Exception e) {
                e.printStackTrace();
            }return newId;
    }
    
    @Override
    public void add(PeminjamanEntity peminjaman) {
        try{
            String sql = "INSERT INTO PEMINJAMAN(peminjaman_id,buku_isbn,anggota_id,peminjaman_tgl,status)"
                    + "Values(?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, generateIdPeminjaman());
            stat.setString(2, peminjaman.getBuku().getIsbn());
            stat.setInt(3, peminjaman.getAnggota().getId());
            stat.setDate(4, Date.valueOf(LocalDate.now()));
            stat.setBoolean(5, false);
            stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void verifPengembalian(String idPeminjaman) {
        try {
            String sql = "UPDATE PEMINJAMAN SET peminjaman_status = True WHERE peminjaman_id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, idPeminjaman);
            stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<PeminjamanEntity> getAll() {
        ArrayList<PeminjamanEntity> arrPeminjaman = new ArrayList<>();
        try {
            String sql = "SELECT p.*, b.buku_judul, a.anggota_nama, a.anggota_password FROM peminjaman p"
                    + "JOIN anggota a on p.anggota_id = a.anggota_id"
                    + "JOIN buku b on p.buku_isbn = b.buku_isbn"
                    + "ORDER BY peminjaman_id";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PeminjamanEntity peminjaman = new PeminjamanEntity();
                peminjaman.setIdPeminjaman(rs.getString("peminjaman_id"));
                BukuEntity buku = new BukuEntity();
                buku.setIsbn(rs.getString("buku_isbn"));
                buku.setJudul(rs.getString("buku_judul"));
                peminjaman.setBuku(buku);
                AnggotaEntity anggota = new AnggotaEntity(rs.getString("anggota_nama"), rs.getString("anggota_password"));
                peminjaman.setAnggota(anggota);
                peminjaman.setTglPeminjaman(rs.getDate("peminjaman_tgl"));
                peminjaman.setTglPengembalian(rs.getDate("pengembalian_tgl"));
                peminjaman.setStatusPeminjaman(rs.getBoolean("status"));
                arrPeminjaman.add(peminjaman);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }return arrPeminjaman;
    }

    @Override
    public ArrayList<PeminjamanEntity> getByPeminjam(int id) {
        ArrayList<PeminjamanEntity> peminjamanByUser = new ArrayList<>();
        try {
            String sql = "SELECT p.*, b.buku_judul FROM peminjaman p"
                    + "JOIN buku b on p.buku_isbn = b.buku_isbn"
                    + "WHERE anggota_id = ?"
                    + "ORDER BY peminjaman_tgl";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                PeminjamanEntity peminjaman = new PeminjamanEntity();
                peminjaman.setIdPeminjaman(rs.getString("peminjaman_id"));
                BukuEntity buku = new BukuEntity();
                buku.setIsbn(rs.getString("buku_isbn"));
                buku.setJudul(rs.getString("buku_judul"));
                peminjaman.setBuku(buku);
                peminjaman.setTglPeminjaman(rs.getDate("peminjaman_tgl"));
                peminjaman.setTglPengembalian(rs.getDate("pengembalian_tgl"));
                peminjaman.setStatusPeminjaman(rs.getBoolean("status"));
                peminjamanByUser.add(peminjaman);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }return peminjamanByUser;
    }      
}

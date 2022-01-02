package Controller;

import Entity.BukuEntity;
import java.util.ArrayList;

public class BukuControllerInterfaceimpl implements BukuControllerInterface {
    @Override
    public void insertBuku(String isbn, String judul, String penerbit, int terbit, int halaman) {
        BukuEntity buku = new BukuEntity();
        buku.setIsbn(isbn);
        buku.setJudul(judul);
        buku.setPenerbit(penerbit);
        buku.setTerbit(terbit);
        buku.setHalaman(halaman);
        AllObjectModel.bukuModel.add(buku);
    }
    @Override
    public void deleteBuku(String isbn) {
        AllObjectModel.bukuModel.delete(isbn);
    }
    @Override
    public void updateBuku(int pilihan, String data, String isbn) {
      switch(pilihan){
        case 1:
        AllObjectModel.bukuModel.updateJudul(data, isbn);
        break;
        case 2:
        AllObjectModel.bukuModel.updatePenerbit(data, isbn);
        break;
      }
    }
    
    @Override
    public ArrayList<BukuEntity> showAllData() {
        return AllObjectModel.bukuModel.getAll();
    }
    
    @Override
    public BukuEntity getData(String isbn) {
        return AllObjectModel.bukuModel.getById(isbn); 
    }
}

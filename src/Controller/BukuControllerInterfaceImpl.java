package Controller;

import Entity.BukuEntity;
import java.util.ArrayList;

public class BukuControllerInterfaceImpl implements BukuControllerInterface {

    @Override
    public void insertBuku(String isbn, String judul, String penerbit, int terbit, int halaman) {
        //BukuEntity buku = new BukuEntity();
        //buku.setIsbn(isbn);
        //buku.setJudul(judul);
        //buku.setPenerbit(penerbit);
        //buku.setTerbit(terbit);
        //buku.setHalaman(halaman);
        //AllObjectModel.bukuModel.add(buku);
        AllObjectModel.bukuModel.add(new BukuEntity(isbn,judul,penerbit,terbit,halaman));
    }

    @Override
    public void deleteBuku(String isbn) {
        AllObjectModel.bukuModel.delete(isbn);
    }

    @Override
    public void updateBuku(int pilihan, String data, String isbn) {
        switch(pilihan){
            case 1:
                AllObjectModel.bukuModel.updateJudul(isbn, data);
                break;
            case 2:
                AllObjectModel.bukuModel.updatePenertbit(isbn, data);
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

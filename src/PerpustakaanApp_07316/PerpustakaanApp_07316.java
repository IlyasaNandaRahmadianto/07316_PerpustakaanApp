package PerpustakaanApp_07316;

import Controller.*;
import java.util.Scanner;

public class PerpustakaanApp_07316 {
    public static Scanner input = new Scanner(System.in);
    public static AdminControllerInterface adminController = new AdminControllerInterfaceImpl();
    public static AnggotaControllerInterface anggotaController = new AnggotaControllerInterfaceImpl();
    public static BukuControllerInterface bukuController = new BukuControllerInterfaceImpl();
    public static PeminjamanControllerInterface peminjamanController =  new PeminjamanControllerInterfaceImpl();
    
    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("SELAMAT DATANG");
            System.out.println("1. REGISTRASI");
            System.out.println("2. LOGIN");
            System.out.println("3. KELUAR");
            System.out.println("PILIHAN : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1:
                    registrasi();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("KELUAR");;
                    break;
            }
        } while (pilih <= 2);
    }
    
    public static void registrasi(){
        System.out.println("NAMA : ");
        String nama = input.next();
        System.out.println("PASSWORD : ");
        String password = input.next();
        System.out.println("NO TELP : ");
        String noTelp = input.next();
        System.out.println("ALAMAT : ");
        String alamat = input.next();
        anggotaController.insertAnggota(nama, password, noTelp, alamat);
    }
    
    public static void login(){
        int pilih;
        do {
            System.out.println("LOGIN AS");
            System.out.println("1. ADMIN");
            System.out.println("2. ANGGOTA");
            System.out.println("PILIHAN : ");
            pilih = input.nextInt();
            switch (pilih){
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    loginAnggota();
                    break;
            }
        } while (pilih <= 2);
    }
    
    public static void loginAdmin(){
        
    }
    
    public static void loginAnggota(){
        
    }
    
    public static void menuAdmin(){
        
    }
    
    public static void daftarAnggota(){
        
    }
    
    public static void hapusAnggota(){
        
    }
    
    public static void resetPasswordAnggota(){
        
    }
    
    public static void daftarBuku(){
        
    }
    
    public static void tambahBuku(){
        
    }
    
    public static void hapusBuku(){
        
    }
    
    public static void ubahBuku(){
        
    }
    
    public static void lihatDaftarPeminjaman(){
        
    }
    
    public static void verifikasiPengembalian(){
        
    }
    
    public static void menuAnggota(int id){
        
    }
    
    public static void lihatRiwayatPeminjaman(int id){
        
    }
    
    public static void pinjamBuku(int id){
        
    }
    
    public static void editDataAnggota(int id){
        
    }
    
    public static void dataAnggotaById(){
        
    }
}

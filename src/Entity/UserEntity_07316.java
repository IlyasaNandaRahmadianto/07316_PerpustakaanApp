package Entity;

//class yg belum jelas implement
public abstract class UserEntity_07316 {
    //dapatdipanggil oleh class yg sama dan anak kelas yg  mewarisinya
    protected int id_07316;
    protected String nama, password;
    
    public UserEntity_07316(){
    }
    
    public UserEntity_07316(String nama, String password){
        this.nama = nama;
        this.password = password;
    }
    
    //attribut encapsulation
    public String getNama(){ return nama; }
    public String getPassword(){ return password; }
    
    public void setNama(String nama){ this.nama = nama; }
    public void setPassword(String password){ this.password = password; }
}

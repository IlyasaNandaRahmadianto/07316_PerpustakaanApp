package Entity;

public class AnggotaEntity_07316 extends UserEntity_07316{
    private String noTelp;
    private String alamat;
    private int id;
    
    public AnggotaEntity_07316(String nama, String password, String noTelp, String alamat){
        super(nama,password);
        this.noTelp = noTelp;
        this.alamat = alamat;
    }
    
    AnggotaEntity_07316(){}
    
    public String getNoTelp(){ return noTelp; }
    public String getAlamat(){ return alamat; }
    public int getId(){ return id; }
    
    public void setNoTelp(String noTelp){ this.noTelp = noTelp; }
    public void setAlamat(String alamat){ this.alamat = alamat; }
    public void setId(int id){ this.id = id; }
}
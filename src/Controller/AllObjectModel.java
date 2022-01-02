package Controller;
import Model.*;

public class AllObjectModel {
    public static AdminModelInterface adminModel = new AdminModelInterfaceimpl();
    public static AnggotaModelInterface anggotaModel = new AnggotaModelInterfaceimpl();
    public static BukuModelInterface bukuModel = new BukuModelInterfaceimpl();
    public static PeminjamanModelInterface peminjamanModel = new PeminjamanModelInterfaceimpl();
}

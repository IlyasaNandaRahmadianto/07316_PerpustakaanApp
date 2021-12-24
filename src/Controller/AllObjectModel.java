package Controller;

import Model.*;

public class AllObjectModel {
    public static AdminModelInterface adminModel = new AdminModelInterfaceImpl(); //polymorpishm dinamis
    public static AnggotaModelInterface anggotaModel = new AnggotaModelInterfaceImpl();
    public static BukuModelInterface bukuModel = new BukuModelInterfaceImpl();
    public static PeminjamanModelInterface peminjamanModel = new PeminjamanModelInterfaceImpl();
}

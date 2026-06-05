import java.util.ArrayList;

abstract class Orang {
    private String nama;

    public Orang(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public abstract void tampilkanPeran();
}

class MataKuliah {
    private String kode;
    private String nama;
    private int sks;

    public MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public String getInfo() {
        return kode + " - " + nama + " (" + sks + " SKS)";
    }
}

class Dosen extends Orang {
    private String nidn;
    private ArrayList<MataKuliah> mataKuliahDiajar;

    public Dosen(String nama, String nidn) {
        super(nama);
        this.nidn = nidn;
        this.mataKuliahDiajar = new ArrayList<>();
    }

    public void tambahMataKuliah(MataKuliah mataKuliah) {
        mataKuliahDiajar.add(mataKuliah);
    }

    @Override
    public void tampilkanPeran() {
        System.out.println(getNama() + " berperan sebagai Dosen.");
    }

    public void tampilkanMataKuliahDiajar() {
        System.out.println("Dosen : " + getNama());
        System.out.println("NIDN  : " + nidn);
        System.out.println("Mata Kuliah yang Diajar:");

        for (MataKuliah mk : mataKuliahDiajar) {
            System.out.println("- " + mk.getInfo());
        }
    }
}

class Mahasiswa extends Orang {
    private String nim;
    private ArrayList<MataKuliah> mataKuliahDiambil;

    public Mahasiswa(String nama, String nim) {
        super(nama);
        this.nim = nim;
        this.mataKuliahDiambil = new ArrayList<>();
    }

    public void ambilMataKuliah(MataKuliah mataKuliah) {
        mataKuliahDiambil.add(mataKuliah);
    }

    @Override
    public void tampilkanPeran() {
        System.out.println(getNama() + " berperan sebagai Mahasiswa.");
    }

    public void tampilkanKrs() {
        System.out.println("Mahasiswa : " + getNama());
        System.out.println("NIM       : " + nim);
        System.out.println("Mata Kuliah yang Diambil:");

        for (MataKuliah mk : mataKuliahDiambil) {
            System.out.println("- " + mk.getInfo());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        MataKuliah pbo = new MataKuliah("IF204", "Pemrograman Berorientasi Objek", 3);
        MataKuliah web = new MataKuliah("IF305", "Pemrograman Web", 3);
        MataKuliah strukturData = new MataKuliah("IF201", "Struktur Data", 3);

        Dosen dosen = new Dosen("Pak Indra", "0712345601");
        dosen.tambahMataKuliah(pbo);
        dosen.tambahMataKuliah(web);

        Mahasiswa mahasiswa = new Mahasiswa("Andi Pratama", "230411001");
        mahasiswa.ambilMataKuliah(pbo);
        mahasiswa.ambilMataKuliah(strukturData);

        
    }
}

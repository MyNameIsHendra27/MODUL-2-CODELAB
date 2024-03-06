import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private static String universitas = "Universitas Muhammadiyah Malang";

    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public static void tampilUniversitas() {
        System.out.println("Universitas: " + universitas);
    }

    public void tampilDataMahasiswa() {
        System.out.println("Data Mahasiswa:");
        tampilUniversitas();
        System.out.println("Nama : " + nama);
        System.out.println("NIM : " + nim);
        System.out.println();
    }

    public static boolean isValidNIM(String nim) {
        return nim.length() == 15;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner objinput = new Scanner(System.in);
        Mahasiswa mahasiswa = null;

        int pilihan = 0;
        while (pilihan != 3) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = objinput.nextInt();
            objinput.nextLine();  // consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = objinput.nextLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = objinput.nextLine();
                    while (!Mahasiswa.isValidNIM(nim)) {
                        System.out.println("NIM harus terdiri dari 15 digit!");
                        System.out.print("Masukkan NIM mahasiswa: ");
                        nim = objinput.nextLine();
                    }
                    System.out.print("Masukkan jurusan mahasiswa: ");
                    String jurusan = objinput.nextLine();
                    mahasiswa = new Mahasiswa(nama, nim, jurusan);
                    System.out.println("Data mahasiswa berhasil ditambahkan.");
                    break;
                case 2:
                    if (mahasiswa != null) {
                        mahasiswa.tampilDataMahasiswa();
                    } else {
                        System.out.println("Belum ada data mahasiswa.");
                    }
                    break;
                case 3:
                    System.out.println("Anda keluar dari Program");
                    break;
                default:
                    System.out.println("Pilihan tidak ada!");
            }
        }
        objinput.close();
    }
}
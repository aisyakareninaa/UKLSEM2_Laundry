/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laundryy;
import java.util.Scanner;
public class main {
    static Client client = new Client();
    static Petugas petugas = new Petugas();
    static Transaksi transaksi = new Transaksi();
    static JenisLaundry jenislaundry = new JenisLaundry();
    static Scanner input = new Scanner(System.in);
    static boolean tetap = true;
    static String key;
    
    public static void main(String[] args){
        System.out.print("Apakah anda sudah memiliki akun?(yes/no) ");
        String jawab = input.next();
        if(jawab.equalsIgnoreCase("yes")){
            System.out.print("Masukkan ID Anda = ");
            int id = input.nextInt();
            System.out.println("Selamat Datang di Laundry Bersih "+client.getNama(transaksi.getClient(id)));
            System.out.println("ID anda " +id);
            menu(id);
        } 
        else if (jawab.equalsIgnoreCase("no")){
            System.out.print("Masukkan Nama Anda = ");
            String nama = input.next();
            client.setNama(nama);
            System.out.print("Masukkan ID untuk anda = ");
            int Id = input.nextInt();
            transaksi.setIDClient(Id);
            System.out.print("Masukkan Alamat = ");
            String alamat = input.next();
            client.setAlamat(alamat);
            System.out.print("Masukkan Nomor Telepon = ");
            String telepon = input.next();
            client.setTelepon(telepon);
            System.out.print("Masukkan saldo yang ingin anda tambahkan = ");
            int saldo = input.nextInt();
            client.addSaldo(saldo);
            System.out.println("Terimakasih telah mendaftar "+nama);
            int id = transaksi.getIDClient(client.getId(nama));
            System.out.println("ID anda "+id);
            menu(id);             
        }
        else {
            System.out.println("Input yang anda masukkan tidak sesuai");
            System.out.println("Silahkan coba lagi dengan mengetik yes/no");
        }
    }
    public static void tampilLaundry(){
        int n = jenislaundry.size();
        for(int i=0;i<n;i++){
            System.out.println("------------------------");
            System.out.println("        "+jenislaundry.getLaundry(i));
            System.out.println("Harga  = "+jenislaundry.getHarga(i));
            System.out.println("Durasi = "+jenislaundry.getDurasi(i));
            System.out.println("ID     = "+transaksi.getIDJenisLaundry(i));
        }
    }
    public static void menu(int id){
        while(tetap){
            System.out.println("-- Laundry --");
            System.out.println("1. List Laundry");
            System.out.println("2. List Petugas");
            System.out.println("3. List Client");
            System.out.println("4. Laundry");
            System.out.println("5. Exit");
            System.out.print("Pilih menu = ");
            int menu = input.nextInt();
            if(menu==1){
                tampilLaundry();
                System.out.println("Ketik apapun dan enter untuk keluar");
                key = input.next();
            }
            else if(menu==2){
                petugas.tampilPetugas();
                System.out.println("Ketik apapun dan enter untuk keluar");
                key = input.next();
            }
            else if(menu==3){
                client.tampilClient();
                System.out.println("Ketik apapun dan enter untuk keluar");
                key = input.next();
            }
            else if(menu==4){
                tampilLaundry();
                System.out.println("Masukkan Id laundry yang diinginkan");
                int laundry = input.nextInt();
                System.out.println("Masukkan berapa banyak laundry anda");
                int banyak = input.nextInt();
                transaksi.setBanyak(banyak);
                int harga = jenislaundry.getHarga(transaksi.getIDJenisLaundry(laundry))*banyak;
                int total ;
                total = client.getSaldo(transaksi.getClient(id))-harga;
                if(client.getSaldo(transaksi.getClient(id))>=harga){
                    System.out.println("----------Total----------");
                    System.out.println("Nama Pelanggan = "+client.getNama(transaksi.getClient(id)));
                    System.out.println("Jenis Laundry = "+jenislaundry.getLaundry(laundry));
                    System.out.println("Total Harga   = "+harga);
                    System.out.println("Durasi        = "+jenislaundry.getDurasi(laundry)+ "jam");
                    System.out.println("Sisa Saldo = "+total);
                    client.setSaldo(transaksi.getClient(id),client.getSaldo(transaksi.getClient(id))-harga);
                    System.out.println("Petugas       = "+petugas.getNama(transaksi.getIDJenisLaundry(laundry)));
                    System.out.println("Terimakasih telah menggunkaan jasa kami");
                    System.out.println("Ketik apapun dan enter untuk kembali");
                    key = input.next();
                }
                else{
                    System.out.println("Saldo anda tidak cukup");
                    System.out.println("Ketik apapun dan enter untuk kembali");
                    key = input.next();
                }
            }
            else if(menu==5){
                System.out.println("Sampai Jumpa Lagi");
                tetap = false;
            }
            else{
                System.out.println("Input yang anda masukkan tidak sesuai");
                System.out.println("Ketik apapun dan enter untuk kembali");
                key = input.next();
            }
        }
    }
}


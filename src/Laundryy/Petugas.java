/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laundryy;


import java.util.ArrayList;
public class Petugas implements User{
    private ArrayList<String> namaPetugas = new ArrayList<String>();
    private ArrayList<String> alamat = new ArrayList<String>();
    private ArrayList<String> telepon = new ArrayList<String>();
    private ArrayList<Integer> jabatan = new ArrayList<Integer>();
    
    public Petugas(){
        this.namaPetugas.add("Admin Cuci Kering");
        this.alamat.add("Belimbing");
        this.telepon.add("089********");
        this.jabatan.add(1);
        
        this.namaPetugas.add("Admin Cuci Lipat");
        this.alamat.add("Sawojajar");
        this.telepon.add("085********");
        this.jabatan.add(2);
        
        this.namaPetugas.add("Admin Cuci Setrika");
        this.alamat.add("Lesanpuro");
        this.telepon.add("083********");
        this.jabatan.add(3);
        
        this.namaPetugas.add("Admin Cuci Karpet");
        this.alamat.add("Batu");
        this.telepon.add("0891*******");
        this.jabatan.add(4);
    }
    @Override
    public void setNama(String nama) {
        this.namaPetugas.add(nama);
    }
    @Override
    public void setAlamat(String alamat) {
        this.alamat.add(alamat);
    }
    @Override
    public void setTelepon(String telepon) {
        this.telepon.add(telepon);
    }
    @Override
    public void setJabatan (Integer Jabatan) {
        this.jabatan.add(Jabatan);
    }
    @Override
    public String getNama(int id) {
        return this.namaPetugas.get(id);
    }
    @Override
    public String getAlamat(int id) {
        return this.alamat.get(id);
    }

    @Override
    public String getTelepon(int id) {
        return this.telepon.get(id);
    }
    @Override
    public Integer getJabatan (int id) {
        return this.jabatan.get(id);
    }
  
    public void tampilPetugas(){
        int n = this.namaPetugas.size();
        for(int i=0;i<n;i++){
            System.out.println("------------------------");
            System.out.println("Nama    = "+getNama(i));
            System.out.println("Alamat  = "+getAlamat(i));
            System.out.println("Telepon = "+getTelepon(i));
            System.out.println("Jabatan = "+getJabatan(i));
        }
    }
}


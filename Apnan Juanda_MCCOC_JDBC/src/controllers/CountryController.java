/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import java.util.ArrayList;
import java.util.List;
import models.Country;

/**
 *
 * @author ASUS
 */
public class CountryController {
    
    //buat dulu yang mengeksekusikan di database
    //private CountryDAO cdao;
    
    //pembuatan constructor untuk membuat objek si pengeksekusi di database
//    public CountryController(){
//        this.cdao = new CountryDAO();
//    }
    
    //karena ini perintah ambil data sehingga data yang akan ditampilkan akan banyak dan harus ditampung dalam sebuah array
//    public List<Country> binding(){
//        List<Country> countries = new ArrayList<>();
//        countries = this.cdao.getCountry();
//        return countries;
//    }
    
    private CountryDAO cdao;
    
    public CountryController(){
        this.cdao = new CountryDAO();
        
    }
    
    //method untuk memanggi getCountry
    public List<Country> binding(){
        List<Country> countries = new ArrayList<>();
        countries = this.cdao.getCountry();
        return countries;
    }
    
    
//    //method untuk memanggil INSERT
//    public String save(String id, String name, int region){
//        String result = "Simpan data ke Country gagal";
//        
//        Country country = new Country(id, name, region);
//        if(this.cdao.insert(country)) result="Simpan data ke country berhasil";
//        return result;
//    }
    
    //method untuk memanggil insert cda
    public String save(String id, String name, int region){
        String result = "Simpan data Country gagal";
        
        Country country = new Country(id, name, region);
        if(this.cdao.insert(country)) result = "Simpan data ke Country berhasil";
        return result;
    }
    
    //method untuk DELETE
    public String delete(String id){
        String result = "Gagal menghapus data pada tabel country";
        
        if(this.cdao.delete(id)); result = "Berhasil menghapus data pada tabel country";
        return result;
    }
    
    //method Searching
     public List<Country> searching(String name){
        List<Country> countryName = new ArrayList<>();
        countryName = this.cdao.getCountryByName(name);
        return countryName;
    }
    
    
}

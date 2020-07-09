/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import controllers.CountryController;
import controllers.RegionController;
import java.util.List;
import java.util.Scanner;
import models.Country;
import models.Region;

/**
 *
 * @author ASUS
 */
public class ManualTest {
    public static void main(String[] args) {
//        System.out.println(new Koneksi().getConnection());
        
        
//        CountryController controller2 = new CountryController();
        
        
        
        try {
            
        System.out.println("Pilih tabel : 1. region");
        System.out.println("              2. country");
        
        System.out.print("Masukkan pilihan: ");
        
        Scanner input = new Scanner(System.in);
        int pil = input.nextInt();
        
        if (pil==1){
            crudRegion();
        }
        else if(pil==2){
            crudCountry();
        }
        else {
            System.out.println("Tabel yang dipilih tidak ada");
            System.out.println("");
            main(args);
        }
            
        } catch (Exception e) {
            System.out.println("Input harus berupa angka"); System.out.println("");
            main(args);
        }
     
    }
    
    public static void crudRegion(){
        try {
            
        RegionController controller = new RegionController();
        System.out.println("Perintah yang tersedia: 1.Read 2.Insert 3.Update 4.Search 5.Menu");
        Scanner input = new Scanner(System.in);
        Scanner masukan = new Scanner(System.in);
        System.out.print("Masukkan pilihan: ");
        int pil2 = input.nextInt();
        
        if(pil2==1){
            //getAll/ READ data region
            System.out.println("Daftar Region");
            List<Region> daftarRegions = controller.binding();
            for (Region region : daftarRegions){
                System.out.println("id: " + region.getId()
                + ", name: " + region.getName());
            }
            crudRegion();
        }
        
        else if(pil2==2){
            //INSERT dat
            System.out.print("Masukkan nama region: ");
            String nama = masukan.nextLine();
            System.out.println(controller.save("", nama));
            crudRegion();
        } 
        
        else if(pil2==3){
            System.out.println("Daftar Region");
            List<Region> daftarRegions = controller.binding();
            for (Region region : daftarRegions){
                System.out.println("id: " + region.getId()
                + ", name: " + region.getName());
            }
            System.out.print("Masukkan id region: ");
            int id = input.nextInt();
            System.out.print("Masukkan name update: ");
            String name = masukan.nextLine();
            
            System.out.println(controller.updating(id, name));
            crudRegion();
        }
        
        else if(pil2 == 4){
            System.out.print("Masukkan nama region yang dicari: ");
            String name = masukan.nextLine();
            System.out.println("Daftar Region");
            List<Region> daftarRegions = controller.searching(name);
            for (Region region : daftarRegions){
                System.out.println("id: " + region.getId()
                + ", name: " + region.getName());
            }
            crudRegion();
        }
        
        else if(pil2 == 5){
            String[] args = null;
            main(args);
        }
        else
                System.out.println("Pilihan tidak ada");
            
            
        } catch (Exception e) {
            
        }
        
    }
    
    public static void crudCountry(){
        try {
           CountryController controller2 = new CountryController();
           System.out.println("Perintah yang tersedia: 1.Read 2.Insert 3.Update 4.Search 5.Delete 6.Menu");
           
           Scanner input = new Scanner(System.in);
           Scanner masukan = new Scanner(System.in);
           System.out.print("Masukkan pilihan: ");
           int pil2 = input.nextInt();
           
           if(pil2==1){
               //getAll/ READ data country
               System.out.println("Daftar Country");
               List<Country> daftarCountries = controller2.binding();
               for(Country country : daftarCountries){
               System.out.println("id: " + country.getId()
               + ", name: " + country.getName() + ", region: " + country.getRegion());
              }
              crudCountry();
           }
           
           else if(pil2==2){
              //INSERT data
              System.out.print("Masukkan id country: ");
              String kode = masukan.nextLine();
              System.out.print("Masukkan nama country: ");
              String ncountry = masukan.nextLine();
              System.out.println("Pilihan region: 1.Asia 2.Eropa 3.Australia 4.Amerika 5.New Zeland ");
              System.out.print("masukkan region(angka): ");
              int angka1 = input.nextInt();
              if(angka1<6 & angka1>0){
                 System.out.println( controller2.save(kode,ncountry,angka1));
                 crudCountry(); 
              }
              else
                   System.out.println("region tidak ada!");
                   crudCountry();
             
           }
           
           else if(pil2==3){
              //UPDATE
              crudCountry();
           }
           
           else if(pil2==4){
              //SEARCH
              System.out.print("Masukkan nama country yang dicari: ");
              String name = masukan.nextLine();
              System.out.println("Daftar Country");
              List<Country> daftarCountries = controller2.searching(name);
              for (Country country : daftarCountries){
              System.out.println("id: " + country.getId()
               + ", name: " + country.getName() + ", region: " + country.getRegion());
              }
              crudCountry();
            }
           
           
           
           else if(pil2==5){
              //DELETE
              System.out.print("Masukkan id country yang ingin dihapus: ");
              String kode2 = masukan.nextLine();
              System.out.println(controller2.delete(kode2));
              crudCountry(); 
           }
           
           else if(pil2==6){
               String[] args = null;
               main(args);
               System.out.println("");
           }
           
           else 
                System.out.println("Plihan tidak ada");
            
        } catch (Exception e) {
            System.out.println("Input hanya berupa angka");
            crudCountry();
        }
    }
            
    
}

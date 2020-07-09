/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author ASUS
 */
public class RegionController {
    
    private RegionDAO rdao;
    
    public  RegionController(){
        this.rdao = new RegionDAO();
        
    }
    
//    ini memanggil fungsi get all data regions from dao
//     return regions
    
    public List<Region> binding(){
        List<Region> regions = new ArrayList<>();
        regions= this.rdao.getRegions();
        return regions;
//        return this.rdao.getRegions()
    }
    
    public String save(String id, String name){
        String result = "Simpan data gagal";
        
//        int idRegion = Integer.parseInt(id);
//        Region region = new Region(idRegion, name);
        Region region = new Region(name);
        if(this.rdao.insert(region)) result = "Simpan data berhasil";
      
        return result;
    }
    
    public List<Region> searching(String name){
        List<Region> regionName = new ArrayList<>();
        regionName = this.rdao.getRegionByName(name);
        return regionName;
    }
    

    public String updating(int id, String name) {
         String result = "Update data gagal";
        
//        int idRegion = Integer.parseInt(id);
//        Region region = new Region(idRegion, name);
        Region region = new Region(id, name);
        if(this.rdao.update(region)) result = "Update data berhasil";
      
        return result;
    }
    
}

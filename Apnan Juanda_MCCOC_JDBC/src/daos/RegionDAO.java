/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import Tools.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author ASUS
 */
public class RegionDAO {
    
    private Connection connection = null;
    
    public RegionDAO(){
        this.connection = new Koneksi().getConnection();
    }
    
    /*ini merupakan suatu fungsi untuk mengambil data semua region yang ada di database
    return semua data dari region list<Region>
    */
    
    public List<Region> getRegions(){
        List<Region>  regions = new ArrayList<>();
        String strSelect ="SELECT*FROM region;";
        try {
            
            PreparedStatement statement = connection.prepareStatement(strSelect);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
//                region.setId(resultSet.getInt(1));
//                region.setName(resultSet.getString(2));
                regions.add(region);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
    
    public boolean insert(Region region){
        boolean result=false;
        PreparedStatement statement = null;
        String query = "INSERT INTO region(id, name) VALUES (?, ?);";
        try {
           statement = connection.prepareStatement(query);
           statement.setInt(1, region.getId());
           statement.setString(2, region.getName());
           statement.executeUpdate();
           result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
            
    }
    
    //method untuk SEARCH
    public List<Region> getRegionByName(String name){
        List<Region> regionName = new ArrayList<>();
        String strSearch = "SELECT*FROM region WHERE name like ?;";
        
        try {
            
            PreparedStatement statement = connection.prepareStatement(strSearch);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
                regionName.add(region);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      return  regionName;
    }
    
    public boolean update(Region region) {
         boolean result=false;
        PreparedStatement statement = null;
        String strUpdate = "UPDATE region SET name=? WHERE id=?";
        try {
           statement = connection.prepareStatement(strUpdate);
           statement.setString(1, region.getName());
           statement.setInt(2, region.getId());
           statement.execute();
           result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
    
    
}

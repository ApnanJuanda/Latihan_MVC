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
import models.Country;

/**
 *
 * @author ASUS
 */
public class CountryDAO {
    private Connection connection = null;
    
    //ini pembuatan constructor untuk menguhubungkan dengan database
    public CountryDAO(){
        this.connection = new Koneksi().getConnection();
    }
    
//    public List<Country> getCountry(){
//        List<Country>  countries = new ArrayList<>();
//        String strSelect = "SELECT * FROM country;";
//        try {
//            
//            PreparedStatement statement = connection.prepareStatement(strSelect);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Country country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
//                countries.add(country);
//                
//            }
//                        
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//       return countries;
//    }
    
    //method untuk READ
    public List<Country> getCountry(){
        List<Country> countries = new ArrayList<>();
        String strSelect = "SELECT * FROM country;";
        
        try {
            
            PreparedStatement statement = connection.prepareStatement(strSelect);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                countries.add(country);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       return countries;
       
    }
    
    //method untuk INSERT
//    public boolean insert(Country country){
//        boolean result = false;
//        String strInsert = "INSERT INTO country(id, name, region) VALUES (?, ?, ?);";
//        
//        try {
//            
//            PreparedStatement statement = connection.prepareStatement(strInsert);
//            statement.setString(1, country.getId());
//            statement.setString(2, country.getName());
//            statement.setInt(3, country.getRegion());
//            statement.executeUpdate();
//            result = true;
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = false;
//        }
//      return result;
//    }
    public boolean insert(Country country){
        boolean result = false;
        String strInsert = "INSERT INTO country(id, name, region) VALUES (?, ?, ?);";
        try {
            
            PreparedStatement statement = connection.prepareStatement(strInsert);
            statement.setString(1, country.getId());
            statement.setString(2, country.getName());
            statement.setInt(3, country.getRegion());
            statement.executeUpdate();
            result = true;
            
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
       return  result;
            
    }
    
    //mebuat method untuk DELETE
    public boolean delete(String id){
        boolean result = false;
        String strDelete = "DELETE FROM country WHERE id=?;";
        try {
            
            PreparedStatement statement = connection.prepareStatement(strDelete);
            statement.setString(1, id);
            statement.execute();
            result = true;
            
            
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
       return result;
    }
    
    //method untuk SEARCH
    public List<Country> getCountryByName(String name){
        List<Country> countryName = new ArrayList<>();
        String strSearch = "SELECT*FROM country WHERE name like ?;";
        
        try {
            
            PreparedStatement statement = connection.prepareStatement(strSearch);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                countryName.add(country);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      return  countryName;
    }
    
    
    
}

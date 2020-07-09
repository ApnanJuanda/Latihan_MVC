/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAOInterface.IDAOMahasiswa;
import Helper.Koneksi;
import Model.Mahasiswa;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DAOMahasiswa implements IDAOMahasiswa{
    public DAOMahasiswa(){
        con = Koneksi.getConnection();
        
    }

    @Override
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> lstMhs = null;
        try {
            lstMhs = new ArrayList<Mahasiswa>();
            Statement st;
            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next()){
                Mahasiswa mhs=new Mahasiswa();
                mhs.setId(rs.getInt("id"));
                mhs.setNim(rs.getString("nim"));
                mhs.setNama(rs.getString("nama"));
                mhs.setJk(rs.getString("jk"));
                mhs.setAlamat(rs.getString("alamat"));
                lstMhs.add(mhs);
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lstMhs;
    }

    @Override
    public boolean insert(Mahasiswa b) {
        boolean result = true;
        PreparedStatement statement = null;
        try {
            
            statement = (PreparedStatement) con.prepareStatement(strInsert);
            statement.setInt(1, b.getId());
            statement.setString(2, b.getNim());
            statement.setString(3, b.getNama());
            statement.setString(4, b.getJk());
            statement.setString(5, b.getAlamat());
            statement.execute();
            
        } catch (SQLException e) {
           System.out.println("gagal input");
           result = false;
        }
       finally{
            try {
                statement.close(); //error di awal-awal
            } catch (SQLException ex) {
                System.out.println("gagal input"); //gagal input ditengah-tengah koneksi ke server putus
                result = false;
            }
        }
        return result;
    }

    @Override
    public void update(Mahasiswa b) {
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strUpdate);
            statement.setString(1, b.getNim());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getJk());
            statement.setString(4, b.getAlamat());
            statement.setInt(5, b.getId());
            statement.execute();
            
        } catch (SQLException e) {
           System.out.println("gagal update");
        }
       finally{
            try {
                statement.close(); //error di awal-awal
            } catch (SQLException ex) {
                System.out.println("gagal update"); //gagal input ditengah-tengah koneksi ke server putus
            }
        }
    }
    
     @Override
    public void delete(int id) {
       PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) con.prepareStatement(strDelete);
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException e) {
           System.out.println("gagal delete");
        }
       finally{
            try {
                statement.close(); //error di awal-awal
            } catch (SQLException ex) {
                System.out.println("gagal delete"); //gagal input ditengah-tengah koneksi ke server putus
            }
        }
    }
    
    @Override
    public List<Mahasiswa> getAllByName(String nama) {
        List<Mahasiswa> lstMhs = null;
        try {
            lstMhs = new ArrayList<Mahasiswa>();
            PreparedStatement st= (PreparedStatement) con.prepareStatement(strSearch);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Mahasiswa mhs=new Mahasiswa();
                mhs.setId(rs.getInt("id"));
                mhs.setNim(rs.getString("nim"));
                mhs.setNama(rs.getString("nama"));
                mhs.setJk(rs.getString("jk"));
                mhs.setAlamat(rs.getString("alamat"));
                lstMhs.add(mhs);
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lstMhs;
    }
    
    Connection con;
    
    //SQL Query
    String strRead = "SELECT*FROM tblmahasiswa ORDER BY id ASC;";
    String strInsert = "INSERT INTO tblmahasiswa (id,nim,nama,jk,alamat) VALUES (?,?,?,?,?);";
    String strUpdate = "UPDATE tblmahasiswa set nim=?, nama=?, jk=?, alamat=? WHERE id=?;";
    String strDelete = "DELETE FROM tblmahasiswa WHERE id=?;";
    String strSearch = "SELECT*FROM tblmahasiswa WHERE nama like ?;";
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOInterface;

import Model.Mahasiswa;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IDAOMahasiswa {
    //read data
    public List<Mahasiswa> getAll(); //getAll() itu nama method jenis function karena di implementsnya ada return
    
    //insert data
    public boolean insert(Mahasiswa b);
    
    //update data
    public void update(Mahasiswa b);
    
    //menghapus data
    public void delete(int id);
    
    //search data
    public List<Mahasiswa> getAllByName(String nama);
    
    
}

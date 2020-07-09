/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOMahasiswa;
import DAOInterface.IDAOMahasiswa;
import Model.Mahasiswa;
import Model.TabelModelMahasiswa;
import View.FormMahasiswa;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ControllerMahasiswa {
    public ControllerMahasiswa(FormMahasiswa frmMahasiswa){
        this.frmMahasiswa = frmMahasiswa;
        iMahasiswa = new DAOMahasiswa();
        
    }
    public void isiTable(){
       lstMhs = iMahasiswa.getAll();
       TabelModelMahasiswa tabelMhs = new TabelModelMahasiswa(lstMhs);
       frmMahasiswa.getTabelData().setModel(tabelMhs);
    }
    
    public void insert(){
        Mahasiswa b = new Mahasiswa();
        b.setId(Integer.parseInt(frmMahasiswa.gettxtID().getText()));
        b.setNim(frmMahasiswa.gettxtNim().getText());
        b.setNama(frmMahasiswa.gettxtNama().getText());
        b.setJk(frmMahasiswa.getJkel().getSelectedItem().toString());
        b.setAlamat(frmMahasiswa.gettxtAlamat().getText());
        boolean result = iMahasiswa.insert(b);
        if (result){
        JOptionPane.showMessageDialog(null, "Input Berhasil");}
        else{
            JOptionPane.showMessageDialog(null, "Gagal/Data duplikat");
        }
        
    }
    
    public void reset(){
        if(!frmMahasiswa.gettxtID().isEnabled()){
        frmMahasiswa.gettxtID().setEnabled(true);
        frmMahasiswa.gettxtID().setText("");
        frmMahasiswa.gettxtNim().setText("");
        frmMahasiswa.gettxtNama().setText("");
        frmMahasiswa.getJkel().setSelectedItem("L");
        frmMahasiswa.gettxtAlamat().setText("");}
    }
    
    public void isiField(int row){
        frmMahasiswa.gettxtID().setEnabled(false);
        frmMahasiswa.gettxtID().setText(toString(row));
        frmMahasiswa.gettxtNim().setText(lstMhs.get(row).getNim());
        frmMahasiswa.gettxtNama().setText(lstMhs.get(row).getNama());
        frmMahasiswa.getJkel().setSelectedItem(lstMhs.get(row).getJk());
        frmMahasiswa.gettxtAlamat().setText(lstMhs.get(row).getAlamat());
    }
    
    public void update(){
        Mahasiswa b = new Mahasiswa();
        b.setNim(frmMahasiswa.gettxtNim().getText());
        b.setNama(frmMahasiswa.gettxtNama().getText());
        b.setJk(frmMahasiswa.getJkel().getSelectedItem().toString());
        b.setAlamat(frmMahasiswa.gettxtAlamat().getText());
        b.setId(Integer.parseInt(frmMahasiswa.gettxtID().getText()));
        iMahasiswa.update(b);
        JOptionPane.showMessageDialog(null, "Update Berhasil"); 
    }
    
    public void delete(){
        iMahasiswa.delete(Integer.parseInt(frmMahasiswa.gettxtID().getText()));
        JOptionPane.showMessageDialog(null, "Delete Berhasil"); 
    }
    
    public void cari(){
        lstMhs=iMahasiswa.getAllByName(frmMahasiswa.gettxtCariNama().getText());
        TabelModelMahasiswa tabelMhs = new TabelModelMahasiswa(lstMhs);
        frmMahasiswa.getTabelData().setModel(tabelMhs);
    }
    
  
    private String toString(int row) {
        int example = lstMhs.get(row).getId();
        String example2=Integer.toString(example);
        return example2;
    }
    
    FormMahasiswa frmMahasiswa;
    IDAOMahasiswa iMahasiswa;
    List<Mahasiswa> lstMhs;

    
    
}

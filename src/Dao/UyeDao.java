
package Dao;

import Entity.Kayit;
import Entity.Uye;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.ConnectionManager;

public class UyeDao implements DAO<Uye> {
    ConnectionManager cm = ConnectionManager.getInstance();
    

    
    @Override
    public void create(Uye o) {
          try {
             try (Connection con = cm.getConnection()) {
                 PreparedStatement pst = con.prepareStatement("insert into uye(uye_adsoyad,uye_kayittarihi,uye_sure,uye_telno,uye_ucret) values(?,?,?,?,?)");
                 pst.setString(1, o.getUye_adsoyad());
                 pst.setString(2, o.getUye_kayittarihi());
                 pst.setString(3, o.getUye_sure());
                 pst.setString(4, o.getUye_telno());
                 pst.setString(5, o.getUye_ucret());

                 
                 pst.executeUpdate();
             }
        } catch (SQLException ex) {
            System.err.println("Dao.UyeDao.create() error");
        }
    }

    @Override
    public void update(Uye o) {
        try {
           try (Connection con = cm.getConnection()) {
                PreparedStatement pst = con.prepareStatement("update uye set uye_adsoyad =?,uye_kayittarihi=?,uye_sure=?,uye_telno =?,uye_ucret =? where uye_id=?");
               pst.setString(1, o.getUye_adsoyad());
               pst.setString(2, o.getUye_kayittarihi());
               pst.setString(3, o.getUye_sure());
               pst.setString(4, o.getUye_telno());
               pst.setString(5, o.getUye_ucret());
               pst.setLong(6, o.getUye_id());
               pst.executeUpdate();
           }
        } catch (SQLException ex) {
            System.err.println("Dao.UyeDao.update() error");
        }
    }

    @Override
    public ArrayList<Uye> list() {
        ArrayList uyeList = new ArrayList();
        
        @SuppressWarnings("UnusedAssignment")
        Uye tmp = null;
        try {
            try (Connection con = cm.getConnection()) {
                PreparedStatement pst = con.prepareStatement("select * from uye");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    tmp = new Uye();
                    tmp.setUye_id(rs.getLong("uye_id"));
                    tmp.setUye_adsoyad(rs.getString("adsoyad"));
                    tmp.setUye_kayittarihi(rs.getString("kayittarihi"));
                    tmp.setUye_sure(rs.getString("sure"));
                    tmp.setUye_telno(rs.getString("telno"));
                    tmp.setUye_ucret(rs.getString("ucret"));
                    uyeList.add(tmp);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Dao.uyeDao.list() error");
        }
        return uyeList;
        
    }

    @Override
    public List<Uye> pagedList(int page, int lic) {
       throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Uye o) {
         try {
            Connection con = cm.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from uye where uye_id=?");
            pst.setLong(1, o.getUye_id());
            pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.err.println("Dao.uyeDao.delete() error");
        }
    }

    @Override
    public Uye detail(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet listResultset() {
        ResultSet rs = null;
        try {
            Connection con = cm.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from uye");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            System.err.println("Dao.UyeDao.listResultset() error");
        }
        return rs;
    }
    
        
}

    
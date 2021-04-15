package Dao;

import Entity.Kayit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.ConnectionManager;

public class KayitDao implements DAO<Kayit> {
    ConnectionManager cm = ConnectionManager.getInstance();
    private UyeDao uyeDao;
    
    
    public UyeDao getUyeDao() {
        if(this.uyeDao==null)
            this.uyeDao = new UyeDao();
        return uyeDao;
    }

    @Override
    public void create(Kayit o) {
        try {
             try (Connection con = cm.getConnection()) {
                 PreparedStatement pst = con.prepareStatement("insert into kayit(kayit_bransadi,kayit_branssaati,kayit_bransucreti) values(?,?,?)");
                 pst.setString(1, o.getKayit_bransadi());
                 pst.setString(2, o.getKayit_branssaati());
                 pst.setString(3, o.getKayit_bransucreti());
                 
                 
                 pst.executeUpdate();
             }
        } catch (SQLException ex) {
            System.err.println("Dao.KayitDao.create() error");
        }
    }

    @Override
    public void update(Kayit o) {
        try {
           try (Connection con = cm.getConnection()) {
               PreparedStatement pst = con.prepareStatement("update kayit set kayit_bransadi=?,kayit_branssaati=?,kayit_bransucreti =? where kayit_id=?");
               pst.setString(1, o.getKayit_bransadi());
               pst.setString(2, o.getKayit_branssaati());
               pst.setString(3, o.getKayit_bransucreti());
               pst.setLong(4, o.getKayit_id());
               pst.executeUpdate();
           }
        } catch (SQLException ex) {
            System.err.println("Dao.KayitDao.update() error");
        }
    }

    @Override
    public ArrayList<Kayit> list() {
      ArrayList kayitList = new ArrayList();
        
        @SuppressWarnings("UnusedAssignment")
        Kayit tmp = null;
        try {
            try (Connection con = cm.getConnection()) {
                PreparedStatement pst = con.prepareStatement("select * from kayit");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    tmp = new Kayit();
                    tmp.setKayit_id(rs.getLong("kayit_id"));
                    tmp.setKayit_bransadi(rs.getString("bransadi"));
                    tmp.setKayit_branssaati(rs.getString("branssaati"));
                    tmp.setKayit_bransucreti(rs.getString("bransucreti"));
                    kayitList.add(tmp);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Dao.kayitDao.list() error");
        }
        return kayitList;
    }

    @Override
    public List<Kayit> pagedList(int page, int lic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Kayit o) {
        try {
            Connection con = cm.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from kayit where kayit_id=?");
            pst.setLong(1, o.getKayit_id());
            pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.err.println("Dao.kayitDao.delete() error");
        }
    }

    @Override
    public Kayit detail(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet listResultset() {
        ResultSet rs = null;
        try {
            Connection con = cm.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from kayit");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            System.err.println("Dao.KayitDao.listResultset() error");
        }
        return rs;
    }

}
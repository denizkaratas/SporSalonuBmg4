package Dao;

import Entity.Calisan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.ConnectionManager;

public class CalisanDao implements DAO<Calisan> {

    ConnectionManager cm = ConnectionManager.getInstance();

    @Override
    public void create(Calisan o) {
        try {
            try (Connection con = cm.getConnection()) {
                PreparedStatement pst = con.prepareStatement("insert into calisan(calisan_adsoyad,calisan_brans,calisan_ucret) values(?,?,?)");
                pst.setString(1, o.getCalisan_adsoyad());
                pst.setString(2, o.getCalisan_brans());
                pst.setString(3, o.getCalisan_ucret());

                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println("Dao.CalisanDao.create() error");
        }
    }

    @Override
    public void update(Calisan o) {
        try {
            try (Connection con = cm.getConnection()) {
                PreparedStatement pst = con.prepareStatement("update calisan set calisan_adsoyad=?,calisan_brans=?,calisan_ucret =? where calisan_id=?");
                pst.setString(1, o.getCalisan_adsoyad());
                pst.setString(2, o.getCalisan_brans());
                pst.setString(3, o.getCalisan_ucret());
                pst.setLong(4, o.getCalisan_id());
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println("Dao.CalisanDao.update() error");
        }
    }

    @Override
    public ArrayList<Calisan> list() {
        ArrayList calisanList = new ArrayList();

        @SuppressWarnings("UnusedAssignment")
        Calisan tmp = null;
        try {
            try (Connection con = cm.getConnection()) {
                PreparedStatement pst = con.prepareStatement("select * from calisan");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    tmp = new Calisan();
                    tmp.setCalisan_id(rs.getLong("calisan_Id"));
                    tmp.setCalisan_adsoyad(rs.getString("adsoyad"));
                    tmp.setCalisan_brans(rs.getString("brans"));
                    tmp.setCalisan_ucret(rs.getString("ucret"));

                    calisanList.add(tmp);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Dao.calisanDao.list() error");
        }
        return calisanList;
    }

    @Override
    public List<Calisan> pagedList(int page, int lic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet listResultset() {
        ResultSet rs = null;
        try {
            Connection con = cm.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from calisan");
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            System.err.println("Dao.CalisanDao.listResultset() error");
        }
        return rs;
    }

    @Override
    public void delete(Calisan o) {
        try {
            Connection con = cm.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from calisan where calisan_id=?");
            pst.setLong(1, o.getCalisan_id());
            pst.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            System.err.println("Dao.calisanDao.delete() error");
        }
    }

    @Override
    public Calisan detail(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}

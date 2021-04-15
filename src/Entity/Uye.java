package Entity;


import java.util.Date;
import java.util.Objects;



public class Uye {
    private Long uye_id;
    private String uye_adsoyad;
    private String uye_kayittarihi;
    private String uye_sure;
    private String uye_telno;
    private String uye_ucret;

    

    public Uye() {
    }
    
    public Uye(Long uye_id) {
        this.uye_id = uye_id;
    }
    
    public Long getUye_id() {
        return uye_id;
    }

    public void setUye_id(Long uye_id) {
        this.uye_id = uye_id;
    }

    public String getUye_adsoyad() {
        return uye_adsoyad;
    }

    public void setUye_adsoyad(String uye_adsoyad) {
        this.uye_adsoyad = uye_adsoyad;
    }

    public String getUye_kayittarihi() {
        return uye_kayittarihi;
    }

    public void setUye_kayittarihi(String uye_kayittarihi) {
        this.uye_kayittarihi = uye_kayittarihi;
    }

    public String getUye_sure() {
        return uye_sure;
    }

    public void setUye_sure(String uye_sure) {
        this.uye_sure = uye_sure;
    }

    public String getUye_telno() {
        return uye_telno;
    }

    public void setUye_telno(String uye_telno) {
        this.uye_telno = uye_telno;
    }

    public String getUye_ucret() {
        return uye_ucret;
    }

    public void setUye_ucret(String uye_ucret) {
        this.uye_ucret = uye_ucret;
    }

   
    


   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.uye_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Uye other = (Uye) obj;
        if (!Objects.equals(this.uye_id, other.uye_id)) {
            return false;
        }
        return true;
    }

    
    
    
}

    


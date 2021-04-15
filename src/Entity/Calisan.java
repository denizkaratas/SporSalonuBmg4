package Entity;





import java.util.Objects;



public class Calisan {
    private Long calisan_id;
    private String calisan_adsoyad;
    private String calisan_ucret;
    private String calisan_brans;
  

    public Calisan() {
    }

    public Calisan(Long calisan_id) {
        this.calisan_id = calisan_id;
    }
    
    public Long getCalisan_id() {
        return calisan_id;
    }

    public void setCalisan_id(Long calisan_id) {
        this.calisan_id = calisan_id;
    }

    public String getCalisan_adsoyad() {
        return calisan_adsoyad;
    }

    public void setCalisan_adsoyad(String calisan_adsoyad) {
        this.calisan_adsoyad = calisan_adsoyad;
    }

    public String getCalisan_ucret() {
        return calisan_ucret;
    }

    public void setCalisan_ucret(String calisan_ucret) {
        this.calisan_ucret = calisan_ucret;
    }

    public String getCalisan_brans() {
        return calisan_brans;
    }

    public void setCalisan_brans(String calisan_brans) {
        this.calisan_brans = calisan_brans;
    }

    

   

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.calisan_id);
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
        final Calisan other = (Calisan) obj;
        if (!Objects.equals(this.calisan_id, other.calisan_id)) {
            return false;
        }
        return true;
    }

    
    
    
}

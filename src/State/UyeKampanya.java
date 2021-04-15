/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author DENİZ
 */
public class UyeKampanya implements Kampanya {

    @Override
    public String Kazanc() {
        return "3 Ay Üyelik 20 TL İndirimli";
                
    }
     public String Kazanci() {
        return "6 Ay Üyelik 50 TL İndirimli";
               
    }
    public String Kazancim() {
        return "12 Ay Üyelik 100 TL İndirimli";
               
    }
    public String Bilgi() {
        return "1 Aylık Üyelik 100 TL'dir";
    
}
}
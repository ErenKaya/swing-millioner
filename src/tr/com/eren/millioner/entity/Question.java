package tr.com.eren.millioner.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long soruId;
    private String soru;
    private String sec1;
    private String sec2;
    private String sec3;
    private String sec4;
    private int cevap;
    private int soruQuality;
   

    public Question(long soruId, String soru, String sec1, String sec2, String sec3, String sec4, int cevap, int soruQuality) {
        this.soruId = soruId;
        this.soru = soru;
        this.sec1 = sec1;
        this.sec2 = sec2;
        this.sec3 = sec3;
        this.sec4 = sec4;
        this.cevap = cevap;
        this.soruQuality = soruQuality;
    }

    public Question() {
    }

    public long getSoruId() {
        return soruId;
    }

    public void setSoruId(long soruId) {
        this.soruId = soruId;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getSec1() {
        return sec1;
    }

    public void setSec1(String sec1) {
        this.sec1 = sec1;
    }

    public String getSec2() {
        return sec2;
    }

    public void setSec2(String sec2) {
        this.sec2 = sec2;
    }

    public String getSec3() {
        return sec3;
    }

    public void setSec3(String sec3) {
        this.sec3 = sec3;
    }

    public String getSec4() {
        return sec4;
    }

    public void setSec4(String sec4) {
        this.sec4 = sec4;
    }

    public int getCevap() {
        return cevap;
    }

    public void setCevap(int cevap) {
        this.cevap = cevap;
    }

    public int getSoruQuality() {
        return soruQuality;
    }

    public void setSoruQuality(int soruQuality) {
        this.soruQuality = soruQuality;
    }

  

   

    

}

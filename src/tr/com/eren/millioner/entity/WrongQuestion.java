package tr.com.eren.millioner.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class WrongQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hataliSoruId;
    private String hataliSoruSenderEmail;
    private String hataliSoruCorrecterName;
    private String hataliSoruComment;
    private long currentSoruId;
    private boolean isActive;

    public WrongQuestion(long hataliSoruId, String hataliSoruSenderEmail, String hataliSoruCorrecterName, String hataliSoruComment, long currentSoruId, boolean isActive) {
        this.hataliSoruId = hataliSoruId;
        this.hataliSoruSenderEmail = hataliSoruSenderEmail;
        this.hataliSoruCorrecterName = hataliSoruCorrecterName;
        this.hataliSoruComment = hataliSoruComment;
        this.currentSoruId = currentSoruId;
        this.isActive = isActive;
    }

    public WrongQuestion() {
    }

    public long getHataliSoruId() {
        return hataliSoruId;
    }

    public void setHataliSoruId(long hataliSoruId) {
        this.hataliSoruId = hataliSoruId;
    }

    public String getHataliSoruSenderEmail() {
        return hataliSoruSenderEmail;
    }

    public void setHataliSoruSenderEmail(String hataliSoruSenderEmail) {
        this.hataliSoruSenderEmail = hataliSoruSenderEmail;
    }

    public String getHataliSoruCorrecterName() {
        return hataliSoruCorrecterName;
    }

    public void setHataliSoruCorrecterName(String hataliSoruCorrecterName) {
        this.hataliSoruCorrecterName = hataliSoruCorrecterName;
    }

    public String getHataliSoruComment() {
        return hataliSoruComment;
    }

    public void setHataliSoruComment(String hataliSoruComment) {
        this.hataliSoruComment = hataliSoruComment;
    }

    public long getCurrentSoruId() {
        return currentSoruId;
    }

    public void setCurrentSoruId(long currentSoruId) {
        this.currentSoruId = currentSoruId;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}

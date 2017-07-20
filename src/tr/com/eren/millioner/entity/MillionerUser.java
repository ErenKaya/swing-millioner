package tr.com.eren.millioner.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MillionerUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long millionerUserId;
    private String millionerUsername;
    private int totalSalary;
    private long currentQuestionId;

    public MillionerUser() {
    }

    public MillionerUser(long millionerUserId, String millionerUsername,
            int totalSalary, long currentQuestionId) {
        this.millionerUserId = millionerUserId;
        this.millionerUsername = millionerUsername;
        this.totalSalary = totalSalary;
        this.currentQuestionId = currentQuestionId;
    }

    public long getMillionerUserId() {
        return millionerUserId;
    }

    public void setMillionerUserId(long millionerUserId) {
        this.millionerUserId = millionerUserId;
    }

    public String getMillionerUsername() {
        return millionerUsername;
    }

    public void setMillionerUsername(String millionerUsername) {
        this.millionerUsername = millionerUsername;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public long getCurrentQuestionId() {
        return currentQuestionId;
    }

    public void setCurrentQuestionId(long currentQuestionId) {
        this.currentQuestionId = currentQuestionId;
    }

}

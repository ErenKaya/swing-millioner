/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.eren.millioner.forms;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import tr.com.eren.millioner.entity.MillionerUser;
import tr.com.eren.millioner.handlers.Controller;
import tr.com.eren.millioner.entity.Question;
import tr.com.eren.millioner.repository.MillionerUserRepository;
import tr.com.eren.millioner.repository.QuestionRepository;

/**
 *
 * @author j_erenk
 */
public final class UserInterface extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     *
     * @param username
     */
    Controller cont;
    List<Question> questionList;
    QuestionRepository sorularRepository;
    Question soru;
    MillionerUser millionerUser;
    int questionNumber = 0;
    long currentId;
    List<JLabel> moneyList;
    List<JButton> buttonList;
    List<Long> queCheckList = new ArrayList<>();
    List<Integer> notUsebleRandomValue = new ArrayList<>();
    Random rnd = new Random();
    boolean doubleChoiceSelect;
    int selectedButtonCount = 1;
    long checkedNumber = 0;
    String username;

    public UserInterface(MillionerUser millionerUser) {
        this.setTitle("Millioner");
        this.millionerUser=millionerUser;
        cont = new Controller();
        sorularRepository = new QuestionRepository();
        questionList = sorularRepository.list();
        moneyList = new ArrayList<>();
        buttonList = new ArrayList<>();
        initComponents();
        getIcons();
        newQuestion();
        this.lblKullaniciAdi.setText("Milyoner'e Hoşgeldin " + millionerUser.getMillionerUsername());
        moneyList.add(label100);
        moneyList.add(label200);
        moneyList.add(label500);
        moneyList.add(label1000);
        moneyList.add(label2000);
        buttonList.add(btnSec1);
        buttonList.add(btnSec2);
        buttonList.add(btnSec3);
        buttonList.add(btnSec4);

    }

    public UserInterface() {

    }

    public void setSoruLabels() {

        lblSoru.setText("<html>" + questionNumber + ") " + soru.getSoru() + "</html>");
        btnSec1.setText(soru.getSec1());
        btnSec2.setText(soru.getSec2());
        btnSec3.setText(soru.getSec3());
        btnSec4.setText(soru.getSec4());
    }

    public void setEnableButtons() {
        for (JButton i : buttonList) {
            i.setEnabled(true);
        }
    }

    public void newQuestion() {
        sorularRepository = new QuestionRepository();
        try {
            if (questionNumber == 5) {
                JOptionPane.showMessageDialog(this, "Won");
                System.exit(1);
            } else {

                checkedNumber = rnd.nextInt(questionList.size());

                while (queCheckList.contains(checkedNumber)) {
                    checkedNumber = rnd.nextInt(questionList.size());
                }
                ++questionNumber;
                getQuestion(checkedNumber);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getQuestion(long checkedNumber) {

        soru = questionList.get((int) checkedNumber);
        queCheckList.add(checkedNumber);
        setSoruLabels();
        setEnableButtons();

    }

    public void getResult(int btnNum) {
        MillionerUserRepository millionerUserRepository = new MillionerUserRepository();
        MillionerUser millionerUserLocal = new MillionerUser();
        if (soru.getCevap() == btnNum) {
            moneyList.get(questionNumber - 1).setEnabled(false);
            moneyList.get(questionNumber - 1).setBackground(Color.blue);
            moneyList.get(questionNumber - 1).setOpaque(true);
            millionerUserLocal=millionerUserRepository.find(millionerUser.getMillionerUserId()); 
            millionerUserLocal.setTotalSalary(Integer.parseInt(moneyList.get(questionNumber - 1).getText()));
            millionerUserRepository.update(millionerUserLocal);
            alert("Doğru");

        } else if (doubleChoiceSelect) {
            buttonList.get(btnNum).setEnabled(false);
            if (selectedButtonCount == 2) {
                alert("yanlış");
                doubleChoiceSelect = false;
            }
            selectedButtonCount++;
        } else {
            alert("yanlış");
        }

    }

    public void getIcons() {
//        try{
//        Image img = ImageIO.read(getClass().getResource("E:\\Java/TOFAS INTERN/kimMilyonerOlmakIster/src/millionerDoubleChoice.bmp"));
//        buttonDoubleChoice.setIcon(new ImageIcon(img));
//        }catch(Exception e){
//            e.printStackTrace();
//        }

    }

    public void alert(String msg) {
        JOptionPane.showMessageDialog(null, msg);
        if (JOptionPane.OK_OPTION == 0 && msg == "Doğru") {
            for (JButton button : buttonList) {
                button.setEnabled(true);
            }
            newQuestion();

        } else {
            JOptionPane.showMessageDialog(null, "Oyunu Kaybettiniz");
            System.exit(1);
        }
    }

    public void getFityFifty() {
        int btnRan = rnd.nextInt(3);
        int x = soru.getCevap();
        int sayac = 0;
        while (sayac < 2) {
            while (notUsebleRandomValue.contains(btnRan)) {
                btnRan = rnd.nextInt(3);
            }
            if (x != (btnRan)) {
                buttonList.get(btnRan).setEnabled(false);
                notUsebleRandomValue.add(btnRan);
                sayac++;
            } else {
                btnRan = rnd.nextInt(3);
            }
        }
        this.buttonFiftyFifty.setEnabled(false);
        this.buttonFiftyFifty.setBackground(Color.red);
        this.buttonFiftyFifty.setOpaque(true);
    }

    public void getDoubleChoice(int getDoubleChoiceClick) {
        JOptionPane.showMessageDialog(null, "Çift Cevap Seçildi");
        if (JOptionPane.OK_OPTION == 0) {
            doubleChoiceSelect = true;
            this.buttonDoubleChoice.setEnabled(false);
            this.buttonDoubleChoice.setBackground(Color.red);
            this.buttonDoubleChoice.setOpaque(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label100 = new javax.swing.JLabel();
        label200 = new javax.swing.JLabel();
        label500 = new javax.swing.JLabel();
        label1000 = new javax.swing.JLabel();
        label2000 = new javax.swing.JLabel();
        buttonFiftyFifty = new javax.swing.JButton();
        buttonDoubleChoice = new javax.swing.JButton();
        btnSec1 = new javax.swing.JButton();
        btnSec2 = new javax.swing.JButton();
        btnSec3 = new javax.swing.JButton();
        btnSec4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblKullaniciAdi = new javax.swing.JLabel();
        lblSoru = new javax.swing.JLabel();
        buttonWrong = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Milyoner Ödüller"));
        jPanel1.setName("fOdul"); // NOI18N

        label100.setBackground(new java.awt.Color(204, 204, 204));
        label100.setText("100");
        label100.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label200.setText("200");
        label200.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label500.setText("500");
        label500.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label1000.setText("1000");
        label1000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label2000.setText("2000");
        label2000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonFiftyFifty.setName(""); // NOI18N
        buttonFiftyFifty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiftyFiftyActionPerformed(evt);
            }
        });

        buttonDoubleChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDoubleChoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(label500, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1000, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2000, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addComponent(label200, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonFiftyFifty, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonDoubleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonDoubleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonFiftyFifty, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(label2000, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label1000, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label500, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label200, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label100, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        btnSec1.setName("bSoruSec1"); // NOI18N
        btnSec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSec1ActionPerformed(evt);
            }
        });

        btnSec2.setName("bSoruSec2"); // NOI18N
        btnSec2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                btnSec2InputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        btnSec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSec2ActionPerformed(evt);
            }
        });

        btnSec3.setName("bSoruSec3"); // NOI18N
        btnSec3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSec3ActionPerformed(evt);
            }
        });

        btnSec4.setName("bSoruSec4"); // NOI18N
        btnSec4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSec4ActionPerformed(evt);
            }
        });

        jPanel2.setName("fJoker"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        lblKullaniciAdi.setText("ISIM");

        lblSoru.setText("Soru");

        buttonWrong.setText("Hatalı!");
        buttonWrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWrongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSoru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnSec3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSec1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSec2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(btnSec4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(lblKullaniciAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonWrong, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblKullaniciAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonWrong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoru, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSec2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSec1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnSec4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSec3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        lblSoru.getAccessibleContext().setAccessibleName("labSoru");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSec2ActionPerformed
        getResult(1);

    }//GEN-LAST:event_btnSec2ActionPerformed

    private void btnSec2InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_btnSec2InputMethodTextChanged


    }//GEN-LAST:event_btnSec2InputMethodTextChanged

    private void btnSec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSec1ActionPerformed

        getResult(0);

    }//GEN-LAST:event_btnSec1ActionPerformed

    private void btnSec3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSec3ActionPerformed

        getResult(2);
    }//GEN-LAST:event_btnSec3ActionPerformed

    private void btnSec4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSec4ActionPerformed

        getResult(3);
    }//GEN-LAST:event_btnSec4ActionPerformed

    private void buttonFiftyFiftyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiftyFiftyActionPerformed
        getFityFifty();
    }//GEN-LAST:event_buttonFiftyFiftyActionPerformed

    private void buttonDoubleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDoubleChoiceActionPerformed
        getDoubleChoice(1);
    }//GEN-LAST:event_buttonDoubleChoiceActionPerformed

    private void buttonWrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWrongActionPerformed
        WrongQuestionForm wrongQuestionForm = new WrongQuestionForm(checkedNumber);
        this.setVisible(false);
        wrongQuestionForm.setVisible(true);
    }//GEN-LAST:event_buttonWrongActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSec1;
    private javax.swing.JButton btnSec2;
    private javax.swing.JButton btnSec3;
    private javax.swing.JButton btnSec4;
    private javax.swing.JButton buttonDoubleChoice;
    private javax.swing.JButton buttonFiftyFifty;
    private javax.swing.JButton buttonWrong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label100;
    private javax.swing.JLabel label1000;
    private javax.swing.JLabel label200;
    private javax.swing.JLabel label2000;
    private javax.swing.JLabel label500;
    private javax.swing.JLabel lblKullaniciAdi;
    private javax.swing.JLabel lblSoru;
    // End of variables declaration//GEN-END:variables
}

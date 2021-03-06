/**
 * @version 20150429
 * @author Pheng L. Taing
 * @website bit.ly/pixport
 */

package timetablepro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;


public class TimetablePro extends javax.swing.JFrame {
    
    static int MAX_TIMETABLE = 12;
    static Color GLOBAL_BG = new Color(255,204,153);
    static Color TIMER_COLOUR = Color.WHITE;
    static int GAME_TIME_MS = 20_000;
    static int TEST_TIME_MS = 60_000;
    static int BONUS_TIME_MS = 1_000;
    static int MODE_60_SEC = 0, MODE_TIMED = 1, MODE_TIMETABLE = 2, MODE_TEST = 3 ;
    
    GameOrganiser gameOrganiser;   

    
    public TimetablePro() {
        initComponents();
        
        setTitle("Timetable Pro by Pheng Taing");
        gameOrganiser = new GameOrganiser(this, 
                numberLeft, numberRight, jLabelOperation, 
                fp, cp, 
                new JCheckBoxMenuItem[]{jCheckAdd, jCheckSubtract, jCheckMultiply, jCheckDivide},
                jMenuSettings);
        backPanel.setBackground(GLOBAL_BG);
        tabPaneGame.setBackground(GLOBAL_BG);
        numberInput.requestFocus();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((d.width - frameSize.width) / 2, (d.height - frameSize.height) / 2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backPanel = new javax.swing.JPanel();
        jTabbedPane = new javax.swing.JTabbedPane();
        tabPaneGame = new javax.swing.JPanel();
        cp = new timetablepro.ClockPanel();
        fp = new timetablepro.FeedbackPanel();
        numberInput = new timetablepro.JNumberField();
        numberRight = new timetablepro.NumberPanel();
        jLabelOperation = new javax.swing.JLabel();
        numberLeft = new timetablepro.NumberPanel();
        tabPaneScore = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaResult = new javax.swing.JTextArea();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuPlay = new javax.swing.JMenu();
        jMenuItemTimed = new javax.swing.JMenuItem();
        jMenuItemPractise = new javax.swing.JMenuItem();
        jMenuTestTimetable = new javax.swing.JMenuItem();
        jMenuTest60Sec = new javax.swing.JMenuItem();
        jMenuStopGame = new javax.swing.JMenuItem();
        jMenuSettings = new javax.swing.JMenu();
        jCheckAdd = new javax.swing.JCheckBoxMenuItem();
        jCheckSubtract = new javax.swing.JCheckBoxMenuItem();
        jCheckMultiply = new javax.swing.JCheckBoxMenuItem();
        jCheckDivide = new javax.swing.JCheckBoxMenuItem();
        jMenuSetBgColour = new javax.swing.JMenuItem();
        jMenuSetTimerColour = new javax.swing.JMenuItem();
        jMenuGameDuration = new javax.swing.JMenuItem();
        jMenuTestDuration = new javax.swing.JMenuItem();
        jMenuSetTableLimit = new javax.swing.JMenuItem();
        jMenuAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backPanel.setBackground(new java.awt.Color(0, 0, 0));

        jTabbedPane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        tabPaneGame.setBackground(new java.awt.Color(204, 204, 204));

        cp.setMaximumSize(new java.awt.Dimension(200, 200));
        cp.setMinimumSize(new java.awt.Dimension(200, 200));

        numberInput.setColumns(3);
        numberInput.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        numberInput.setForeground(java.awt.Color.black);
        numberInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numberInput.setAutoscrolls(false);
        numberInput.setBorder(null);
        numberInput.setCaretColor(new java.awt.Color(0, 0, 204));
        numberInput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        numberInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fpLayout = new javax.swing.GroupLayout(fp);
        fp.setLayout(fpLayout);
        fpLayout.setHorizontalGroup(
            fpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fpLayout.setVerticalGroup(
            fpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cpLayout = new javax.swing.GroupLayout(cp);
        cp.setLayout(cpLayout);
        cpLayout.setHorizontalGroup(
            cpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(fp, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        cpLayout.setVerticalGroup(
            cpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(fp, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabelOperation.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabelOperation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelOperation.setText("x");
        jLabelOperation.setMaximumSize(new java.awt.Dimension(58, 58));
        jLabelOperation.setMinimumSize(new java.awt.Dimension(58, 58));
        jLabelOperation.setPreferredSize(new java.awt.Dimension(58, 58));

        numberLeft.setPreferredSize(new java.awt.Dimension(100, 50));

        javax.swing.GroupLayout tabPaneGameLayout = new javax.swing.GroupLayout(tabPaneGame);
        tabPaneGame.setLayout(tabPaneGameLayout);
        tabPaneGameLayout.setHorizontalGroup(
            tabPaneGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPaneGameLayout.createSequentialGroup()
                .addGroup(tabPaneGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabPaneGameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(numberLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(numberRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabPaneGameLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabPaneGameLayout.setVerticalGroup(
            tabPaneGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPaneGameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPaneGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabPaneGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(numberRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numberLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Game", tabPaneGame);

        jtaResult.setEditable(false);
        jtaResult.setColumns(20);
        jtaResult.setLineWrap(true);
        jtaResult.setRows(5);
        jtaResult.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jtaResult);

        javax.swing.GroupLayout tabPaneScoreLayout = new javax.swing.GroupLayout(tabPaneScore);
        tabPaneScore.setLayout(tabPaneScoreLayout);
        tabPaneScoreLayout.setHorizontalGroup(
            tabPaneScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );
        tabPaneScoreLayout.setVerticalGroup(
            tabPaneScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Score", tabPaneScore);

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenuPlay.setMnemonic('p');
        jMenuPlay.setText("Play");

        jMenuItemTimed.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTimed.setText("Play a Timed Game");
        jMenuItemTimed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTimedActionPerformed(evt);
            }
        });
        jMenuPlay.add(jMenuItemTimed);

        jMenuItemPractise.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPractise.setText("Practice a Timetable");
        jMenuItemPractise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPractiseActionPerformed(evt);
            }
        });
        jMenuPlay.add(jMenuItemPractise);

        jMenuTestTimetable.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        jMenuTestTimetable.setText("Test a Timetable");
        jMenuTestTimetable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTestTimetableActionPerformed(evt);
            }
        });
        jMenuPlay.add(jMenuTestTimetable);

        jMenuTest60Sec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuTest60Sec.setText("Test 60 Seconds");
        jMenuTest60Sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTest60SecActionPerformed(evt);
            }
        });
        jMenuPlay.add(jMenuTest60Sec);

        jMenuStopGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuStopGame.setForeground(new java.awt.Color(204, 0, 51));
        jMenuStopGame.setText("Stop Game");
        jMenuStopGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuStopGameActionPerformed(evt);
            }
        });
        jMenuPlay.add(jMenuStopGame);

        jMenuBar.add(jMenuPlay);

        jMenuSettings.setMnemonic('s');
        jMenuSettings.setText("Settings");

        jCheckAdd.setSelected(true);
        jCheckAdd.setText("Addition");
        jCheckAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changedOperationsMouseRelease(evt);
            }
        });
        jCheckAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changedOperation(evt);
            }
        });
        jMenuSettings.add(jCheckAdd);

        jCheckSubtract.setSelected(true);
        jCheckSubtract.setText("Subtraction");
        jCheckSubtract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changedOperationsMouseRelease(evt);
            }
        });
        jCheckSubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changedOperation(evt);
            }
        });
        jMenuSettings.add(jCheckSubtract);

        jCheckMultiply.setSelected(true);
        jCheckMultiply.setText("Multiplication");
        jCheckMultiply.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changedOperationsMouseRelease(evt);
            }
        });
        jCheckMultiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changedOperation(evt);
            }
        });
        jMenuSettings.add(jCheckMultiply);

        jCheckDivide.setSelected(true);
        jCheckDivide.setText("Division");
        jCheckDivide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changedOperationsMouseRelease(evt);
            }
        });
        jCheckDivide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changedOperation(evt);
            }
        });
        jMenuSettings.add(jCheckDivide);

        jMenuSetBgColour.setText("Set Background Colour");
        jMenuSetBgColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSetBgColourActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuSetBgColour);

        jMenuSetTimerColour.setText("Set Timer Colour");
        jMenuSetTimerColour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSetTimerColourActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuSetTimerColour);

        jMenuGameDuration.setText("Set Game Duration (60 s)");
        jMenuGameDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGameDurationActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuGameDuration);

        jMenuTestDuration.setText("Set Test Duration (60 s)");
        jMenuTestDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTestDurationActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuTestDuration);

        jMenuSetTableLimit.setText("Set Timetable Limit (12)");
        jMenuSetTableLimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSetTableLimitActionPerformed(evt);
            }
        });
        jMenuSettings.add(jMenuSetTableLimit);

        jMenuBar.add(jMenuSettings);

        jMenuAbout.setMnemonic('a');
        jMenuAbout.setText("About");
        jMenuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuAboutMousePressed(evt);
            }
        });
        jMenuBar.add(jMenuAbout);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemTimedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTimedActionPerformed
        gameOrganiser.startGame(MODE_TIMED);
    }//GEN-LAST:event_jMenuItemTimedActionPerformed

    private void numberInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberInputActionPerformed
        String submittedAnswer = numberInput.getText();
        try {
            int input = Integer.parseInt(submittedAnswer);
            gameOrganiser.checkAnswer(input);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        highlightBox();
    }//GEN-LAST:event_numberInputActionPerformed

    private void jMenuItemPractiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPractiseActionPerformed
        gameOrganiser.startGame(MODE_TIMETABLE);
    }//GEN-LAST:event_jMenuItemPractiseActionPerformed

    private void jMenuSetTimerColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSetTimerColourActionPerformed
        Color tmp = JColorChooser.showDialog(null, "Please select the colour of the timer.", TIMER_COLOUR);
        TIMER_COLOUR = tmp == null ? TIMER_COLOUR : tmp;
        repaint();
    }//GEN-LAST:event_jMenuSetTimerColourActionPerformed

    private void jMenuSetBgColourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSetBgColourActionPerformed
        Color tmp = JColorChooser.showDialog(null, "Please select the background colour.", GLOBAL_BG);
        GLOBAL_BG = tmp == null ? GLOBAL_BG : tmp;
        backPanel.setBackground(GLOBAL_BG);
        tabPaneGame.setBackground(GLOBAL_BG);
        repaint();
    }//GEN-LAST:event_jMenuSetBgColourActionPerformed

    private void jMenuSetTableLimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSetTableLimitActionPerformed
        String value = JOptionPane.showInputDialog(String.format("Please enter the highest timetable.\n(mininum: 12, maximum: 50)\nCurrently it is the %d timetable.", MAX_TIMETABLE));
        
        int value2 = -1;
        try {
            value2 = Integer.parseInt(value);
            if (value2 < 12 || value2 > 50) throw new Exception("Outside range");

        } catch (Exception e) {
            if (value == null) return;
            JOptionPane.showMessageDialog(null, String.format("Sorry, %s is not allowed. The current highest timetable is %d.", value, MAX_TIMETABLE));
            return;
        }
        
        MAX_TIMETABLE = value2;
        gameOrganiser.setNewNumbers();
    }//GEN-LAST:event_jMenuSetTableLimitActionPerformed

    private void jMenuGameDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGameDurationActionPerformed
        String value = JOptionPane.showInputDialog(String.format("Please enter the starting amout of time per game.\n(mininum: 5 seconds, maximum: 60 seconds)\nCurrently it is %d seconds.", GAME_TIME_MS/1000));
        
        int value2 = -1;
        try {
            value2 = Integer.parseInt(value) * 1000;
            if (value2 < 5_000 || value2 > 60_000) throw new Exception("Outside range");

        } catch (Exception e) {
            if (value == null) return;
            JOptionPane.showMessageDialog(null, String.format("Sorry, %s is not allowed. The current starting time is %d seconds.", value, GAME_TIME_MS/1000));
            return;
        }
        GAME_TIME_MS = value2;
        jMenuGameDuration.setText(String.format("Set Game Time (%d s)", GAME_TIME_MS/1000));
    }//GEN-LAST:event_jMenuGameDurationActionPerformed

    private void jMenuTestTimetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTestTimetableActionPerformed
        gameOrganiser.startGame(MODE_TEST);
    }//GEN-LAST:event_jMenuTestTimetableActionPerformed

    private void jMenuAboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAboutMousePressed
        JOptionPane.showMessageDialog(null, 
            "Learn the 12 timetables!\n(c) 2015 Pheng Taing (bit.ly/pixport)", 
            "About Me", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_jMenuAboutMousePressed

    private void changedOperation(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changedOperation
        gameOrganiser.updateOperations();
    }//GEN-LAST:event_changedOperation

    private void jMenuTest60SecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTest60SecActionPerformed
        gameOrganiser.startGame(MODE_60_SEC);
    }//GEN-LAST:event_jMenuTest60SecActionPerformed

    private void changedOperationsMouseRelease(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changedOperationsMouseRelease
        jMenuSettings.doClick();
    }//GEN-LAST:event_changedOperationsMouseRelease

    private void jMenuStopGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuStopGameActionPerformed
        gameOrganiser.gameOver(null, true, false);
    }//GEN-LAST:event_jMenuStopGameActionPerformed

    private void jMenuTestDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTestDurationActionPerformed
        String value = JOptionPane.showInputDialog(String.format("Please enter the amout in seconds per test.\n(mininum: 60 seconds, maximum: 600 seconds)\nCurrently it is %d seconds.", TEST_TIME_MS/1000));
        
        int value2 = -1;
        try {
            value2 = Integer.parseInt(value) * 1000;
            if (value2 < 60_000 || value2 > 600_000) throw new Exception("Outside range");

        } catch (Exception e) {
            if (value == null) return;
            JOptionPane.showMessageDialog(null, String.format("Sorry, %s is not allowed. The current test time is %d seconds.", value, TEST_TIME_MS/1000));
            return;
        }
        
        TEST_TIME_MS = value2;
        jMenuTestDuration.setText(String.format("Set Test Time (%d s)", TEST_TIME_MS/1000));
        jMenuTest60Sec.setText((String.format("Test %d Seconds", TEST_TIME_MS/1000)));
    }//GEN-LAST:event_jMenuTestDurationActionPerformed
    
    public void repaint() {
        super.repaint();
        backPanel.repaint();
    }
    
    public void highlightBox() {
        //jNumberFromUser.setSelectionStart(0);
        //jNumberFromUser.setSelectionEnd(Integer.MAX_VALUE);
        numberInput.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //try { javax.swing.UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } 
            } //*/
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TimetablePro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimetablePro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimetablePro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimetablePro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimetablePro().setVisible(true);
                
            }
        });
    }
    public static void outl(Object o) {
        System.out.println(o);
    }
    public static void out(Object o) {
        System.out.print(o);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backPanel;
    private timetablepro.ClockPanel cp;
    private timetablepro.FeedbackPanel fp;
    private javax.swing.JCheckBoxMenuItem jCheckAdd;
    private javax.swing.JCheckBoxMenuItem jCheckDivide;
    private javax.swing.JCheckBoxMenuItem jCheckMultiply;
    private javax.swing.JCheckBoxMenuItem jCheckSubtract;
    private javax.swing.JLabel jLabelOperation;
    private javax.swing.JMenu jMenuAbout;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuGameDuration;
    private javax.swing.JMenuItem jMenuItemPractise;
    private javax.swing.JMenuItem jMenuItemTimed;
    private javax.swing.JMenu jMenuPlay;
    private javax.swing.JMenuItem jMenuSetBgColour;
    private javax.swing.JMenuItem jMenuSetTableLimit;
    private javax.swing.JMenuItem jMenuSetTimerColour;
    private javax.swing.JMenu jMenuSettings;
    private javax.swing.JMenuItem jMenuStopGame;
    private javax.swing.JMenuItem jMenuTest60Sec;
    private javax.swing.JMenuItem jMenuTestDuration;
    private javax.swing.JMenuItem jMenuTestTimetable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextArea jtaResult;
    private javax.swing.JTextField numberInput;
    private timetablepro.NumberPanel numberLeft;
    private timetablepro.NumberPanel numberRight;
    private javax.swing.JPanel tabPaneGame;
    private javax.swing.JPanel tabPaneScore;
    // End of variables declaration//GEN-END:variables

    void displayResult(String resultAnalysis) {
        jTabbedPane.setSelectedIndex(1);
        jtaResult.setText(resultAnalysis);
    }

    void setPanelToGame() {
        jTabbedPane.setSelectedIndex(0);
        
    }


    
}

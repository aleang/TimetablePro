package timetablepro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static java.lang.System.out;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;

public class GameOrganiser {
    // Operators unicode constants
    final static char PLUS = '+', MINUS = '\u2212', TIMES = 'x', DIVIDE = '\u00F7';
    
    NumberPanel leftNumPanel, rightNumPanel;
    
    JLabel opLabel;
    FeedbackPanel feedbackPanel;
    ClockPanel clockPanel;
    TimetablePro mainFrame;
    List<Integer> testNumbersList;
    
    int score, chosenFixedValue, correctCount[];
    static boolean inGame, isFixedTimetable, inTest, allowBonusTime;
    char currentOperator, charOperators[];
    long gameStartTime;
    JCheckBoxMenuItem[] chkBoxOperators; 
    JMenu settingsMenu;
    
    GameOrganiser(TimetablePro tp, NumberPanel left, NumberPanel right, JLabel op, 
            FeedbackPanel fp, ClockPanel cp, JCheckBoxMenuItem[] jc, JMenu sm) {
        this.leftNumPanel = left;
        this.rightNumPanel = right;
        this.opLabel = op;
        this.feedbackPanel = fp;
        this.clockPanel = cp;
        this.mainFrame = tp;
        this.chkBoxOperators = jc;
        this.settingsMenu = sm;
        
        inGame = isFixedTimetable = inTest = allowBonusTime = false;
        charOperators = new char[]{PLUS, MINUS, TIMES, DIVIDE};
        
        testNumbersList = new ArrayList<Integer>();
        fp.setMainScreen(tp);
        cp.setMainScreen(tp, this);
        setNewNumbers();
        opLabel.setText(""+currentOperator);
    }
    
    /**
     * start a new game based on selected mode
     * @param mode game modes listed in TimetablePro
     */
    public void startGame(int mode) {
        
        if (inGame) {
            JOptionPane.showMessageDialog(null, 
                "Sorry, you can't start a new game until the current game is finished.", 
                "Current game in play", 
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        /**
         * Game mode MODE_TIMETABLE (2) or MODE_TEST (3) selected
         * MODE_TIMETABLE   play with left value fixed
         * MODE_TEST        test a timetable
         */
        
        mainFrame.setPanelToGame();
        if (mode >= timetablepro.TimetablePro.MODE_TIMETABLE) {
            String userInput = JOptionPane.showInputDialog(
                null,
                String.format("Please enter the timetable (1 to %d).", timetablepro.TimetablePro.MAX_TIMETABLE),
                "Select a Timetable",
                JOptionPane.QUESTION_MESSAGE
            );
            
            int userInputInt = Integer.MIN_VALUE;
            try {
                userInputInt = Integer.parseInt(userInput);
                if (userInputInt < 1 || userInputInt > timetablepro.TimetablePro.MAX_TIMETABLE) 
                    throw new Exception("Outside range");
                chosenFixedValue = userInputInt;
            } catch (Exception e) {
                if (userInput != null) 
                    JOptionPane.showMessageDialog(
                        null,
                        String.format("Sorry, \"%s\" is not a valid number", userInput),
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                    );
                return;
            }
            
            if (mode == timetablepro.TimetablePro.MODE_TEST) {
                inTest = true;
                testNumbersList = loadTestNumbers(new ArrayList<Integer>());
                
                JOptionPane.showMessageDialog(null, "Press YES to start", "Start Test", JOptionPane.INFORMATION_MESSAGE);
                
            }
            
            isFixedTimetable = true;
            setAvailableOperator(new char[]{TIMES});
            
            
        } else if (mode <= timetablepro.TimetablePro.MODE_TIMED) {
            isFixedTimetable = false;
            allowBonusTime = true;
            
        }
        score = 0;
        correctCount = new int[4];
        gameStartTime = System.currentTimeMillis();
        inGame = true;
        settingsMenu.setEnabled(! inGame);
        setNewNumbers();
        clockPanel.startGame(mode);
    }

    /**
     * pick randomly two numbers and an operator
     */
    public void setNewNumbers()  {
        // select a new operator
        if (charOperators.length == 0) {
            JOptionPane.showMessageDialog(null, "Must have at least one operation checked. See the Settings menu.", "No operations selected", JOptionPane.ERROR_MESSAGE);
            chkBoxOperators[0].setSelected(true);
            return;
        }
        currentOperator = charOperators[(int)(Math.random() * charOperators.length)];
        opLabel.setText("" + currentOperator);
        
        // get new numbers
        int newLeft = Integer.MIN_VALUE, newRight = Integer.MIN_VALUE;
        
        newLeft = (isFixedTimetable && (inGame||inTest)) ? chosenFixedValue : getNumber(1, timetablepro.TimetablePro.MAX_TIMETABLE);

        if (inTest){
            newRight = grabANewNumberForTest();
        } else {
            newRight = getNumber(1, timetablepro.TimetablePro.MAX_TIMETABLE);
            while (rightNumPanel.num == newRight) {
                newRight = getNumber(1, timetablepro.TimetablePro.MAX_TIMETABLE);
            }
        }
        rightNumPanel.num = newRight;
        
        switch (currentOperator) {
            case MINUS: newLeft += newRight; break;
            case DIVIDE: newLeft *= newRight; break;
        }
        
        leftNumPanel.num = newLeft;
        rightNumPanel.num = newRight;
        //out.println(newLeft + "< >"+ newRight);
        mainFrame.repaint();
    }
    
    public void setAvailableOperator(char[] op) {
        this.charOperators = op;
    }
    
    /**
     * update the operators array based on what is selected from the menu
     */
    public void updateOperations() {
        String temp = "";
        
        if (chkBoxOperators[0].isSelected()) temp += PLUS;
        if (chkBoxOperators[1].isSelected()) temp += MINUS;
        if (chkBoxOperators[2].isSelected()) temp += TIMES;
        if (chkBoxOperators[3].isSelected()) temp += DIVIDE;
        
        charOperators = temp.toCharArray();
        if (temp.indexOf(currentOperator) == -1) setNewNumbers();
       
    }
    
    /**
     * check the user's answer and give feedback
     * 
     * @param answer the supplied answer from user
     */
    public void checkAnswer(int answer) {
        int correctAns = Integer.MIN_VALUE;
        
        switch (currentOperator) {
            case PLUS:  correctAns = leftNumPanel.num + rightNumPanel.num; break;
            case MINUS: correctAns = leftNumPanel.num - rightNumPanel.num; break;
            case TIMES: correctAns = leftNumPanel.num * rightNumPanel.num; break;
            case DIVIDE: correctAns = leftNumPanel.num / rightNumPanel.num;
        }
        
        boolean gotItRight = (answer == correctAns);
        feedbackPanel.showFeedback(gotItRight);
        if (gotItRight) {
            setNewNumbers();
            score++;
            
            switch (currentOperator) {
                case PLUS:  correctCount[0]++; break;
                case MINUS: correctCount[1]++; break;
                case TIMES: correctCount[2]++; break;
                case DIVIDE: correctCount[3]++; break;
            }
            
            if (inGame) {
                clockPanel.giveBonusTime();
            }
            
        } else {
            // got it wrong
            if (inGame) {
                clockPanel.takeOffTime();
            }
        }
    }

    /**
     * create a list of numbers to use in the test 
     * only mode MODE_TEST (3)
     * @param arrayList
     * @return list of integers for the test
     */
    private List<Integer> loadTestNumbers(ArrayList<Integer> arrayList) {
        for (int i = 1; i <= timetablepro.TimetablePro.MAX_TIMETABLE; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    /**
     * get a random number from the list
     * @return the next number in the test
     */
    private int grabANewNumberForTest() {
        clockPanel.updateTestClock(testNumbersList);
        if (testNumbersList.size() == 0) {
            testOver();
        }
        return testNumbersList.remove((int)(Math.random()*testNumbersList.size()));
    }
    
    /**
     * get a random number between min and max (inclusive)
     * @param min lowest possible value
     * @param max highest possible value
     * @return 
     */
    public int getNumber(int min, int max) {
        return (int)(Math.random()* (max-min+1)) + min;
    }
    

    public void gameOver(String message, boolean isForced, boolean showTime) {
        if (! isForced) {
            double duration = (System.currentTimeMillis() - gameStartTime)/1000.0;
            
            String resultAnalysis = String.format("You got %d correct", score);
            resultAnalysis += showTime ? String.format(" in %.2f seconds", duration) : "";
            resultAnalysis += ".\n";
            if (correctCount[0] > 0) resultAnalysis += String.format("Addition: %d%n", correctCount[0]);
            if (correctCount[1] > 0) resultAnalysis += String.format("Subtraction: %d%n", correctCount[1]);
            if (correctCount[2] > 0) resultAnalysis += String.format("Multiplication: %d%n", correctCount[2]);
            if (correctCount[3] > 0) resultAnalysis += String.format("Division: %d%n", correctCount[3]);
            
            mainFrame.displayResult(message == null ? String.format("Times up!%n%s", resultAnalysis) : message);
        /*    JOptionPane.showMessageDialog(null, 
                message == null ? String.format("Times up!%n%s", resultAnalysis) : message,
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE
            ); //*/
        }
        testNumbersList.clear();
        clockPanel.resetClock();
        updateOperations();
        inGame = isFixedTimetable = inTest = allowBonusTime  =  false;
        settingsMenu.setEnabled(! inGame);
        mainFrame.repaint();
    }
    public void testOver() {
        long currentTime = System.currentTimeMillis();
        gameStartTime = currentTime - gameStartTime;
        gameOver(String.format("Well done!\nYou have completed the %d timetable in %.2f seconds.", chosenFixedValue, gameStartTime/1e3),
                false,
                true
                );
    }


}

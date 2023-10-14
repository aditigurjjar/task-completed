

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class WordCounter extends JFrame {
    JLabel wordLabel;
    static JLabel timeLabel;
    JTextArea textArea;

    WordCounter() {
        setLayout(null);
        setTitle("Word Counter");

        wordLabel = new JLabel("WORDS : 0");
        timeLabel = new JLabel("TIME : 0 : 0 : 0");
        textArea = new JTextArea();

        wordLabel.setBounds(100, 100, 200, 40);
        timeLabel.setBounds(300, 100, 200, 40);
        textArea.setBounds(100, 150, 300, 250);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                wordLabel.setText("WORD : " + textArea.getText().split(" ").length);
            }
        });

        add(wordLabel);
        add(timeLabel);
        add(textArea);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] ar) {
        new WordCounter();
        new TimerThread(timeLabel).start();
    }
}

class TimerThread extends Thread {
    JLabel timeLabel;

    TimerThread(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    public void run() {
        while (true) {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR);
            int minute = c.get(Calendar.MINUTE);
            int second = c.get(Calendar.SECOND);
            timeLabel.setText("TIME : " + hour + " : " + minute + " : " + second);
        }
    }
}

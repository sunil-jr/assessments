package com.assessments.consoleMessage;

import java.util.Timer;
import java.util.TimerTask;

public class DisplayConsoleMessage extends TimerTask {

    public void run() {
        System.out.println("message in every two minutes!!");
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        long interval = 2 * 60 * 1000;
        timer.schedule(new DisplayConsoleMessage(), 0, interval);
    }
}


package com.TDA367group15.app.controller;

import com.TDA367group15.app.model.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public Boolean downPressed, leftPressed, rightPressed, enterPressed, escapePressed;
    Boolean upPressed = downPressed = leftPressed = rightPressed = enterPressed = escapePressed = false; // default false

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int  code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if(code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
        if(code == KeyEvent.VK_ESCAPE) {
            escapePressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if(code == KeyEvent.VK_ENTER) {
            enterPressed = false;
        }
        if(code == KeyEvent.VK_ESCAPE) {
            escapePressed = false;
        }

    }

    public Direction getDirectionPressed() {
        if(upPressed) {
            return Direction.UP;
        }
        if(downPressed) {
            return Direction.DOWN;
        }
        if(leftPressed) {
            return Direction.LEFT;
        }
        if(rightPressed) {
            return Direction.RIGHT;
        }
        else return null;
    }

}

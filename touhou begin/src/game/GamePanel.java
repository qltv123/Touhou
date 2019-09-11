package game;


import Screen.PlayScreen;
import Screen.SceneManager;
import Screen.WelcomeScreen;
import game.Player.Player;
import game.enemy.Enemy;
import game.enemy.EnemySummoner;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;



    public GamePanel(){
        SceneManager.signNewScreen(new WelcomeScreen());
    }
        // duong dan tuong doi:assets/images/players/straight/0.png

//        background = new Background();
//        player = new Player();
////        enemy = new Enemy();
//        new EnemySummoner();    }

    @Override
    public void paint(Graphics g) {
        // draw: ve vien
        // fill: to kin
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        GameObject.renderAll(g);

        if (SceneManager.currentScreen instanceof PlayScreen){
        g.setColor(Color.black);
        g.fillRect(Settings.BACKGROUND_WIDTH,0,Settings.GAME_WIDTH - Settings.BACKGROUND_WIDTH,600);}
    }

    public void gameLoop() {
        long lastTime = 0;
        while(true) {
            long currentTime = System.nanoTime();
            if(currentTime - lastTime >= 1000000000 / 60) {
                // render + logic
                repaint();
                runAll();
                lastTime = currentTime;
            }
        }
    }

    public void runAll() {
        GameObject.runAll();
    }
}

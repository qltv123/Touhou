package Screen;

import game.GameObject;
import game.KeyEventPress;
import game.Renderer;
import game.Settings;

import java.awt.*;


public class backGroundWelcome extends GameObject {
    public backGroundWelcome(){
        renderer = new Renderer("assets/images/anh.png");
        position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        if(KeyEventPress.isSkey){
            SceneManager.signNewScreen(new PlayScreen());
        }
        if(KeyEventPress.isEkey){
            SceneManager.signNewScreen(new GameOverScreen());
        }
    }
    public Rectangle startButton = new Rectangle(100, 180, 80, 40);
    public Rectangle exstartButton = new Rectangle(65, 250, 150, 40);
    public Rectangle quitButton = new Rectangle(105, 320, 75, 40);

    public void render(Graphics g){

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("TOUHOU GAME", 100, 100);

        Font fnt1 = new Font("Arial Bold", Font.ITALIC, 25);
        g.setFont(fnt1);
        g.drawString("Start", startButton.x + 12, startButton.y + 27);
        //g2d.draw(startButton);
        g.drawString("Extra Start", exstartButton.x + 12, exstartButton.y + 27);
        //g2d.draw(exstartButton);
        g.drawString("Quit", quitButton.x + 12, quitButton.y + 27);
        //g2d.draw(quitButton);

        Font fnt2 = new Font("Arial Bold", Font.BOLD, 17);
        g.setFont(fnt2);
    }
}

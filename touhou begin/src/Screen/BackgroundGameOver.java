package Screen;

import game.*;

import java.awt.*;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver(){
        renderer = new Renderer("assets/images/gameover.png");
        position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT/2);
    }
    public Rectangle backButton = new Rectangle(210, 320, 250, 40);

    public void render(Graphics g){
        //Graphics2D g2d = (Graphics2D) g;
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("You Failed", 220, 200);

        Font fnt1 = new Font("Arial Bold", Font.ITALIC, 25);
        g.setFont(fnt1);
        g.drawString("Back to Menu (ESC)", backButton.x + 12, backButton.y + 27);
        //g2d.draw(backButton);
    }
    int framecount = 0;
    @Override
    public void run() {
        super.run();
        framecount++;
        if(KeyEventPress.isSkey && framecount >180){
            SceneManager.signNewScreen(new WelcomeScreen());
        }
    }
}

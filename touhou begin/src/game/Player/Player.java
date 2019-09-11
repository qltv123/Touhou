package game.Player;

import Screen.GameOverScreen;
import Screen.SceneManager;
import game.*;
import tklibs.Mathx;

import java.awt.*;
import java.util.Set;

public class Player extends GameObject {
    public int hp;
    public boolean immune;

    public Player(){
        renderer = new Renderer("assets/images/players/straight");
        position.set(200,400);
        hitBox = new BoxCollider(this, Settings.PLAYER_WIDTH - 12, Settings.PLAYER_HEIGHT - 12);
        hp = 1;
        immune = false;
    }


    public void takeDamage(int damage){
        if (immune){ return; }

        hp -= damage;
        if (hp <=0){
            hp = 0;
            this.deactive();
        } else {
            immune = true;
        }
    }

    public void run(){
        super.run();
        this.move();
        this.limitPosition();
        this.fire();
        this.checkImmune();

    }

    @Override
    public void render(Graphics g) {
        if(immune){
            if(immuneCount % 2 == 0){ super.render(g); }

        } else { super.render(g); }
    }

    int immuneCount = 0;
    private void checkImmune() {
        if(immune){
            immuneCount ++;
            if (immuneCount > 120){
                immune = false;
                immuneCount = 0;
            }
        }
    }

    int frameCount = 0;
    private void fire() {
        frameCount++;
        if(KeyEventPress.isFirePress && frameCount > 10) {
            int numberBullet = 3;
            double startX = position.x -10;
            double endX = position.x + 10;
            double stepX = (endX - startX) / (numberBullet -1);
            double startAngle = -120;
            double endAngle = -60;
            double stepAngle = (endAngle - startAngle)/(numberBullet-1);

            for (int i = 0; i< numberBullet; i++) {
                PlayerBullet bullet = new PlayerBullet();
                bullet.position.set(startX + (stepX * 1), position.y);
                bullet.velocity.setAngle(Math.toRadians(startAngle + (stepAngle*i)));
            }

            frameCount = 0;
        }
    }

    private void limitPosition() {
        int halfWidthPlayer = Settings.PLAYER_WIDTH / 2;
        int halfHeightPlayer = Settings.PLAYER_HEIGHT / 2;
        position.x = Mathx.clamp(position.x, halfWidthPlayer, Settings.BACKGROUND_WIDTH - halfWidthPlayer);
        position.y = Mathx.clamp(position.y, halfHeightPlayer, Settings.GAME_HEIGHT - halfHeightPlayer);
    }

    public void move(){
        if(KeyEventPress.isLeftPress) {
            position.x-=5;
        }
        if(KeyEventPress.isUpPress) {
            position.y-=5;
        }
        if(KeyEventPress.isRightPress) {
            position.x+=5;
        }
        if(KeyEventPress.isDownPress) {
            position.y+=5;
        }
    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScreen(new GameOverScreen());
    }
}

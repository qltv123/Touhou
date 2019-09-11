package game.enemy;

import game.BoxCollider;
import game.GameObject;
import game.Player.Player;
import game.Renderer;
import game.Settings;
import tklibs.SpriteUtils;

import java.util.Set;


public class Enemy extends GameObject {
    public int damage;
    public Enemy(){
//        image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        renderer = new Renderer("assets/images/enemies/level0/pink");
        //position = (0,0)
        position.set(-50,-50);
        velocity.set(0,4);
        velocity.setAngle(Math.toRadians(20));
        hitBox = new BoxCollider(this, Settings.ENEMY_WIDTH - 8, Settings.ENEMY_HEIGHT - 8);
        damage = 1;
    }

    @Override
    public void run(){
        super.run();
        this.checkPlayer();
        if(outOfBoundRight() && onGoingRight()){
            velocity.x *= -1;
        }
        if (position.x < Settings.ENEMY_WIDTH * anchor.x && velocity.x < 0){
            velocity.x *= -1;
        }
    }

    private void checkPlayer() {
        Player player = GameObject.findIntersects(Player.class, this);
        if(player != null){
            this.deactive();
//            player.deactive();
            player.takeDamage(damage);
        }
    }

    private boolean onGoingRight() {
        return velocity.x > 0;
    }

    private boolean outOfBoundRight() {
        return position.x >= Settings.BACKGROUND_WIDTH - Settings.ENEMY_WIDTH * anchor.x;
    }

    @Override
    public void deactive() {
        super.deactive();
        EnemyExplosion explosion = new EnemyExplosion();
        explosion.position.set(position);
    }
}

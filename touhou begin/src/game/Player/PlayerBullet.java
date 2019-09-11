package game.Player;

import game.BoxCollider;
import game.GameObject;
import game.Renderer;
import game.Settings;
import game.enemy.Enemy;
import tklibs.SpriteUtils;


public class PlayerBullet extends GameObject {

    public PlayerBullet(){
//        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        renderer = new Renderer("assets/images/player-bullets/a",3 );
        velocity.set(0,-7);
        hitBox = new BoxCollider(this, Settings.PLAYER_BULLET_WIDTH - 5, Settings.PLAYER_BULLET_HEIGHT - 5);
    }

    @Override
    public void run() {
        super.run();
        this.checkEnemy();
    }

    private void checkEnemy() {
//        Enemy enemy = GameObject.findEnemyIntersects(this);
        Enemy enemy = GameObject.findIntersects(Enemy.class, this);
        if(enemy != null && enemyInBound(enemy)){
            this.deactive();
            enemy.deactive();
        }
    }

    public boolean enemyInBound(Enemy enemy){
        return enemy.position.x > -Settings.ENEMY_WIDTH * enemy.anchor.x && enemy.position.y > - Settings.ENEMY_HEIGHT * enemy.anchor.y;
    }
}

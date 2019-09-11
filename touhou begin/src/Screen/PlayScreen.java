package Screen;

import game.Background;
import game.GameObject;
import game.Player.Player;
import game.enemy.EnemySummoner;

public class PlayScreen extends Screen {

    @Override
    public void init() {
        new Background();
        new Player();
        new EnemySummoner();
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}

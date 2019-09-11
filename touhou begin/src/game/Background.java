package game;

import tklibs.SpriteUtils;


public class Background extends GameObject{
    // ham tao
    public Background() {
//        image = SpriteUtils.loadImage("assets/images/background/0.png");
        renderer = new Renderer("assets/images/background/0.png");
        position.set(0,600-3109);
        velocity.set(0,1);
        anchor.set(0,0);
    }

    @Override
    public void run() {
        super.run(); //position.add(velocity.x, velocity.y)
        if (position.y >=0){
            position.y = 0;
        }
    }
}

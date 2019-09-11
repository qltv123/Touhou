package game;

import game.enemy.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject{
    //quan ly doi tuong(static)
    public static ArrayList<GameObject> listObject = new ArrayList<>();

    public static void runAll(){
        for( int i = 0; i< listObject.size(); i++){
            GameObject object = listObject.get(i);
            if (object.active){
                object.run();
            }
        }
    }

    public static void renderAll(Graphics g){
        for( int i = 0; i< listObject.size(); i++){
            GameObject object = listObject.get(i);
            if (object.active){
                object.render(g);
            }
        }
    }

    public static  Enemy findEnemyIntersects(GameObject source){
        for (int i = 0; i < listObject.size(); i++) {
            GameObject object = listObject.get(i);
            if (object.active
                    && object instanceof Enemy
                    && object.hitBox !=null
                    && object.hitBox.intersects(source.hitBox)){
                return (Enemy) object;
            }
        }
        return null;
    }
    // E: hoặc là Player, hoặc là Enemy, playerbullet...
    //cls: Player.class, Enemy.class,....
    public static <E> E findIntersects(Class<E> cls, GameObject source){
        for (int i = 0; i < listObject.size(); i++) {
            GameObject object = listObject.get(i);
            if(object.active
            && cls.isAssignableFrom(object.getClass())
            && object.hitBox != null
            && object.hitBox.intersects(source.hitBox)){
                return (E) object;
            }

        }
        return null;
    }

    public static void clear(){
        listObject.clear();
    }

    //dinh nghia doi tuong
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;
    public BoxCollider hitBox; //Null
    public Vector2D anchor;

    public GameObject(){
        listObject.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        active = true;
        anchor = new Vector2D(0.5,0.5);
    }

    public void render(Graphics g){
        if (renderer != null){
            renderer.render(g, this);
        }
    }

    public void run(){
        position.add(velocity.x, velocity.y);
    }

    public void deactive(){
        active = false;
    }

    public void reset(){
        active = true;
    }
}

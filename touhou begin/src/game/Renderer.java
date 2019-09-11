package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Renderer {
    //1. single image
    public BufferedImage image;

    //2.animation
    public ArrayList<BufferedImage> images;
    public int currentIndex;
    public int delayFrame;
    public boolean  isOnce;

    public Renderer(String url){
        this(url, 6,false);
    }

    public Renderer(String url, int delayFrame){
        this(url, delayFrame, false);
    }

    public Renderer(String url, int delayFrame, boolean isOnce){
        File file = new File(url);
        if (file.isFile()){
            image = SpriteUtils.loadImage(url);
        }
        if(file.isDirectory()){
            images = SpriteUtils.loadImages(url);
            currentIndex = 0;
            this.delayFrame = delayFrame;
            this.isOnce  = isOnce;
        }
    }
    int frameCount = 0;
    public void render(Graphics g, GameObject master){
        if(image != null){
//            g.drawImage(image, (int)master.position.x, (int)master.position.y,null);
            drawImage(g, image, master);
        }
        if( images != null && images.size() >0){
            frameCount ++;
            BufferedImage currentImage = images.get(currentIndex);
//            g.drawImage(currentImage, (int)master.position.x, (int)master.position.y,null);
            drawImage(g, currentImage, master);

            if (frameCount > delayFrame){
                currentIndex ++;
                if(currentIndex >= images.size()){
                    currentIndex = 0;
                    if(isOnce){
                        master.deactive();
                    }
                }
                frameCount = 0;
            }
        }

    }

    private void drawImage(Graphics g,BufferedImage image, GameObject master) {
        g.drawImage(image,(int)(master.position.x - master.anchor.x * image.getWidth()),
                          (int)(master.position.y - master.anchor.y * image.getHeight()),
                        null);

        //only for dev mode
        // 1.mark;
//        g.setColor(Color.RED);
//        g.fillOval((int)master.position.x - 2,(int)master.position.y - 2,5,5);
//        //2.draw hitbox if can
//        if (master.hitBox != null){
//            g.setColor(Color.GREEN);
//            g.drawRect((int)master.hitBox.left(), (int)master.hitBox.top(),master.hitBox.width,master.hitBox.height);
//        }
    }

}

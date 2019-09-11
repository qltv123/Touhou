package Screen;

import game.GameObject;

import java.awt.*;
import java.util.Scanner;

public class WelcomeScreen extends Screen{
    @Override
    public void init() {
        new backGroundWelcome();
    }



    @Override
    public void clear() {
        GameObject.clear();
    }
}

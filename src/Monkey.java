//import javafx.scene.shape.Circle;
import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public abstract class Monkey {
    //do vision and the arraylist of balloons
    private ArrayList<Balloon> balloonsInSight = new ArrayList<>();//TODO last and first balloon attack
    private BufferedImage image;
    private boolean imageFill = true;
    private Circle visionBox;
    private Rectangle box;
    private Location location;
    private String name;
    private int value, visionRadius;
    private double velocity;

    public Monkey (int x, int y, double v)
    {
        location = new Location(x,y);
        box = new Rectangle(32, 32);
        box.setLocation((int) location.getX(), (int) location.getY());
        visionBox = new Circle();
        setImageFill(true);
        velocity = v;
    }

    public ArrayList<Balloon> getBalloonsInSight() {
        return balloonsInSight;
    }

    public void draw(Graphics g, ImageObserver observer){  // draws the rectangle
        Color oldColor = g.getColor();
        int x = (int)(box.getX() - (box.getWidth() / 2));
        int y =  (int)(box.getY() - (box.getHeight() / 2));
        if (isImageFill())
            g.drawImage(getImage(), x, y, observer);
        g.setColor(oldColor);
    }

    public Location getLocation() {
        return location;
    }

    public boolean isImageFill() {
        return imageFill;
    }
    public BufferedImage getImage() {
        return image;
    }
    public void setImageFill(boolean i) {
        imageFill = i;
    }
    public void setImagePath(String s){
        try {
            image = ImageIO.read(new File(s));
        } catch (IOException ex) {
            System.out.println("Could not find file");
        }
    }
    public void setImage(int i) {
        if (i == 0) {
            setImagePath(name + ".png");
        } else {
            setImagePath(name + "2.png");
        }
    }

    public int getValue() {
        return value;
    }
    public String getName() {
        return name;
    }
    public void setName(String s) {
        name = s;
    }
    public void setValue(int x) {
        value = x;
    }
    public void setVisionRadius(int i) {
        visionRadius = i;
        visionBox.setRadius(i);
        visionBox.setCenterX(box.getX() - i/2);
        visionBox.setCenterY(box.getY() - i/2);
    }
    public int getVisionRadius() {
        return visionRadius;
    }
    public Circle getVisionBox() {
        return visionBox;
    }
    public Rectangle getBox() {
        return box;
    }
    public double getVelocity() {
        return velocity;
    }

    public abstract Dart attack(ArrayList<Balloon> targets);
}

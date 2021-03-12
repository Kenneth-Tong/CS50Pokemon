//import javafx.scene.shape.Circle;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public abstract class Monkey {
    //do vision and the arraylist of balloons
    private ArrayList<Balloon> balloonsInSight;//TODO last and first balloon attack
    private Color color;
    private BufferedImage image;
    private boolean imageFill = true;
    // private Circle visionBox;
    private Rectangle box;
    private Location location;
    public static ArrayList<Monkey> monkeys = new ArrayList<Monkey>();


    private double velX, velY;
    private int value, visionRadius;

    public Monkey (int x, int y)
    {
        location = new Location(x,y);
        box = new Rectangle(32, 32);
        box.setLocation((int) location.getX(), (int) location.getY());
        setImageFill(true);
    }

    public ArrayList<Balloon> getBalloonsInSight() {
        return balloonsInSight;
    }

    public boolean inSight(Rectangle balloonHitBox) {
        //TODO
        /*
        if(Math.pow(Math.abs(balloonHitBox.getRadius() - visionBox.getRadius()), 2) <=
        Math.pow(balloonHitBox.getCenterX() - visionBox.getCenterX(), 2) + Math.pow(balloonHitBox.getCenterY() - visionBox.getCenterY(), 2) &&
        Math.pow(balloonHitBox.getCenterX() - visionBox.getCenterX(), 2) + Math.pow(balloonHitBox.getCenterY() - visionBox.getCenterY(), 2) <=
        Math.pow(Math.abs(balloonHitBox.getRadius() + visionBox.getRadius()), 2)) {
            return true;
        }
       */
        return false;
    }

    public void draw(Graphics g, ImageObserver observer){  // draws the rectangle
        Color oldColor = g.getColor();
        g.setColor(color);
        int x = (int)(box.getX() - (box.getWidth() / 2));
        int y =  (int)(box.getY() - (box.getHeight() / 2));
        if (isImageFill())
            g.drawImage(getImage(), x, y, observer );
        g.setColor(oldColor);
    }


    public Location getLocation() {
        return location;
    }
    public void updateLocation() {
        location.updateLocation(velX, velY);
    }
    public void setLocation(Location l) {
        location = l;
    }


    public void setColor(Color color) {
        this.color = color;
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
            // handle exception...
        }
    }


    public abstract void setImage();
    public abstract void attack();

    public int getValue() {
        return value;
    }
}

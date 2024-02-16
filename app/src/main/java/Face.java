//@author Jayden Zeng
import android.graphics.Canvas;
import java.util.Random;
public class Face {
    //instance variables
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairstyle;
    //default constructor
    public Face(){randomize();} //helper method to randomize colors for face
    //method using color and has bounds for the color
    public void randomize(){
        Random random = new Random();
        skinColor = random.nextInt(256);
        eyeColor = random.nextInt(256);
        hairColor = random.nextInt(256);
        hairstyle = random.nextInt(256);
    }
    //setter and getter methods
    public int getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(int skinColor) {
        this.skinColor = skinColor;
    }

    public int getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getHairColor() {
        return hairColor;
    }

    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }

    public int getHairstyle() {
        return hairstyle;
    }

    public void setHairstyle(int hairstyle) {
        this.hairstyle = hairstyle;
    }
    //on draw method to draw the face on the canvas
    public void onDraw(Canvas canvas){
    //empty for now
    }
}

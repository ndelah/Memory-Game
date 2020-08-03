import javax.swing.*;

public class Card extends JLabel{
    private ImageIcon frontImage;
    private ImageIcon backgroundImage;
    private boolean isFlipped;
    private boolean isFound;
    private boolean clickable;
    private String bgImagePath = "C:\\Users\\delah\\Documents\\Programming\\workspace\\basic_programming_memory_game\\themes\\special_cards\\bg.jpg"; //Todo: Adapt all paths to be relative

    public Card(ImageIcon image) {

        this.frontImage = image;
        this.backgroundImage = new ImageIcon(bgImagePath);
        this.isFlipped = false;
        this.isFound = false;
        this.clickable = true;

        //this.setIcon(this.backgroundImage);
        this.setIcon(this.frontImage);
    }

    public ImageIcon getFrontImage() {
        return frontImage;
    }

    public void setFrontImage(ImageIcon frontImage) {
        this.frontImage = frontImage;
    }

    public ImageIcon getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(ImageIcon backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }
}

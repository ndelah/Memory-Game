import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Card extends JLabel implements MouseListener{
    private GameWindow gameWindow;
    private ImageIcon frontImage;
    private ImageIcon backgroundImage;
    private String name;
    private boolean isFlipped;
    private boolean isFound;
    private boolean clickable;
    private String bgImagePath = "C:\\Users\\delah\\Documents\\Programming\\workspace\\basic_programming_memory_game\\themes\\special_cards\\bg.jpg"; //Todo: Adapt all paths to be relative

    public Card(ImageIcon image, GameWindow gameWindow,int imageID) {
        this.gameWindow = gameWindow;
        this.frontImage = image;
        this.backgroundImage = new ImageIcon(bgImagePath);
        this.isFlipped = false;
        this.isFound = false;
        this.clickable = true;
        this.name = this.getFrontImage().toString();
        this.setHorizontalAlignment(JLabel.CENTER);


        this.setIcon(this.backgroundImage);


        this.addMouseListener(this);

    }

    public void turnCard(){
        if (this.isFlipped){
            this.setIcon(this.getBackgroundImage());
            this.isFlipped = false;

        } else {
            this.setIcon(this.getFrontImage());
            this.isFlipped = true;
            this.clickable = false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (clickable){
            //turnCard();
            getGameWindow().playerTurn(this);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }
}

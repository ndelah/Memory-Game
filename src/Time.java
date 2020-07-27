import javax.swing.*;

public class Time extends JPanel{
    // Time
    private JLabel timeLabel = new JLabel("Time");
    private JSlider timeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100 , 50);

    public Time (){
        this.add(timeLabel);
        this.add(timeSlider);
    }
}

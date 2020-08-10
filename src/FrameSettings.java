import java.awt.*;

public class FrameSettings {
    Dimension minimumSize = new Dimension(900,500);
    Dimension preferredSize = new Dimension(900,500);;
    Dimension maximumSize = new Dimension(900,500);;

    public FrameSettings(){

    }
    public FrameSettings(Dimension minimumSize, Dimension preferredSize, Dimension maximumSize) {
        this.minimumSize = minimumSize;
        this.preferredSize = preferredSize;
        this.maximumSize = maximumSize;
    }

    public Dimension getMinimumSize() {
        return minimumSize;
    }

    public void setMinimumSize(Dimension minimumSize) {
        this.minimumSize = minimumSize;
    }

    public Dimension getPreferredSize() {
        return preferredSize;
    }

    public void setPreferredSize(Dimension preferredSize) {
        this.preferredSize = preferredSize;
    }

    public Dimension getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(Dimension maximumSize) {
        this.maximumSize = maximumSize;
    }
}

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
public class JImageDisplay extends JComponent{
    private BufferedImage myImage;

    public JImageDisplay (int height, int width){
        myImage = new BufferedImage(width, height, BurfferedImage.TYPE_INT_RGB);
        Dimension newDimension = new Dimension(width, height);
        super.setPreferredSize(newDimension);
    }

    @Override
    public paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage (myImage, 0, 0, myImage.getWidth(), myImage.getHeight(), null);
    }

    public clearImage(){
        int[] rgbArray = new int[myImage.getWidth()* myImage.getHeight()];
        myImage.setRGB(0, 0, myImage.getWidth(), myImage.getHeight(), rgbArray, 0, 1);
    }

    public  drawPixel (int x, int y, int rgbColor){
        myImage.SetRGB(x, y, rgbColor);
    }
}
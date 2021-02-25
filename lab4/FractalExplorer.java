import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO.*;
import java.awt.image.*;

public class FractalExplorer {
    private int windowSize;
    private JImageDisplay imgDisplay;
    private FractalGenerator fracGenerate;
    private Rectangle2D.Double range;


    public FractalExplorer(int size){
        windowSize = size;
        fracGenerate = new Mandelbrot();
        range = new Rectangle2D.Double();
        fracGenerate.getInitialRange(range);
        imgDisplay = new JImageDisplay(windowSize, windowSize);
    }

    public void createAndShowGUI(){
        imgDisplay.setLayout(new BorderLayout());

        JFrame myframe = new JFrame("Fractal Explorer"); 
        myframe.add(imgDisplay, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset Display");
        myframe.add(imgDisplay, BorderLayout.CENTER);
        
        ButtonHandler resetHandler = new ButtonHandler();
        resetButton.addActionListener(resetHandler);
        
        MouseHandler click = new MouseHandler();
        imgDisplay.addMouseListener(click);

        myframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel myBottomPanel = new JPanel();
        myBottomPanel.add(resetButton);
        myframe.add(myBottomPanel, BorderLayout.SOUTH);

        myframe.pack ();
        myframe.setVisible (true);
        myframe.setResizable (false);

    }

    private void drawFractal(){
        int x = 0;
        int y = 0;
        for (x = 0; x < windowSize; x++){
            double xCoord = fracGenerate.getCoord(range.x, range.x + range.width, windowSize, x);
            
            for (y = 0; y < windowSize; y++){
                double yCoord = fracGenerate.getCoord(range.y, range.y + range.height, windowSize, y);
                int numIters = fracGenerate.numIterations(xCoord, yCoord);
                int rgbColor;
                if (numIters == -1){
                    rgbColor = 0;
                }
                else{
                    float hue = 0.7f + (float) numIters / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }
                imgDisplay.drawPixel(x, y, rgbColor);
            }
        }
        imgDisplay.repaint();
    }

    private class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            if (command.equals("Reset Display")) {
                fracGenerate.getInitialRange(range);
                drawFractal();
            }
        }
    }

    private class MouseHandler extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            double xCoord = fracGenerate.getCoord(range.x, range.x + range.width, windowSize, x);
            
            int y = e.getY();
            double yCoord = fracGenerate.getCoord(range.y, range.y + range.height, windowSize, y);
            
            fracGenerate.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            
            drawFractal();
        }
    }

    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(800);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }

}

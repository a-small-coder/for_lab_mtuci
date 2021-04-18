package lab4;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;

public class FractalExplorer {
    private int windowSize;
    private JImageDisplay imgDisplay;
    private FractalGenerator fracGenerate;
    private Rectangle2D.Double range;

    private JButton resetButton;

    public FractalExplorer(int size){
        windowSize = size;
        fracGenerate = new Mandelbrot();
        range = new Rectangle2D.Double();
        fracGenerate.getInitialRange(range);
        imgDisplay = new JImageDisplay(windowSize, windowSize);
    }

    public void createAndShowGUI(){
        imgDisplay.setLayout(new BorderLayout());
        // create main frame
        JFrame myframe = new JFrame("Fractal Explorer"); 
        myframe.add(imgDisplay, BorderLayout.CENTER);
        // create a reset button
        resetButton = new JButton("Reset Display");
        myframe.add(imgDisplay, BorderLayout.CENTER);
        
        ButtonHandler resetHandler = new ButtonHandler();
        resetButton.addActionListener(resetHandler);
        
        
        MouseHandler click = new MouseHandler();
        imgDisplay.addMouseListener(click);

        myframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // create top and bottom panels with buttons and combo-box
        //top panel
        JPanel myBottomPanel = new JPanel();
        myBottomPanel.add(resetButton);
        myframe.add(myBottomPanel, BorderLayout.SOUTH);

        myframe.pack ();
        myframe.setVisible (true);
        myframe.setResizable (false);

    }

    public void drawFractal()
	{
		for (int x=0; x<windowSize; ++x){
			for (int y=0; y<windowSize; ++y){        
				double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, windowSize, x);
				double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, windowSize, y);  	
				//System.out.println(xCoord+ " " +yCoord);
				int iter = fracGenerate.numIterations(xCoord, yCoord);
				if (iter < 0) {
					imgDisplay.drawPixel(x, y, 0);
					continue;
				}
				float hue = 0.7f + (float) iter / 200f;
				int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
				imgDisplay.drawPixel(x, y, rgbColor);
			}
		}
		imgDisplay.repaint();
	}
	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fracGenerate.getInitialRange(range);
			drawFractal();
		}	
	}
	class MouseHandler extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			double x = FractalGenerator.getCoord(range.x, range.x+range.width, windowSize, e.getX());
			double y = FractalGenerator.getCoord(range.y, range.y+range.height, windowSize, e.getY());
			fracGenerate.recenterAndZoomRange(range, x, y, 0.5);
			drawFractal();
		}
	}
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }

}

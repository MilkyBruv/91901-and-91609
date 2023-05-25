package awtgl.window;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import awtgl.math.Vector2i;

public abstract class Renderer {

    public static void clear(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(g2d.getBackground());
        // g2d.setColor(new Color(0xffffff));
        g2d.fillRect(0, 0, 256, 128);

    }



    public static BufferedImage getTransparentImage(BufferedImage bufferedImage, float alpha) {

        BufferedImage transparentImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) transparentImage.getGraphics();
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

        g2d.setComposite(ac);
        g2d.drawImage(bufferedImage, 0, 0, null);
        g2d.dispose();

        return transparentImage;

    }



    public static void drawBlendImage(BufferedImage bufferedImage, Vector2i position, int rotation, int layers, Graphics g) {
    
        AffineTransform backup = new AffineTransform();
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(rotation), position.x + (bufferedImage.getWidth() / 2), position.y + (bufferedImage.getHeight() / 2));
        g2d.setTransform(a);

        int incr = 4;
        int j = 2;

        BufferedImage layerImage = new BufferedImage(bufferedImage.getWidth() + incr, bufferedImage.getHeight() + incr, BufferedImage.TYPE_INT_ARGB);
        BufferedImage prevLayerImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        float alpha = 1.0f / layers;

        for (int i = layers; i > 0; i--) {
            
            layerImage = new BufferedImage(prevLayerImage.getWidth() + incr, prevLayerImage.getHeight() + incr, BufferedImage.TYPE_INT_ARGB);
            prevLayerImage = layerImage;

            float currentAlpha = alpha * (i * 0.5f);

            Graphics2D ig2d = (Graphics2D) layerImage.getGraphics();
            ig2d.drawImage(Renderer.getTransparentImage(bufferedImage, currentAlpha), 0, 0, layerImage.getWidth(), layerImage.getHeight(), null);
            ig2d.dispose();

            g2d.drawImage(getBlurredImage(layerImage, 2), position.x - j - 1, position.y - j, null);

            j += 2;

        }

        g2d.drawImage(bufferedImage, position.x, position.y, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
        g2d.setTransform(backup);
        g2d.dispose();

    }



    private static BufferedImage getBlurredImage(BufferedImage originalImage, int blurRadius) {

        BufferedImage newImage = new BufferedImage(Math.round(originalImage.getWidth() * 1.5f), Math.round(originalImage.getHeight() * 1.5f), BufferedImage.TYPE_INT_ARGB);
        
        float[] blurKernel = new float[blurRadius * blurRadius];
        
        for (int i = 0; i < blurKernel.length; i++) {
        
            blurKernel[i] = 1.0f / blurKernel.length;
        
        }
        
        BufferedImageOp blurFilter = new ConvolveOp(new Kernel(blurRadius, blurRadius, blurKernel));
        BufferedImage blurredImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        blurredImage = blurFilter.filter(originalImage, blurredImage);
        
        return blurredImage;

    }
    
    

    public static void drawImage(BufferedImage bufferedImage, Vector2i position, int rotation, Graphics g) {
    
        AffineTransform backup = new AffineTransform();
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(rotation), position.x + (bufferedImage.getWidth() / 2), position.y + (bufferedImage.getHeight() / 2));

        g2d.setTransform(a);
        g2d.drawImage(bufferedImage, position.x, position.y, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
        g2d.setTransform(backup);
        g2d.dispose();

    }



    public static void drawImage(BufferedImage bufferedImage, Vector2i position, Vector2i size, int rotation, Graphics g) {
    
        AffineTransform backup = new AffineTransform();
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(rotation), position.x + (size.x / 2), position.y + (size.y / 2));

        g2d.setTransform(a);
        g2d.drawImage(bufferedImage, position.x, position.y, size.x, size.y, null);
        g2d.setTransform(backup);
        g2d.dispose();

    }



    public static void drawLine(Vector2i position1, Vector2i position2, int colour, Graphics g) {
    
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(colour));
        g2d.drawLine(position1.x, position1.y, position2.x, position2.y);
        g2d.dispose();

    }



    public static void drawRect(Vector2i position, Vector2i size, int rotation, int colour, Graphics g) {
    
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(rotation), position.x + (size.x / 2), position.y + (size.y / 2));

        g2d.setTransform(a);
        g2d.setColor(new Color(colour));
        g2d.drawRect(position.x, position.y, size.x, size.y);
        g2d.dispose();

    }



    public static void drawCircle(Vector2i position, int radius, int rotation, int colour, Graphics g) {
    
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(rotation), position.x + (radius), position.y + (radius));

        g2d.setTransform(a);
        g2d.setColor(new Color(colour));
        g2d.drawRoundRect(position.x, position.y, radius * 2, radius * 2, radius * 2, radius * 2);
        g2d.dispose();

    }



    public static void drawPoint(Vector2i position, int colour, Graphics g) {
    
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(new Color(colour));
        g2d.drawLine(position.x, position.y, position.x, position.y);
        g2d.dispose();

    }

}
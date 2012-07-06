package com.jasonwjones.jumbnail;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class ThumbnailHelper {

	public BufferedImage createThumbnail(String filename, int pixelWidth, int pixelHeight) throws Exception {
	
    	BufferedImage sourceImage = ImageIO.read(new File(filename));   
    	
    	BufferedImage image = new BufferedImage(pixelWidth, pixelHeight, BufferedImage.TYPE_INT_RGB);
    	Graphics2D graphics = image.createGraphics();
    	
    	graphics.setBackground(Color.WHITE);
    	graphics.clearRect(0, 0, pixelWidth, pixelHeight);
    	
    	//Scalr.Mode mode = sourceImage.getWidth() > sourceImage.getHeight() ? Scalr.Mode.FIT_TO_WIDTH : Scalr.Mode.FIT_TO_HEIGHT;
    	
    	BufferedImage resizedImage = Scalr.resize(sourceImage, Scalr.Mode.FIT_TO_WIDTH, pixelWidth, pixelHeight);
    	resizedImage = Scalr.resize(resizedImage, Scalr.Mode.FIT_TO_HEIGHT, pixelWidth, pixelHeight);
    	
    	//System.out.println("Resized image is " + resizedImage.getWidth() + " x " + resizedImage.getHeight());
    	
    	int xOffset = (int) ((pixelWidth / 2.0f) - (resizedImage.getWidth() / 2.0f));
    	int yOffset = (int) ((pixelHeight / 2.0f) - (resizedImage.getHeight() / 2.0f));
    	
    	graphics.drawImage(resizedImage, null, xOffset, yOffset);
    	
    	return image;    	
	}
	
	public void createThumbnail(String filename, String outputFilename, int pixelWidth, int pixelHeight) {
		try {
			BufferedImage resized;
			resized = createThumbnail(filename, pixelWidth, pixelHeight);
			ImageIO.write(resized, "jpg", new File(outputFilename));
		} catch (Exception e) {
			System.err.println("Could not make thumbnail: " + e.getMessage());
		}	
	}
	
}

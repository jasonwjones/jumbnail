package com.jasonwjones.jumbnail;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThumbnailHelper {

	private static final Logger logger = LoggerFactory.getLogger(ThumbnailHelper.class);

	public BufferedImage createThumbnail(String inputFilename, int pixelWidth, int pixelHeight) throws Exception {

		BufferedImage sourceImage = ImageIO.read(new File(inputFilename));

		BufferedImage image = new BufferedImage(pixelWidth, pixelHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();

		graphics.setBackground(Color.WHITE);
		graphics.clearRect(0, 0, pixelWidth, pixelHeight);

		BufferedImage resizedImage = Scalr.resize(sourceImage, Scalr.Mode.FIT_TO_WIDTH, pixelWidth, pixelHeight);
		resizedImage = Scalr.resize(resizedImage, Scalr.Mode.FIT_TO_HEIGHT, pixelWidth, pixelHeight);

		int xOffset = (int) ((pixelWidth / 2.0f) - (resizedImage.getWidth() / 2.0f));
		int yOffset = (int) ((pixelHeight / 2.0f) - (resizedImage.getHeight() / 2.0f));

		graphics.drawImage(resizedImage, null, xOffset, yOffset);

		return image;
	}

	public void createThumbnail(String filename, String outputFilename, int pixelWidth, int pixelHeight) {
		try {
			BufferedImage resized = createThumbnail(filename, pixelWidth, pixelHeight);
			ImageIO.write(resized, "jpg", new File(outputFilename));
		} catch (Exception e) {
			logger.error("Could not generate thumbnail: {}", e.getMessage());
		}
	}

	public void createThumbnail(String inputFile, File outputFile, int width, int height) throws Exception {
		BufferedImage resized = createThumbnail(inputFile, width, height);
		ImageIO.write(resized, "jpg", outputFile);
	}

}

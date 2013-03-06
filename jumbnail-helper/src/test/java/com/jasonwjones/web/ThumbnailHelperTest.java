package com.jasonwjones.web;

//import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Ignore;
import org.junit.Test;

import com.jasonwjones.jumbnail.ThumbnailHelper;

public class ThumbnailHelperTest {

	@Test
	@Ignore
	public void test() throws Exception {
		ThumbnailHelper th = new ThumbnailHelper();
		
		String filenames[] = {"saxifrage.jpeg", "purple.jpeg", "burnet.jpeg"};
		
		for (String filename : filenames) {
			System.out.println(filename);
			String fullFilename = getClass().getResource("/" + filename).getFile();
			BufferedImage resized = th.createThumbnail(fullFilename, 195, 133);	
			ImageIO.write(resized, "jpg", new File("thumb_" + filename));
			//fail("Not yet implemented");			
		}
		
	}

}

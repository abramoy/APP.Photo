package com.photo.helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageBuilderImpl implements ImageBuilder {
	
	@Value("${path.to.gallery.images}")
	String directory;
	
    private static final String[] EXTENSIONS = new String[]{
        "gif", "png", "bmp" , "jpg"
    };
    
    @Override
	public void getGalleryImages() {
		System.out.println("Hello " + directory);
		final File dir = new File(directory);
		final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
			@Override
	        public boolean accept(final File dir, final String name) {
	            for (final String ext : EXTENSIONS) {
	                if (name.endsWith("." + ext)) {
	                    return (true);
	                }
	            }
	            return (false);
	        }
	    };
		
		if (dir.isDirectory()) {
	        for (final File f : dir.listFiles(IMAGE_FILTER)) {
	            BufferedImage img = null;

	            try {
	                img = ImageIO.read(f);
	                System.out.println("image: " + f.getName());
	                System.out.println(" Absolute Path  : " + f.getAbsolutePath());
	                System.out.println(" Conical Path  : " + f.getCanonicalPath());
	            } catch (final IOException e) {
	               
	            }
	        }
	    }

	   
	    

	}
}
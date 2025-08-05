package com.daddy_support.zombie_survival.resource_loader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class SpriteLoader {
    public static BufferedImage GetResourceImage(String fileName){
        BufferedImage image = null;
        try (InputStream inputStream = SpriteLoader.class.getResourceAsStream("/img/" + fileName)) {
            if(inputStream == null){
                throw new IOException("Image not found");
            }
            image = ImageIO.read(inputStream);
        }catch (Exception e){
            System.out.println("Exception occurred when loading image. Error : "+ e.getMessage());
        }
        return image;
    }
}

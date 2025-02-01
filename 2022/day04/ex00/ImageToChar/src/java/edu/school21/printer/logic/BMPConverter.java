// Copyright 2025 stranger

package edu.school21.printer.logic;

import java.awt.*;
import java.io.*;
import java.nio.file.Path;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BMPConverter{
    final static int colorWhite = Color.WHITE.getRGB();
    final static int colorBlack = Color.BLACK.getRGB();

    public static void toCharArray(final Path path){
        try{
            final BufferedImage image = ImageIO.read(new File(path.toString()));

            final int hei = image.getHeight();
            final int wid = image.getWidth();

            for(int y = 0; y < hei; ++y){
                for(int x = 0; x < wid; ++x){
                    final int pixelColor = image.getRGB(x, y);

                    if(pixelColor == colorWhite){
                        System.out.print(".");
                    }
                    else if(pixelColor == colorBlack){
                        System.out.print("O");
                    }
                }

                System.out.println();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
// Copyright 2025 stranger

package edu.school21.printer.logic;

import java.awt.*;
import java.io.*;
import java.nio.file.Path;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

// Для работы с библиотекой JCDP
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public class BMPConverter{
    final static int colorWhite = Color.WHITE.getRGB();
    final static int colorBlack = Color.BLACK.getRGB();

    public static void toCharArray(final Path path, final Args parameters){
        try{
            final BufferedImage image = ImageIO.read(new File(path.toString()));

            final String white = parameters.white();
            final String black = parameters.black();

            final int hei = image.getHeight();
            final int wid = image.getWidth();

            ColoredPrinter printer = new ColoredPrinter();

            for(int y = 0; y < hei; ++y){
                for(int x = 0; x < wid; ++x){
                    final int pixelColor = image.getRGB(x, y);

                    if(pixelColor == colorWhite){
                        printer.print(" ", 
                            Ansi.Attribute.NONE, 
                            Ansi.FColor.NONE, 
                            Ansi.BColor.valueOf(white));
                    }
                    else if(pixelColor == colorBlack){
                        printer.print(" ", 
                            Ansi.Attribute.NONE, 
                            Ansi.FColor.NONE, 
                            Ansi.BColor.valueOf(black));
                    }
                }

                System.out.println();
            }
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
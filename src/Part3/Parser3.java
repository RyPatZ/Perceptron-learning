package Part3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.*;

/**
 * The type Parser 3.
 */
public class Parser3 {

    private List <Image> imageList = new ArrayList<>();

    /**
     * Instantiates a new Parser 3.
     *
     * @param FilePath the file path
     */
    public Parser3(String FilePath){
        parseImage(FilePath);
    }

    /**
     * Parse image.
     *
     * @param filePath the file path
     */
    public void parseImage(String filePath){
        try {
            Scanner s = new Scanner(new File(filePath));
            while (s.hasNext()) {
                String next = s.next();
                if((next.equals("P1"))){
                    String comment = s.next();
                    int width = s.nextInt();
                    int height = s.nextInt();
                    java.util.regex.Pattern bit = java.util.regex.Pattern.compile("[01]");
                    boolean [][] newimage = new boolean[width][height];
                    for (int r = 0; r < width; r++) {
                        for (int c = 0; c < height; c++) {
                            newimage[r][c] = (s.findWithinHorizon(bit, 0).equals("1"));
                            //System.out.println(newimage[r][c]);
                        }
                    }
                    Image image = new Image(width,height,comment,newimage);
                    imageList.add(image);
                }
            }
            s.close();
        } catch (IOException e) {
            throw new RuntimeException("Data File caused IO exception");
        }
    }

    /**
     * Gets image list.
     *
     * @return the image list
     */
    public List<Image> getImageList() {
        return imageList;
    }
}


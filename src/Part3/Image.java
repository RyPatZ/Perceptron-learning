package Part3;

/**
 * The type Image.
 */
public class Image {
    /**
     * The Width.
     */
    int width;
    /**
     * The Height.
     */
    int height;
    /**
     * The Comment.
     */
    String comment;
    /**
     * The Image pix.
     */
    boolean [][] imagePix;

    /**
     * Instantiates a new Image.
     *
     * @param width    the width
     * @param height   the height
     * @param comment  the comment
     * @param imagePix the image pix
     */
    public Image(int width, int height, String comment, boolean[][] imagePix) {
        this.width = width;
        this.height = height;
        this.comment = comment;
        this.imagePix = imagePix;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Get image pix boolean [ ] [ ].
     *
     * @return the boolean [ ] [ ]
     */
    public boolean[][] getImagePix() {
        return imagePix;
    }
}

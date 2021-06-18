package Part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The type Feature.
 */
public class Feature {
    private int[] rows;
    private int[] cols;
    private boolean[] sgn;
    /**
     * The Random.
     */
    Random random;
    /**
     * The Is dummy.
     */
    boolean isDummy;
    /**
     * The Values.
     */
    List<Integer>values = new ArrayList<>();

    /**
     * Instantiates a new Feature.
     *
     * @param width     the width
     * @param height    the height
     * @param randomVal the random val
     */
    public Feature(int width, int height, Random randomVal) {
        this.rows = new int[3];
        this.cols = new int[3];
        this.random = randomVal;
        this.sgn = new boolean[3];
        this.isDummy = false;


        for (int i = 0; i < rows.length; i++) {
            int row = random.nextInt(width);
            this.rows[i] = row;
        }
        for (int i = 0; i < cols.length; i++) {
            int col = random.nextInt(height);
            this.cols[i] = col;
        }
        for (int i = 0; i < sgn.length; i++) {
            boolean pixel = random.nextBoolean();
            this.sgn[i] = pixel;
        }
    }

    /**
     * Instantiates a new Feature.
     */
    public Feature(){
        isDummy= true;
    }


    /**
     * Gets value.
     *
     * @param img the img
     * @return the value
     */
    public int getValue(Image img) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            boolean[][] imgPix = img.getImagePix();


            if ( imgPix[rows[i]][cols[i]]==sgn[i]){
                sum++;
            }
        }
        return (sum >= 2) ? 1 : 0;
    }


    /**
     * Get rows int [ ].
     *
     * @return the int [ ]
     */
    public int[] getRows() {
        return rows;
    }

    /**
     * Get cols int [ ].
     *
     * @return the int [ ]
     */
    public int[] getCols() {
        return cols;
    }

    /**
     * Get sgn boolean [ ].
     *
     * @return the boolean [ ]
     */
    public boolean[] getSgn() {
        return sgn;
    }

    /**
     * Is dummy boolean.
     *
     * @return the boolean
     */
    public boolean isDummy() {
        return isDummy;
    }

    /**
     * Gets values.
     *
     * @return the values
     */
    public List<Integer> getValues() {
        return values;
    }

    /**
     * Gets random.
     *
     * @return the random
     */
    public Random getRandom() {
        return random;
    }

    /**
     * Add value.
     *
     * @param v the v
     */
    public void addValue(int v){
        this.values.add(v);

    }

    @Override
    public String toString() {
        return "Feature{" +
                "rows=" + Arrays.toString(rows) +
                ", cols=" + Arrays.toString(cols) +
                ", sgn=" + Arrays.toString(sgn) +
                '}';
    }
}

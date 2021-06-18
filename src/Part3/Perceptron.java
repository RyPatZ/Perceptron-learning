package Part3;

import Part2.Instance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The type Perceptron.
 */
public class Perceptron {

    /**
     * The Image list.
     */
    List<Image> imageList = new ArrayList<>();
    /**
     * The Feature num.
     */
    int featureNum = 50;
    /**
     * The Feature list.
     */
    List<Feature> featureList = new ArrayList<>();
    /**
     * The Weight.
     */
    double weight[] = new double[featureNum + 1];
    /**
     * The Correctness count.
     */
    int correctness_count=0;
    /**
     * The Attempts.
     */
    int attempts=0;
    /**
     * The Attempts before converging.
     */
    int attemptsBeforeConverging =150;

    /**
     * Instantiates a new Perceptron.
     *
     * @param filePath the file path
     */
    public Perceptron(String filePath) {
        Parser3 parser = new Parser3(filePath);
        imageList = parser.getImageList();
        featureList.add(new Feature());
        for (int i = 0; i < featureNum; i++) {
            Feature feature = new Feature(10, 10, new Random());
            featureList.add(feature);
        }

        for (Feature f : featureList) {
            for (Image img : imageList) {
                if (!f.isDummy())
                    f.addValue(f.getValue(img));
                else
                    f.addValue(1); // adds dummy value
            }
        }
        Apply_Perceptron_Algorithm();

        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Number of training iterations to convergence = " +attempts);
        System.out.println("Number of correct classification = " +correctness_count);
        double accuracy = (double)correctness_count/(double) imageList.size();
        System.out.printf("Accuracy= %.2f%%", accuracy);
        //System.out.printf("accuracy = %.2f%% " + accuracy);
        System.out.println("\n The number of images that classified wrongly = " + (imageList.size() - correctness_count));
        System.out.println("-----------------------------------------------");
        System.out.println("Ramdom feaure created: ");
        for (Feature f :featureList){
            System.out.println(f.toString());
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Final Weight set: ");

        System.out.println("weight=" + Arrays.toString(weight));

    }


    /**
     * Apply perceptron algorithm.
     */
    public void  Apply_Perceptron_Algorithm(){
        while (correctness_count<imageList.size() && attempts<attemptsBeforeConverging){
            correctness_count=0;
            int countI =0;
            for(Image img: imageList) {
                String classOfImage = img.getComment();
                String classification;
                double predict = 0.0;
                int countF =0;
                for(Feature feature:featureList){
                    predict += ((double) (feature.getValues().get(countI)) * weight[countF]);
                    countF++;
                }
                if (predict > 0) {
                    classification = "#X";
                } else {
                    classification = "#O";
                }
                if(classification.equals(classOfImage)){
                    correctness_count++;
                }
                else if (classOfImage.equals("#O")) { // if Weights high --change
                    for (int i = 0; i < featureList.size(); i++) {
                        double Weight = weight[i];
                        double newWeight = Weight- featureList.get(i).getValues().get(countI);
                        weight[i] = newWeight; // replace the current weight with new
                    }

                }
                else if (classOfImage.equals("#X")) { // if Weights low --change
                    for (int i = 0; i < featureList.size(); i++) {
                        double Weight = weight[i];
                        double newWeight = Weight +featureList.get(i).getValues().get(countI);
                        weight[i] = newWeight; // replace the current weight with new
                    }
                }
                countI++;
            }
            attempts++;
        }
    }
}

import weka.core.AttributeStats;
import weka.core.Instances;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {


    public static Instances loadData(String filepath) {

        Instances train;
        try {
            FileReader reader = new FileReader(filepath);
            train = new Instances(reader);
            return train;
        }
        catch(Exception e) {
            System.out.println("Exception caught: "+e);
            return null;
        }
    }

    public static void main(String[] args) {
	// write your code here
        String dataLocation = "./Arsenal_TRAIN.arff";

        Instances train_data = loadData(dataLocation);
        Instances test_data = loadData("./Arsenal_TEST.arff");

        AttributeStats attributeStats = train_data.attributeStats(test_data.numAttributes() - 1);
        int numWins = attributeStats.nominalCounts[2]; // Wins are represented by 2

        System.out.println(train_data.numInstances());
        System.out.println(test_data.numAttributes());
        System.out.println(numWins);
        System.out.println(train_data.instance(4));
        System.out.println(train_data.toSummaryString());

    }
}

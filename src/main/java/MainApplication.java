import entities.CsvProcessor;
import entities.TestModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) throws Exception{
        String filePath = "src/main/java/test.csv";
        CsvProcessor processor = new CsvProcessor();
        List<TestModel> models = processor.parseCsv(new BufferedReader(new FileReader(filePath)), ",", TestModel.class);
        System.out.println("First model " + models.get(0));
    }
}

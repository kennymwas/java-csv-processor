package entities;

import org.apache.log4j.Logger;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvProcessor {

    final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Improve efficiency current working with O(n3) not accounting for library methods
     *
     * @param <T>
     * @param reader
     * @param separator
     * @param clazz
     * @return
     * @throws InstantiationException
     * @throws IOException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws FileNotFoundException
     */
    public <T> List<T> parseCsv(BufferedReader reader, String separator, Class<T> clazz) throws InstantiationException, IOException, IllegalAccessException, NoSuchFieldException, FileNotFoundException {

        List<T> records = new ArrayList<T>();
        String line = null;
        int count = 0;
        List<String> csvFields = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            T t = clazz.newInstance();
            String[] lineContents = line.split(separator);
            //getting the headers
            if (count == 0) {
                for (String entry : lineContents) {
                    for (Field f : clazz.getDeclaredFields()) {
                        if (f.isAnnotationPresent(CsvColumn.class) && f.getName().equalsIgnoreCase(entry)) {
                            csvFields.add(f.getName());
                        }
                    }

                }
                count++;
                continue;
            }
            for(int i = 0; i < lineContents.length; i++){
                Field f = t.getClass().getDeclaredField(csvFields.get(i));
                f.setAccessible(true);
                //handle data type conversion
                f.set(t, lineContents[i]);
            }
            records.add(t);
            count++;
        }
        return records;
    }

}

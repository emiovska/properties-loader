package processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class PropertiesFileLoader {

    private static final String SEPARATOR = File.separator;
    private static final String PROPERTY_SPLITTER = "=";
    private static final String USER_DIR = "user.dir";


    public static void loadPropertiesFromFile(String filePath, Map<String, Object> propertiesByKey) {
        String userDir = System.getProperty(USER_DIR);
        String globalFilePath = userDir + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + filePath;
        File file = new File(globalFilePath);
        if (file.exists()) {
            String line;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while ((line = reader.readLine()) != null) {
                    if (!line.isEmpty()) {
                        String[] parts = line.split(PROPERTY_SPLITTER);
                        if (parts.length == 2) {
                            propertiesByKey.put(parts[0].trim(), parts[1].trim());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Does not exist");
        }
    }
}

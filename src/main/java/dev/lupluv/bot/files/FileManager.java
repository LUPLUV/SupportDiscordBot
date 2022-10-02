package dev.lupluv.bot.files;

import org.simpleyaml.configuration.file.FileConfiguration;
import org.simpleyaml.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.apache.commons.io.IOUtils.DEFAULT_BUFFER_SIZE;

public class FileManager {

    private static FileManager instance;

    public static FileManager getInstance() {
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }

    public static void loadFiles(){
        if(!new File("config.yml").exists()) {
            try {
                getInstance().copyResourceFile("config.yml", "config.yml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static FileConfiguration getConfig(){
        try {
            return YamlConfiguration.loadConfiguration(new File("config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void copyResourceFile(String src, String dest) throws IOException {
        InputStream resourceURL = this.getClass().getResourceAsStream("/defaults/" + src);

        File file2 = new File(dest);

        copyInputStreamToFile(resourceURL, file2);

    }

    private static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {

        // append = false
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

    }

}

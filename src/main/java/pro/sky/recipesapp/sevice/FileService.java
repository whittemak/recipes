package pro.sky.recipesapp.sevice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pro.sky.recipesapp.model.Recipe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;

@Service
public class FileService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Path filesDir;
    public <objectMapper> FileService(@Value("${app.files.dir}") Path filesDir) {
        this.filesDir = filesDir;
    }
    public <T> void saveToFile(String fileName, T objectToSave) throws IOException {
        try {
            String json = objectMapper.writeValueAsString(objectToSave);
            Files.createDirectories(filesDir);
            Path filePath = filesDir.resolve(fileName +  ".json");
            Files.deleteIfExists(filePath);
            Files.createFile(filePath);
            Files.writeString(filePath, json);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public <T> T readFromFile(String fileName, TypeReference<T> typeReference){
        Path filePath = filesDir.resolve(fileName + ".json");
        if (!Files.exists(filePath)){
            return null;
        }
        try {
            String jsonString = Files.readString(filePath);
            T obj = objectMapper.readValue(jsonString, typeReference);
            return obj;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public Resource getResource(String fileName) {
        Path filePath = filesDir.resolve(fileName + ".json");
        return new FileSystemResource(filePath);
    }
    public void saveResource(String fileName, Resource resource){
        Path filePath = filesDir.resolve(fileName + ".json");
        try {
            Files.copy(resource.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

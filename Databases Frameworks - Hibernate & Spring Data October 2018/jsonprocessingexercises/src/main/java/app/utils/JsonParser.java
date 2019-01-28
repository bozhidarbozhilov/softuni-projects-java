package app.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component
public class JsonParser implements Parser{
    private static Gson gson;

    static {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Bean
    public Gson gson(){
        return gson;
    }

    public <T> T importFromFile(Class<T> klass, String file) {
        return gson.fromJson(file, klass);
    }

    public String exportToFile(Object object){
        return gson.toJson(object);
    }

}

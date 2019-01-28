package app.utils;

import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class JsonParser implements Parser{
    private static Gson gson;

    static {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
                .create();
    }

    @Bean
    public Gson gson(){
        return gson;
    }

    @Override
    public <T> T importFromFile(Class<T> klass, String file) {
        return gson.fromJson(file, klass);
    }

    @Override
    public String exportToFile(Object object) {
        return gson.toJson(object);
    }
}

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.asgio.usdafooddatawrapper.domain.Food;
import net.asgio.usdafooddatawrapper.domain.Nutrient;
import net.asgio.usdafooddatawrapper.parser.FoodAdapter;
import net.asgio.usdafooddatawrapper.parser.NutrientAdapter;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AdapterTest {
    @Test
    public void testParseFoodList() throws IOException {
        System.out.println("x");

        ClassLoader classLoader = this.getClass().getClassLoader();
        String fileName = "sample.json";
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        }

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Food.class, new FoodAdapter())
                .registerTypeAdapter(Nutrient.class, new NutrientAdapter())
                .create();
        try {
            Type foodListType = new TypeToken<ArrayList<Food>>() {
            }.getType();
            ArrayList<Food> food = gson.fromJson(textBuilder.toString(), foodListType);

            for (Food f : food) {
                System.out.println(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

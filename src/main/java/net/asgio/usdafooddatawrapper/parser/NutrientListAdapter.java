package net.asgio.usdafooddatawrapper.parser;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.asgio.usdafooddatawrapper.domain.Nutrient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NutrientListAdapter extends TypeAdapter<List<Nutrient>>{
    @Override
    public void write(JsonWriter out, List<Nutrient> value) throws IOException {
        //TODO
    }

    @Override
    public List<Nutrient> read(JsonReader in) throws IOException {
        List<Nutrient> list = new ArrayList<>();
        in.beginArray();

        while (in.hasNext()) {
            list.add(new NutrientAdapter().read(in));
        }
        in.endArray();
        return list;
    }
}


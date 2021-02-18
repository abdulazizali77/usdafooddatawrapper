package net.asgio.usdafooddatawrapper.parser;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.asgio.usdafooddatawrapper.domain.Nutrient;

import java.io.IOException;

public class NutrientAdapter extends TypeAdapter<Nutrient> {
    @Override
    public void write(JsonWriter out, Nutrient value) throws IOException {
        //TODO:
    }

    @Override
    public Nutrient read(JsonReader in) throws IOException {
        Nutrient obj = new Nutrient();
        if (in != null) {
            in.beginObject();
            while (in.hasNext()) {
                String name = in.nextName();
                if (name.equals("number")) {
                    obj.number = in.nextLong();
                } else if (name.equals("name")) {
                    obj.name = in.nextString();
                } else if (name.equals("amount")) {
                    obj.amount = in.nextDouble();
                } else if (name.equals("unitName")) {
                    obj.unitName = in.nextString();
                } else if (name.equals("derivationCode")) {
                    obj.derivationCode = in.nextString();
                } else if (name.equals("derivationDescription")) {
                    obj.derivationDescription = in.nextString();
                } else {
                    in.skipValue();
                }
            }
            in.endObject();
        }
        return obj;
    }
}

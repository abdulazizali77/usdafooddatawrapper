package net.asgio.usdafooddatawrapper.parser;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.asgio.usdafooddatawrapper.domain.Food;

import java.io.IOException;
import java.sql.Date;

public class FoodAdapter extends TypeAdapter<Food> {
    @Override
    public void write(JsonWriter out, Food value) throws IOException {

    }

    @Override
    public Food read(JsonReader in) throws IOException {
        Food obj = new Food();
        if (in != null) {
            in.beginObject();
            while(in.hasNext()){
                String name = in.nextName();
                //hits object

                if(name.equals("fdcId")) {
                    obj.fdcId = in.nextLong();
                } else if(name.equals("description")){
                    obj.description = in.nextString();
                } else if(name.equals("dataType")){
                    obj.dataType = in.nextString();
                } else if(name.equals("publicationDate")){
                    //FIXME: type checking
                    try{
                        String dateStr = in.nextString();
                        obj.publicationDate = Date.valueOf(dateStr);//new DateTypeAdapter().read(in);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                } else if(name.equals("ndbNumber")){
                    obj.ndbNumber = in.nextLong();
                } else if(name.equals("foodNutrients")){
                    obj.nutrients = new NutrientListAdapter().read(in);
                }else{
                    in.skipValue();
                }
            }
            in.endObject();

            //return readSource(reader);
        }

        return obj;
    }
}

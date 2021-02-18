package net.asgio.usdafooddatawrapper.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
*     "fdcId": 174819,
    "description": "Alcoholic beverage, distilled, whiskey, 86 proof",
    "dataType": "SR Legacy",
    "publicationDate": "2019-04-01",
    "ndbNumber": "14052",
* */
public class Food {
    public Long fdcId;
    public Long ndbNumber;
    public String description;
    public String dataType;
    //FIXME
    public Date publicationDate = new Date();
    public List<Nutrient> nutrients = new ArrayList<>();

    @Override
    public String toString() {
        //TODO
        return super.toString();
    }
}

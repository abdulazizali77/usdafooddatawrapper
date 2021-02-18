package net.asgio.usdafooddatawrapper.domain;

/*
* "number": "431",
            "name": "Folic acid",
            "amount": 0E-8,
            "unitName": "UG",
            "derivationCode": "Z",
            "derivationDescription": "Assumed zero (Insignificant amount or not naturally occurring in a food, such as fiber in meat)"
* */
public class Nutrient {
    public Long number;
    public String name;
    public Double amount;
    public String unitName;
    public String derivationCode;
    public String derivationDescription;
}

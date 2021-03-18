package model;

public class Country extends Location {
    private Currency currency;

    public Country(boolean doesExist, boolean canBeRealized, String name, Currency currency) {
        super(doesExist, canBeRealized, name);
        this.currency = currency;
    }

    @Override
    public boolean realizeIfExists(){
        if (!doesExist)
            currency.crashMarketValue();
        return !doesExist && canBeRealized;
    }
}

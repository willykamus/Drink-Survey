package model;

import java.io.Serializable;

public class Survey implements Serializable {

    private int clientId;
    private String drinkType;
    private String drink;
    private int cupsPerDay;

    public Survey(int clientId, String drinkType, String drink, int cupsPerDay) {
        this.clientId = clientId;
        this.drinkType = drinkType;
        this.drink = drink;
        this.cupsPerDay = cupsPerDay;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public int getCupsPerDay() {
        return cupsPerDay;
    }

    public void setCupsPerDay(int cupsPerDay) {
        this.cupsPerDay = cupsPerDay;
    }
}

package com.homeworks.phones;

/**
 * Created by Mihail Kolomiets on 27.05.18.
 * <p>
 * Allows use phone but just provide version
 */
public class OperationSystem {

    private double version;

    public OperationSystem(double version) {
        this.version = version;
    }

    public double getVersion() {
        return version;
    }

    /**
     * @return true if phone is android
     */
    public boolean itsAndroid(Phone phone) {
        String pathClass = phone.getClass().toGenericString();//get path of class like homework2.homeworks.AndroidSeries
        String[] series = pathClass.split("\\."); //split string by dot
        return series[2].equals("AndroidSeries");
    }

}

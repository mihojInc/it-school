package com.lessons;

public enum Production {
    MILK("milk", 2000),
    MEAT("meat", 3000),
    FISH("fish", 1000);

    private String name;
    private long timeProd;

    Production(String name, long timeProd) {
        this.name = name;
        this.timeProd = timeProd;
    }

    public String getName() {
        return name;
    }

    public long getTimeProd() {
        return timeProd;
    }

    public Producer createProducer(Store store){
        Producer newProducer = new Producer(this.getName(),this.timeProd,store);
        return newProducer;
    }

    public Producer_Version2 createProducer2(Store_Version2 store_version2){
        Producer_Version2 producer_version2 = new Producer_Version2(this.getName(),this.getTimeProd(),store_version2);
        return producer_version2;
    }
}

package utils;

public enum  Const {

    CONSUMER_KEY(""),
    CONSUMER_SECRET(""),
    ACCESS_TOKEN(""),
    ACCESS_SECRET("");

    private String key;

    Const(String key){
        this.key =key;
    }

    public String getKey() {
        return key;
    }
}

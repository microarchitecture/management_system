package util;

public enum NavigationTreeNodeProperties {

    ID("ID"),
    NODE_NAME("NODE_NAME"),
    NODE_TYPE("NODE_TYPE"),
    PARENT("PARENT");

    private String value;

    NavigationTreeNodeProperties(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

package com.demo.numberconverter.enums;

public enum Format {
    DECIMAL("d", "decimal"),
    BINARY("b", "binary");

    private String simpleName;
    private String completeName;

    Format(String simpleName, String completeName) {
        this.simpleName = simpleName;
        this.completeName = completeName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getCompleteName() {
        return completeName;
    }
}

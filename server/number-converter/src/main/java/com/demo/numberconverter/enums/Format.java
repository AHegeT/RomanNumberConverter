package com.demo.numberconverter.enums;

public enum Format {
    DECIMAL("d"),
    BINARY("b");

    private String simpleName;

    Format(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getSimpleName() {
        return simpleName;
    }
}

package com.mikerandrup.essaycomposable.components;

public class BaseComponent {
    protected String value = null;

    public boolean isSet() {
        return value != null;
    }

    @Override
    public String toString() {
        return isSet() ? value : "";
    }
}

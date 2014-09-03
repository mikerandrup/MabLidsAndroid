package com.mikerandrup.essaycomposable.components;

public class BaseComponent {
    protected String value = null;

    public boolean isNotAnswered() {
        return value != null;
    }

    @Override
    public String toString() {
        return isNotAnswered() ? value : "";
    }
}

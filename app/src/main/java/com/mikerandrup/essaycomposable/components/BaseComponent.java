package com.mikerandrup.essaycomposable.components;

public class BaseComponent {
    protected String value;
    public void setValue(String val) {
        value = val;
    }

    public String getWordType() {
        return this.getClass().getSimpleName().toString();
    }
    public boolean isNotAnswered() {
        return value == null;
    }

    @Override
    public String toString() {
        return isNotAnswered() ? "" : value;
    }
}

package com.mikerandrup.essaycomposable.components.dynamicwords;

import com.mikerandrup.essaycomposable.components.BaseComponent;

public class DynamicWordComponent extends BaseComponent {
    public DynamicWordComponent() {
        value = null;
    }

    public DynamicWordComponent(String hint) {
        hintText = hint;
        value = null;
    }

    protected String hintText = "";

    public String getWordType() {
        return this.getClass().getSimpleName().toString();
    }

    public String getWordTypeAndHint() {
        return getWordType() + ((hintText=="") ? "" : (" ("+hintText+")"));
    }
}
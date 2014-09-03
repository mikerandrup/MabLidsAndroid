package com.mikerandrup.essaycomposable.components.dynamicwords;

import com.mikerandrup.essaycomposable.components.BaseComponent;

public class DynamicWordComponent extends BaseComponent {

    public void SetValue(String val) {
        value = val;
    }
    public String GetWordType() {
        return this.getClass().getSimpleName().toString();
    }
}
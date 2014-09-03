package com.mikerandrup.essaycomposable;

import com.mikerandrup.essaycomposable.components.BaseComponent;
import java.util.ArrayList;
import java.util.List;

public class Essay {

    public Essay() {
        components = new ArrayList<BaseComponent>();
    }

    private List<BaseComponent> components;
}



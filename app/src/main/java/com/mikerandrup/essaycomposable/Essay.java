package com.mikerandrup.essaycomposable;

import com.mikerandrup.essaycomposable.components.BaseComponent;
import java.util.ArrayList;
import java.util.List;

public class Essay {

    public Essay() {
        components = new ArrayList<BaseComponent>();
    }
    private List<BaseComponent> components;

    public Essay Append(BaseComponent comp) {
        components.add(comp);
        return this;
    }

    public boolean HasUnansweredComponent() {
        for (BaseComponent c : components) {
            if (c.isNotAnswered()) {
                return true;
            }
        }
        return false;
    }

    public BaseComponent GetNextUnansweredComponent() {
        for (BaseComponent c : components) {
            if (c.isNotAnswered()) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (BaseComponent c : components) {
            sb.append(c.toString());
        }

        return sb.toString();
    }
}



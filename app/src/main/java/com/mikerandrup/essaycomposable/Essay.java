package com.mikerandrup.essaycomposable;

import com.mikerandrup.essaycomposable.components.BaseComponent;
import java.util.ArrayList;
import java.util.List;

public class Essay {

    public Essay(String title) {
        components = new ArrayList<BaseComponent>();
        _essayTitle = title;
    }
    private List<BaseComponent> components;

    private String _essayTitle;
    public String getEssayTitle() {
        return _essayTitle;
    }

    public Essay append(BaseComponent comp) {
        components.add(comp);
        return this;
    }

    public boolean hasUnansweredComponent() {
        for (BaseComponent c : components) {
            if (c.isNotAnswered()) {
                return true;
            }
        }
        return false;
    }

    public BaseComponent getNextUnansweredComponent() {
        for (BaseComponent c : components) {
            if (c.isNotAnswered()) {
                return c;
            }
        }
        return null;
    }

    public int getUnansweredCount() {
        int unansweredCount = 0;
        for (BaseComponent c : components) {
            if (c.isNotAnswered()) {
                unansweredCount++;
            }
        }
        if (unansweredCount > _maxUnanswered)
            _maxUnanswered = unansweredCount;

        return unansweredCount;
    }

    private int _maxUnanswered = 0;
    public int getMaxUnansweredCount() {
        if (_maxUnanswered == 0)
            getUnansweredCount();

        return _maxUnanswered;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("This Essay is titled '" + getEssayTitle() + "':\n\n");

        for (BaseComponent c : components) {
            sb.append(c.toString());
        }

        return sb.toString();
    }
}



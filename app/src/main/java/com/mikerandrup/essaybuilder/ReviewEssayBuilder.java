package com.mikerandrup.essaybuilder;

import com.mikerandrup.essaycomposable.Essay;
import com.mikerandrup.essaycomposable.components.StaticComponent;
import com.mikerandrup.essaycomposable.components.dynamicwords.Adjective;
import com.mikerandrup.essaycomposable.components.dynamicwords.Noun;
import com.mikerandrup.essaycomposable.components.dynamicwords.Verb;

public class ReviewEssayBuilder {

    public Essay build() {
        return new Essay()
                .append(new Noun("proper"))
                .append(new StaticComponent(" is the best app I've ever "))
                .append(new Verb("past"))
                .append(new StaticComponent(" with in all my "))
                .append(new Adjective())
                .append(new StaticComponent(" life as a user.  Furthermore, it "))
                .append(new Verb("present"))
                .append(new StaticComponent(" just like a "))
                .append(new Noun())
                .append(new StaticComponent(" right after a summer rain storm.  Prepare for all the sales "))
                .append(new Noun("plural"))
                .append(new StaticComponent(" on Google Play to be "))
                .append(new Verb("past"))
                .append(new StaticComponent(" away."));
    }
}

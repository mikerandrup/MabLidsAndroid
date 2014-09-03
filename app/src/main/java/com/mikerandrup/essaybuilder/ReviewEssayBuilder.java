package com.mikerandrup.essaybuilder;

import com.mikerandrup.essaycomposable.Essay;
import com.mikerandrup.essaycomposable.components.StaticComponent;
import com.mikerandrup.essaycomposable.components.dynamicwords.Adjective;
import com.mikerandrup.essaycomposable.components.dynamicwords.Noun;
import com.mikerandrup.essaycomposable.components.dynamicwords.Verb;

public class ReviewEssayBuilder {

    public Essay Build() {
        return new Essay()
                .Append(new Noun())
                .Append(new StaticComponent(" is the best app I've ever "))
                .Append(new Verb())
                .Append(new StaticComponent(" with in all my "))
                .Append(new Adjective())
                .Append(new StaticComponent(" life as a user.  Furthermore, it "))
                .Append(new Verb())
                .Append(new StaticComponent(" just like a "))
                .Append(new Noun())
                .Append(new StaticComponent(" right after a summer rain storm.  Prepare for all the sales "))
                .Append(new Noun())
                .Append(new StaticComponent(" on Google Play to be "))
                .Append(new Verb())
                .Append(new StaticComponent(" away."));
    }
}

package com.mikerandrup.essaybuilder;

import com.mikerandrup.essaycomposable.Essay;
import com.mikerandrup.essaycomposable.components.StaticComponent;
import com.mikerandrup.essaycomposable.components.dynamicwords.Adjective;
import com.mikerandrup.essaycomposable.components.dynamicwords.Noun;
import com.mikerandrup.essaycomposable.components.dynamicwords.Verb;
import com.mikerandrup.essaycomposable.components.dynamicwords.Number;

public class AppReviewEssayBuilder {

    public Essay build() {
        return new Essay()
                .append(new Number())
                .append(new StaticComponent(" out of 5 stars! "))
                .append(new Adjective())
                .append(new Noun("plural"))
                .append(new StaticComponent(" is the best app I've ever seen in all my "))
                .append(new Adjective())
                .append(new StaticComponent(" time as a smart phone user. Furthermore, it gives me that "))
                .append(new Adjective())
                .append(new StaticComponent(" feeling all over.  Prepare for all the sales records in Google Play to be completely "))
                .append(new Verb("past"))
                .append(new StaticComponent(" away."));
    }
}

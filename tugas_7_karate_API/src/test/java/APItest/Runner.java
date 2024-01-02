package APItest;

import com.intuit.karate.junit5.Karate;

public class Runner {
    @Karate.Test
    public Karate runTestGet() {
        return Karate.run("testCase").relativeTo(getClass());
    }
}

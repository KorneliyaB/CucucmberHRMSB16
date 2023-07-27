package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the features files
        features = "src/test/resources/features/",
        //glue keyword we use to provide the path of the package where steps defs are available
        glue = "steps",
        //it stops actual execution,it quickly scans all the steps and
        // will provide the missing step definition
        dryRun = true,
        tags = "@addJob",
        //it means sometimes the console output for cucumber test is having some
        //irrelevant information, when you set it to true, it removes all that
        //irrelevant information from the console and will give you simple output
        monochrome = true,
        //it used to print all the steps in console
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
                "rerun:target/failed.txt"}
)




public class RunnerClass {

}

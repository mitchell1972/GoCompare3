package com.cucumber2.MavenCucumber2;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "json:target/json/output_MotorBikeGetQuotes.json"},
		features = "src/test/resource",
		tags = {" @car,@motorbike,@motorbikeQuotes, @motorbikeEnterDetails"})
public class GoCompareRunnerTest {

}

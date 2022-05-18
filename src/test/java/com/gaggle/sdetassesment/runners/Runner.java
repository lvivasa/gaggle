package com.gaggle.sdetassesment.runners;

import com.gaggle.sdetassesment.utils.CloneRemoteRepository;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com/gaggle/sdetassesment/stepsDefinitions", tags = "@api")

@Slf4j
public class Runner {
       @BeforeClass
    public static void setEnvironment() {
        log.info("***************Clone repo************************");
        CloneRemoteRepository.cloneRepo();
    }
}
package com.cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)  
@CucumberOptions(
		plugin = {"pretty", "html:Reporte/Reporte_de_prueba.html"},
		features = {"classpath:features/jugador.feature"},
		glue = {"com.cucumber.stepDefinition"},
		monochrome = true,
		dryRun = false
)
public class TestRunner {
	
}
 
package com.StepDefination;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

	 @RunWith(Cucumber.class)
	 @Cucumber.Options(features="Orangefeaturefile",glue={"com.OrangeHrmLogin"})
	 public class TestRunner{
		 
	 }
   
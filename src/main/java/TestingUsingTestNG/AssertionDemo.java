package TestingUsingTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {
  @Test
  public void AssertTesting() {
	  
	  SoftAssert sa = new SoftAssert();
	  
	  if(true) {
		  sa.assertTrue(true);
	  }
	  else {
		  sa.assertFalse(false);
	  }
	  sa.assertAll();
  }
}

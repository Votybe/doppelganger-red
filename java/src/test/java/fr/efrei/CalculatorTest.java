package fr.efrei;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
  
  public class TestAuthorizer implements Authorizer {

	@Override
	public boolean authorize() {
		return false;
	}
	  
  }
	
  @Test
  void should_throw_when_not_authorized_library() {
	  TestAuthorizer authorizer = new TestAuthorizer();
	  
	  Calculator calculator = new Calculator(authorizer);
	  Exception exception = assertThrows(Exception.class, () -> calculator.divide(2,1));
	  assertEquals("Not authorized" , exception.getMessage());
  };
}

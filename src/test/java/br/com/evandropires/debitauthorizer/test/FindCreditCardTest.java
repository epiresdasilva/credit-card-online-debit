package br.com.evandropires.debitauthorizer.test;

import br.com.evandropires.debitauthorizer.dao.impl.CreditCardTestDAOImpl;
import br.com.evandropires.debitauthorizer.service.CreditCardProvider;
import br.com.evandropires.debitauthorizer.service.CreditCardService;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by evandro on 18/11/2018.
 */
@RunWith(JUnit4.class)
public class FindCreditCardTest {

	@Test
	public void findValidCreditCard() {
		Long cardNumber = 123456L;

		CreditCardProvider creditCardProvider = new CreditCardProvider();
		creditCardProvider.setCreditCardDAO(new CreditCardTestDAOImpl());
		JsonObject response = new CreditCardService(creditCardProvider).findCreditCard(cardNumber);
		Assert.assertTrue(response.has("agency"));
		Assert.assertTrue(response.has("account"));
		Assert.assertTrue(response.has("cardNumber"));
		Assert.assertTrue(response.has("status"));
		Assert.assertEquals("ACTIVE", response.get("status").getAsString());
	}

	@Test
	public void findInvalidCreditCard() {
		Long cardNumber = 999999L;

		CreditCardProvider creditCardProvider = new CreditCardProvider();
		creditCardProvider.setCreditCardDAO(new CreditCardTestDAOImpl());
		JsonObject response = new CreditCardService(creditCardProvider).findCreditCard(cardNumber);
		Assert.assertNull(response);
	}

	@Test
	public void findInactiveCreditCard() {
		Long cardNumber = 888888L;

		CreditCardProvider creditCardProvider = new CreditCardProvider();
		creditCardProvider.setCreditCardDAO(new CreditCardTestDAOImpl());
		JsonObject response = new CreditCardService(creditCardProvider).findCreditCard(cardNumber);
		Assert.assertEquals("INACTIVE", response.get("status").getAsString());
	}

}

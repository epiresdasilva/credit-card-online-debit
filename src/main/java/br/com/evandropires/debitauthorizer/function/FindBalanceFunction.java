package br.com.evandropires.debitauthorizer.function;

import br.com.evandropires.debitauthorizer.service.BalanceProvider;
import br.com.evandropires.debitauthorizer.service.BalanceService;
import com.google.gson.JsonObject;

/**
 * Created by evandro on 11/11/2018.
 */
public class FindBalanceFunction {
	public static JsonObject main(JsonObject params) {
		Integer agency = params.get("agency").getAsInt();
		Integer account = params.get("account").getAsInt();
		BalanceProvider balanceProvider = new BalanceProvider();
		return new BalanceService(balanceProvider).findBalance(agency, account);
	}

	public static void main(String[] args) {
		JsonObject payload = new JsonObject();
		payload.addProperty("agency", 111);
		payload.addProperty("account", 123);
		System.out.print(new FindBalanceFunction().main(payload));
	}
}

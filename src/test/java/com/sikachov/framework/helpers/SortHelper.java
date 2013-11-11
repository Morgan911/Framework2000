package com.sikachov.framework.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;

import com.sikachov.framework.objects.Product;

public class SortHelper extends BaseHelper{

	public static void verifyNameSorting(List<Product> unsorted,
			List<Product> sortedBySite) {
		List<String> productUnsortedNames = getNames(unsorted);

		Collections.sort(productUnsortedNames);

		Assert.assertEquals(getNames(sortedBySite), productUnsortedNames);
	}

	public static void verifyPriceSorting(List<Product> unsorted,
			List<Product> sortedBySite) {
		List<Double> productUnsortedPrices = getPrices(unsorted);
for(Double d : productUnsortedPrices){
	System.out.println(d);
}
		Collections.sort(productUnsortedPrices);
		Assert.assertEquals(getPrices(sortedBySite), productUnsortedPrices);
	}

	private static List<Double> getPrices(List<Product> list) {
		List<Double> prices = new ArrayList<Double>();
		for (Product p : list) {
			prices.add(p.getPrice());
		}
		return prices;
	}

	private static List<String> getNames(List<Product> list) {
		List<String> prices = new ArrayList<String>();
		for (Product p : list) {
			prices.add(p.getName().toLowerCase());
		}
		return prices;
	}

}

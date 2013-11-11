package com.sikachov.framework.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;

import com.sikachov.framework.objects.Product;
import com.sikachov.framework.pages.ProductPage;

public class FilterHelper {

	public static void verifyFilterWork(List<Product> filteredProds, String f1,
			String f2) {
		Double a = Double.parseDouble(f1);
		Double b = Double.parseDouble(f2);
		for (Product p : filteredProds) {
			Boolean actual = isPriceInRange(p.getPrice(), a, b);
			Boolean expected = true;
			Assert.assertEquals(actual, expected);
		}
	}

	public static void verifyProducersInFilter(ProductPage p) {
		List<String> names = p.getProductProducers();
		List<String> prods = p.getProducers();
		Collections.sort(names);
		Collections.sort(prods);
		Assert.assertEquals(names, prods);
	}
	
	private static Boolean isPriceInRange(Double price, Double a, Double b) {
		return ((price >= a) && (price < b));
	}
	
	public static void verifyTextPresent( ProductPage p, String str) {
		List<Product> prods = p.getProducts();
		prods = getListWithString(str, prods);
		
		p.openPageWithFunc(str);
		List<Product> prodsWithFunc = p.getProducts();
		Assert.assertEquals(prods, prodsWithFunc);
	}
	
	public static List<Product> getListWithString(String str, List<Product> from) {
		List<Product> list = new ArrayList<Product>();
		for (Product p : from) {
			if (p.getDescription().contains(str)) {
				System.out.println("Description = " + p.getDescription());
				System.out.println("String = " + str);
				list.add(p);
			}
		}
		return list;
	}

}

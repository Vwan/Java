package com.test.servlet.beer.model;


import java.util.*;

public class Brands {

	public List getBrands(String color){
	List brands = new ArrayList();
	if (color=="light"){
		brands.add("light 1");
	}
	return brands;
	}
}

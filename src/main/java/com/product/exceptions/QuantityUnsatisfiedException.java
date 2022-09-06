package com.product.exceptions;

public class QuantityUnsatisfiedException extends RuntimeException{

	public QuantityUnsatisfiedException(int quantity) {
		super("Exception due to product quantity :"+ quantity);
	}
}

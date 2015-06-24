package com.comcast.oscar.examples;


public class REST {

	public static void main(String[] args) {

		get("/hello", (req, res) -> "Hello World");
	}

}

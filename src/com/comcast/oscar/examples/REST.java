package com.comcast.oscar.examples;

import static spark.Spark.*;

public class REST {

	public static void main(String[] args) {
		get("/hello", (req, res) -> "Hello World");
	}

}

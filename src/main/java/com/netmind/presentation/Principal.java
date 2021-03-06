package com.netmind.presentation;

import java.io.IOException;

public class Principal {
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("java.version"));
		StudentConsole.selectOperation();
	}

}

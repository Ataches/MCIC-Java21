package com.ing_software.veintiuno;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
public class GameAskerTest {
	private GameAsker gameAsker;

	@Before
	public void setup() {
		gameAsker = new GameAsker();

		String data = "no";
		InputStream stdin = System.in;
		System.setIn(new ByteArrayInputStream(data.getBytes()));

		Scanner scanner = new Scanner(System.in);
		System.setIn(stdin);
		gameAsker.setScanner(scanner);
	}

	@Test
	public void stringAsk() {
		assertEquals("no", gameAsker.stringAsk());
	}
}
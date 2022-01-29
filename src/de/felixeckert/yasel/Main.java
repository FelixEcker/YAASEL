package de.felixeckert.yasel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;

/**
 * YASEL MAIN CLASS.
 *
 * YASEL is an Esoteric, Stack-Based, Programming Language
 * with 14 individual instructions, each one being a single
 * character.
 * */
public class Main {
	/**
	 * Executes a given program.
	 * @param program The program as a char array
	 * */
	public static void execute(char[] program) {
		program = cleanProgram(program);

		Stack<Byte> STACK  = new Stack<>();
		byte	    BUFFER = 0x0;
		Scanner     INPUT  = new Scanner(System.in);
		int lastindex;

		long startTime = System.nanoTime();

		for (int i = 0; i < program.length; i++) {
			char instruction = program[i];

			switch (instruction) {
				case '&': // Add Values
					STACK.push((byte) (STACK.pop()+BUFFER));
					break;
				case '+': // Increment
					STACK.push((byte) (STACK.pop() + 1));
					break;
				case '-': // Decrement
					STACK.push((byte) (STACK.pop() - 1));
					break;
				case '#': // Void Value
					STACK.pop();
					break;
				case '\'': // Stash Value
					BUFFER = STACK.pop();
					break;
				case '"': // Load Stash
					STACK.push(BUFFER);
					break;
				case '*': // New value
					STACK.push((byte) 0x0);
					break;
				case '~': // Get Input
					System.out.print("> ");
					char[] input = INPUT.nextLine().toCharArray();
					System.out.println();
					for (char c : input) STACK.push((byte) c);
					break;
				case '%': // Print top Value
					System.out.print((char) ((byte)STACK.peek()));// + " value: "+STACK.peek()+"\n"); // DEBUG
					break;
				case ':': // Jump Point
					break;
				case '!': // Jump to last Jump Point
					lastindex = 0;
					for (int j = i; j >= 0; j--) if (program[j] == ':') lastindex = j;
					i = lastindex;
					break;
				case '$': // Jump to next Jump Point
					lastindex = i;
					for (int j = i; j < program.length; j++) if (program[j] == ':') lastindex = j;
					i = lastindex;
					break;
				case '>': // Larger Than
					if (STACK.peek() > STACK.elementAt(STACK.size()-2)) break;
					lastindex = 0;
					for (int j = i; j >= 0; j--) if (program[j] == ':') lastindex = j;
					i = lastindex;
					break;
				case '<': // Lesser Than
					if (STACK.peek() < STACK.elementAt(STACK.size()-2)) break;
					lastindex = 0;
					for (int j = i; j >= 0; j--) if (program[j] == ':') lastindex = j;
					i = lastindex;
					break;
				case '=': // Equal To
					if (STACK.peek() == STACK.elementAt(STACK.size()-2)) break;
					lastindex = 0;
					for (int j = i; j >= 0; j--) if (program[j] == ':') lastindex = j;
					i = lastindex;
					break;
			}
		}
		long endTime = System.nanoTime();

		INPUT.close();
		System.out.printf("\n===============\nProgram Finished in %s ns!\n", endTime-startTime);
		System.out.printf("Stack size %s (at program exit) \n", STACK.size());
	}

	/**
	 * Clears the Program of any Characters not in the instruction
	 * set.
	 *
	 * @param raw The Raw, uncleaned Program
	 * @return The cleaned Program
	 * */
	public static char[] cleanProgram(char[] raw) {
		char[] instructions = {'<','>','=',':','!','&','+','-','#','\'','"','*','~','%'};
		StringBuilder builder = new StringBuilder();
		for (char c : raw) {
			for (char d : instructions) {
				if (c == d) builder.append(c);
			}
		}

		return builder.toString().toCharArray();
	}

	public static void main(String[] args) {
		String path = "";
		for (String s : args) path += s;

		try {
			execute(new String(Files.readAllBytes(Paths.get(new File(path).getAbsolutePath()))).toCharArray());
		} catch (IOException e) {
			System.err.printf("Program File not Found (%s)!\n", Paths.get(new File(path).getAbsolutePath()));
			System.exit(0);
		}
	}
}

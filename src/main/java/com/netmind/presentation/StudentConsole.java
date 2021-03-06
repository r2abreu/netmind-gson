/**
  * Class name: Student Console.
 * 
 * Shows terminal console and handles user selected options.
 * 
 * @author Arturo Abreu.
 * @version 1.0
 */

package com.netmind.presentation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.netmind.business.StudentBlImpl;
import com.netmind.business.contracts.StudentBl;
import com.netmind.model.OptionEnum;
import com.netmind.model.Student;

public class StudentConsole {

	@SuppressWarnings("static-access")
	public static void selectOperation() throws IOException {
		Scanner scanner = new Scanner(System.in);
		StudentBl studentBl = new StudentBlImpl();
		OptionEnum option;

		int input;

		do {

			showPrincipalMenu();

			input = Integer.parseInt(scanner.nextLine());
			option = OptionEnum.fromValue(input);

			switch (option) {
			case ADD_STUDENT:
				Student student = new Student();
				fillStudentProperties(student, scanner);
				studentBl.add(student);
				studentBl.addToJsonFile(student);
				break;
			case EXIT:
				System.out.println("So long!");
			default:
				break;
			}
		} while (input != option.EXIT.value());

		scanner.close();
	}

	private static void showPrincipalMenu() {

		System.out.println("Hola, en que te puedo ayudar?");
		System.out.println("1. Agregar un nuevo estudiante.");
		System.out.println("2. Calcular el estudiante con mayor edad.");
		System.out.println(
				"3. Calcular la media de edad de todos los estudiantes");
	}

	public static void fillStudentProperties(Student student, Scanner scanner) {

		System.out.println("Interfaz de creacion de estudiante");
		System.out.println("Introduce los siguientes datos");

		System.out.println("Nombre:");
		student.setName(scanner.nextLine());

		System.out.println("Apellido:");
		student.setSurname(scanner.nextLine());

		System.out.println("Introduce Fecha de nacimiento (dd-MM-yyyy): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), formatter);

		student.setDateOfBirth(dateOfBirth);

	}

}

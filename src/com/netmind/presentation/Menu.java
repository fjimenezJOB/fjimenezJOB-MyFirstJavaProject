package com.netmind.presentation;

import com.netmind.business.StudentBl;
import com.netmind.model.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class Menu {

  public static int hello() {

    Scanner scanner = new Scanner(System.in);
    System.out.println(
        "******** MENU ********\n\nWellcome, what you want to do?\n\n1. Add new student.\n2. Calculate oldest student.\n3. Calculate the average age of students.\n4. Exit");
    int decission = scanner.nextInt();

    return decission;
  }

  public static void decission() {

    Boolean interruptor = true;

    try {

      do {
        int decission = Menu.hello();

        switch (decission) {
          case 1:
            Student student = new Student();
            Menu.askNewStudent(student);
            break;
          case 2:
            break;
          case 3:
            break;
          case 4:
            interruptor = false;

            break;
          default:
            Menu.hello();
        }
      } while (interruptor);
    } catch (Exception ex) {

      System.out.println(ex + " - " + "Try to insert a number of options in menu.");
    }
  }

  public static void askNewStudent(Student student) {
    StudentBl studentBl = new StudentBl();

    Scanner scanner = new Scanner(System.in);
    student.setIdStudent(UUID.randomUUID().toString());

    System.out.println("Enter the name:");
    student.setName(scanner.nextLine());

    System.out.println("Enter the surname:");
    student.setSurname(scanner.nextLine());

    System.out.println("Enter the date of birth (dd/mm/yyyy):");

    try {

      student.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));
      studentBl.add(student);

    } catch (ParseException ex) {
      System.out.println(ex.getMessage());
      ex.printStackTrace();
    }
  }
}

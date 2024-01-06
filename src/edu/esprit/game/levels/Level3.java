package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import edu.esprit.game.utils.Data;

public class Level3 {
    public static void main(String[] args) {
        List<Employee> employees = Data.employees();

        /* TO DO 1: Retourner une chaîne de caractères qui contient tous les noms des employés */
        String names = employees.stream().map(Employee::getName).reduce("", (s1, s2) -> s1 + " " + s2);
        System.out.println("1: " + names);

        /* TO DO 2: Retourner une chaîne de caractères qui contient tous les noms des employés en majuscule séparés par # */
        String namesMajSplit = employees.stream().map(Employee::getName).map(String::toUpperCase).collect(Collectors.joining("#"));
        System.out.println("2: " + namesMajSplit);

        /* TO DO 3: Retourner un set d'employés */
        Set<Employee> emps = employees.stream().collect(Collectors.toSet());
        System.out.println("3: " + emps);

        /* TO DO 4: Retourner un TreeSet d'employés (tri par nom) */
        TreeSet<Employee> emps2 = employees.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))));
        System.out.println("4: " + emps2);

        /* TO DO 5: Retourner une Map qui regroupe les employés par salaire */
        Map<Integer, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println("5: " + map);

        /* TO DO 6: Retourner une Map qui regroupe les noms des employés par salaire */
        Map<Integer, String> mm = employees.stream().collect(Collectors.toMap(Employee::getSalary, Employee::getName, (s1, s2) -> s1 + ", " + s2));
        System.out.println("6: " + mm);

        /* TO DO 7: Retourner le min, max, average, sum, count des salaires */
        String s = "Min: " + employees.stream().mapToInt(Employee::getSalary).min().orElse(0) +
                   ", Max: " + employees.stream().mapToInt(Employee::getSalary).max().orElse(0) +
                   ", Average: " + employees.stream().mapToInt(Employee::getSalary).average().orElse(0) +
                   ", Sum: " + employees.stream().mapToInt(Employee::getSalary).sum() +
                   ", Count: " + employees.stream().mapToInt(Employee::getSalary).count();
        System.out.println("7: " + s);
    }
}

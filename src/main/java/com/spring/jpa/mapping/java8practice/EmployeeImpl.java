package com.spring.jpa.mapping.java8practice;

import ch.qos.logback.core.util.StringUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmployeeImpl {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //Question 1

        List<String> collect2 = employeeList.stream().map(employee -> employee.getDepartment()).distinct().collect(Collectors.toList());


        Map<String, Double> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        //System.out.println(collect);

        Optional<Employee> collect1 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        //System.out.println(collect1);

        List<String> collect3 = employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList());
        //System.out.println(collect3);

         Map<String, Long> collect4 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
         //System.out.println(collect4);

         Map<String, Double> collect5 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect5);

         Optional<Employee> min = employeeList.stream().filter(employee -> employee.getDepartment()=="Product Development" & employee.getGender() == "Male").min(Comparator.comparing(Employee::getAge));
        //System.out.println(min);

        Optional<Employee> collect6 = employeeList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getSalary)));

        Optional<Employee> first = employeeList.stream().sorted(Comparator.comparing(Employee::getAge)).findFirst();

         Optional<Employee> first1 = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();

        //System.out.println(first1);

         Map<String, Long> collect7 = employeeList.stream().filter(employee -> employee.getDepartment() == "Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        //System.out.println(collect7);

        Map<String, Double> collect8 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

        //System.out.println(collect8);

         Map<String, List<Employee>> collect9 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));

         Map<String, List<String>> collect10 = collect9.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().map(employee -> employee.getName()).collect(Collectors.toList())));

        //System.out.println(collect10);



         Map<Boolean, List<Employee>> collect12 = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() >= 25));

         Map<String, String> collect13 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().max(Comparator.comparing(Employee::getSalary)).map(employee -> employee.getName()).toString()));
        //System.out.println(collect13);

         Map<String, String> collect11 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getName).toString())));
        //System.out.println(collect11);

         Map<String, List<String>> collect14 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().map(employee -> employee.getName()).collect(Collectors.toList()))));

        //System.out.println(collect14);

         Map<String, List<String>> collect15 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, list -> list.getValue().stream().map(employee -> employee.getName()).collect(Collectors.toList())));
        //System.out.println(collect15);

         Map<String, Employee> collect16 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().get())));
        System.out.println(collect16);

       /* employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge()>25)).entrySet().stream().forEach(booleanListEntry -> {
            if (booleanListEntry.getKey()) {
                System.out.println("Age greater than 25 :"+ booleanListEntry.getValue());
            }else {
                System.out.println("Age Less than 25 :"+ booleanListEntry.getValue());
            }
        });*/

         Map<Boolean, List<Employee>> collect17 = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 25));

         Set<Map.Entry<Boolean, List<Employee>>> entries = collect17.entrySet();

         Iterator iterator = entries.iterator();


         String str ="This is first java program";

         StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer.reverse());

        String  reverse="";
        for(int i= str.length()-1; i>=0; i--){
            reverse = reverse + str.charAt(i);
        }

         String string = IntStream.range(0, str.length()).mapToObj(n -> String.valueOf(str.charAt(str.length() - 1 - n))).collect(Collectors.joining());

        String reversestr = IntStream.range(0, str.length())
                .mapToObj(i -> String.valueOf(str.charAt(str.length() - 1 - i)))
                .collect(Collectors.joining());


         String[] s = str.split(" ");
         String collect18 = Arrays.stream(s).map(string1 -> new StringBuffer(string1).reverse()).collect(Collectors.joining(" "));

         String reversestri = "";
         for (String sa:s){
             reversestri =reversestri + " " +  new StringBuffer(sa).reverse();
         }

        String reversee = Arrays.stream(str.split(" "))
                .reduce((a, b) -> b + " " + a)
                .orElse("");

        System.out.println(reversee);
        //System.out.println("Reverse String is :"+ reversee);

        String str1=str.replace(" ","");
        str1.chars().mapToObj(value -> (char)value).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(characterLongEntry -> characterLongEntry.getValue()>1).forEach(characterLongEntry -> System.out.println(characterLongEntry.getKey() + " "+ characterLongEntry.getValue()));


      Map<Character,Long> map = str1.chars().mapToObj(value -> (char)value).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

        String s1 = "listen";
        String s2 = "silent";

        if(isanagrams(s1,s2)){
            System.out.println("Strings are anagrams ");
        }
        else {
            System.out.println("Strings are not anagrams");
        }


        HashMap<String, Integer> map1 = new HashMap<>();

        map1.put("Maths", 45);
        map1.put("Physics", 57);
        map1.put("Chemistry", 52);
        map1.put("History", 41);

        //Map-2

        HashMap<String, Integer> map2 = new HashMap<>();

        map2.put("Economics", 49);
        map2.put("Maths", 42);
        map2.put("Biology", 41);
        map2.put("History", 55);

        HashMap<String, Integer> collect19 = Stream.of(map1, map2).flatMap(stringIntegerHashMap -> stringIntegerHashMap.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1 + v2, HashMap::new));

        System.out.println(collect19);

         HashMap<String, Integer> collect20 = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a + b, HashMap::new));

        System.out.println(collect20);

        map1.forEach((key, value) -> map2.merge(key,value,(a,b) -> a+b));
        System.out.println(map2);

        String str5 = null;

        System.out.println(StringUtil.isNullOrEmpty(str5));



    }
     public static boolean isanagrams(String s1, String s2){

          s1 =Arrays.stream(s1.split("")).map(string -> string.toLowerCase()).sorted().collect(Collectors.joining());
          s2=Arrays.stream(s2.split("")).map(string -> string.toLowerCase()).sorted().collect(Collectors.joining());

         return s1.equals(s2);
     }
}



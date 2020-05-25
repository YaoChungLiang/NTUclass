import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class ContagionControl{
    public static void main(String[] args){
        lab2();
        lab2_1();
        // lab 2-2 already included in lab2 and lab2-1
    }
    
    static void lab2(){
        HashSet<Integer> visitedSet = new HashSet<Integer>();
        List<Integer> visitedList =  new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of citizens:");
        int numberOfCitizens = input.nextInt();

        Integer[] Contactee = new Integer[numberOfCitizens];
        Integer[] Id = new Integer[numberOfCitizens];
        for(Integer i = 0;i< numberOfCitizens;i++){
            Id[i] = i;
            Contactee[i] = i;
        }
        List<Integer> ContacteeList = Arrays.asList(Contactee);
        List<Integer> IdList = Arrays.asList(Id);
        Collections.shuffle(ContacteeList);
        ContacteeList.toArray(Contactee);
        System.out.printf("Id       ");
        for(int i = 0; i < numberOfCitizens;i++){
            System.out.printf("%3d", Id[i]);
        }
        System.out.println();
        System.out.printf("Contactee");
        for(int i = 0; i < numberOfCitizens;i++){
            System.out.printf("%3d", Contactee[i]);
        }
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("Enter id of infected citizen");
        Integer infectedId = input.nextInt();
        while( !visitedSet.contains(infectedId)){
            visitedSet.add(infectedId);
            visitedList.add(infectedId);
            infectedId = Contactee[infectedId];
        }
        System.out.println("These citizens are to be self-isolated in the following 14 days:");
        for(int i = 0; i < visitedList.size();i++){
            System.out.printf("%3d", visitedList.get(i));
        }
        System.out.println();
    }
    
    
    static void lab2_1(){
        HashSet<Integer> visitedSet = new HashSet<Integer>();
        List<Integer> visitedList =  new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of citizens:");
        int numberOfCitizens = input.nextInt();

        Integer[] Contactee = new Integer[numberOfCitizens];
        Integer[] Id = new Integer[numberOfCitizens];
        for(Integer i = 0;i< numberOfCitizens;i++){
            Id[i] = i;
            Contactee[i] = i;
        }
        List<Integer> ContacteeList = Arrays.asList(Contactee);
        List<Integer> IdList = Arrays.asList(Id);
        Collections.shuffle(ContacteeList);
        ContacteeList.toArray(Contactee);
        System.out.printf("Id       ");
        for(int i = 0; i < numberOfCitizens;i++){
            System.out.printf("%3d", Id[i]);
        }
        System.out.println();
        System.out.printf("contactee");
        for(int i = 0; i < numberOfCitizens;i++){
            System.out.printf("%3d", Contactee[i]);
        }
        System.out.println();
        System.out.println("-----------------------");
        int groupId = 0;
        Integer infectedId = 0;
        while(visitedSet.size() < numberOfCitizens){
            while( !visitedSet.contains(infectedId)){
                visitedSet.add(infectedId);
                visitedList.add(infectedId);
                infectedId = Contactee[infectedId];
            }
            
            System.out.printf("Group %d:", groupId);
            for(int i = 0; i < visitedList.size();i++){
                System.out.printf("%3d", visitedList.get(i));
            }
            System.out.println();
            visitedList.clear();
            groupId += 1;
            for(int i = 0; i < numberOfCitizens;i++){
                if(!visitedSet.contains(i)){
                    infectedId = i;
                    break;
                }
            }
        }
        System.out.println();
        System.out.printf("Number of group : %d\n", groupId);
    }
}


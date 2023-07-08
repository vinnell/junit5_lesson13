package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class UserManager {
    public ArrayList<User> users = new ArrayList<>();
    public String findFirstName() {
        return users.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).findAny().get().firstName;
    }
    public String  findSecondName() {
        return users.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).findAny().get().secondName;
    }
        Comparator<User> comporatorOfUser2 = (o1, o2) -> {
        if (o1.getAge() == o2.getAge()){
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
        return o1.getAge() - o2.getAge();
    };
    public int findMinAge() {
        return users.stream().min(comporatorOfUser2).get().age;
    }
    public double averageAgeOfUsers() {
        return  users.stream().collect(Collectors.averagingInt(User::getAge));
    }
    public boolean userHAsSInSecondName() {
        return users.stream().anyMatch(user -> user.secondName.contains("S"));
    }
    public boolean userHasAInFirstName() {
        return users.stream().anyMatch(user -> user.firstName.contains("A"));
    }
    public boolean AgeOfUsersMore18() {
        return  users.stream().anyMatch(user -> user.getAge() > 18);
    }
}




package com.lpg.user;

import com.lpg.user.Ann.Validate;
import com.lpg.user.entity.User;
import com.lpg.user.utils.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lPG
 * @version 1.0
 * @Description
 * @date 2020-06-16 17:09
 */
public class test {

    public static void main1(String[] args) {
        User user = new User();
        user.setId(1);
       Result s= Validate.validations(user);
        s.getMessage();
        System.out.println("s = " + s);
    }

    public static void main(String[] args) {
        User user = new User().setId(1).setPhone("22121212");
        User user1 = new User().setId(1).setPhone("58474");
        User user2 = new User().setId(1).setPhone("547878455");
        User user3 = new User().setId(2).setPhone("58474");
        User user4 = new User().setId(3).setPhone("58474");

        List<User> list = Arrays.asList(user,user1,user2,user3,user4);
        System.out.println("list = " + list);
       Map<Integer,List<User>> map = list.stream().collect(Collectors.groupingBy(User::getId));
        System.out.println("map = " + map);
        map.forEach((k,v)->{
            v.stream().forEach(a->{
                a.getId();
            });
        });

}
}

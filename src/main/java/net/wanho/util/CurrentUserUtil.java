package net.wanho.util;

public class CurrentUserUtil {
    private static ThreadLocal<Integer> currentUser=new ThreadLocal<>();
    public static void setCurrentUser(Integer userId){
        currentUser.set(userId);
    }

    public static Integer getCurrentUser(){
        return  currentUser.get();
    }

    public static void removeCurrentUser(){
        currentUser.remove();
    }
}

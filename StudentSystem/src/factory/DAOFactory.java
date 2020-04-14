package factory;

import stuDAO.*;

public class DAOFactory {
    public static StuDAO getStuDAOInstance(String args[]){
        return new StuDAOProxy(args);
        //采用args[]数组传递账密 args[0]为帐号 args[1]为密码
    }
}

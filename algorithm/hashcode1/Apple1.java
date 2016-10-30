package hashcode1;
//http://www.programcreek.com/2011/07/java-equals-and-hashcode-contract/

import java.util.HashMap;

/**
 * Created by davidtan on 10/27/16.
 */
public class Apple1 {

    private String color;
    public Apple1(String color){
        this.color = color;
    }
    public boolean equals(Object obj){
        if(obj ==null)return false;

        if(!(obj instanceof Apple1))return  false;

        if(obj == this)return  true;

        return this.color.equals(((Apple1)obj).color);

    }

    public int hashCode(){
        return this.color.hashCode();
    }

    public static void main(String[] args) {

        Apple1 a1 = new Apple1("green");

        Apple1 a2 = new Apple1("red");


        HashMap<Apple1, Integer> m = new HashMap<>();

        m.put(a1, 10);

        m.put(a2, 20);
        //System.out.println(m.get(new Apple1("green"))); //null

        // after hashCode
        System.out.println(m.get(new Apple1("green"))); //10
    }


}

import Items.Item;

import java.util.ArrayList;

public class Player {
    String name;
    int    hp;
    int    accuracy;
    int inRoom=0;
    ArrayList<Item> item=new ArrayList<Item>();

    public void look(){
        System.out.println("You take a good look at yourself......");
        System.out.println("Name:"+name);
        System.out.println("Health:"+hp);
        System.out.println("Accuracy:"+accuracy);

    }
}

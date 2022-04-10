import Items.Flaming_Sword;
import Items.Item;
import NPC.Troll;
import NPC.NPC;
import NPC.Dragon;

import java.util.ArrayList;
import java.util.List;

public class Game_Objects {
    static Player player = new Player();
    static ArrayList<Room> room = new ArrayList<Room>();
    static List<Object> NPCDataBase = new ArrayList<Object>();
    static List<Object> ItemDataBase = new ArrayList<Object>();

    public static void initializeNPCArray(){
        NPCDataBase.add(new NPC());
        NPCDataBase.add(new Troll());
        NPCDataBase.add(new Dragon());
    }
    public static void initializeItemArray(){
        ItemDataBase.add(new Item());
        ItemDataBase.add(new Flaming_Sword());
    }

}

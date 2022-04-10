import Items.Item;
import NPC.*;


import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Game_Logic {
    public Game_Logic(){
        Game_Objects.room.add(new Room(1));
        Game_Objects.room.get(0).name = "Floating in Space";
        Game_Objects.room.get(0).desc.add("Desc Line 1");
        Game_Objects.room.get(0).desc.add("Desc Line 2");
        Game_Objects.room.get(0).desc.add("Desc Line 3");
        Game_Objects.room.get(0).desc.add("Desc Line 4");
        Game_Objects.room.get(0).exits.add("South 2");
        Game_Objects.room.get(0).exits.add("North 3");
    }
    public void waitforCommand() {
        if(Game_Objects.player.inRoom == 0){
            createCharacter();
        }
        System.out.println("What will you do?");
        Scanner sc = new Scanner(System.in);
        String com = sc.nextLine();
        // parse the command by spaces
        //read each word into an array valueString s="This is a simple sentence"
        String[] words= com.split(" ");
        processCommand(words);
    }
    public void processCommand(String[] x){
       if(x[0].equals("look"))
       {
           look(x);
       }
       if(x[0].equals("summon")){
           summon(x);
       }
    }
public void get(String[] x){
        if(x.length==1){System.out.println("Get What?");}

        if(x.length==2){}//finish this
}
    public void look(String[] x){
        if(x.length ==1){
            for(int i =0;i < Game_Objects.room.size();i++){
                if(Game_Objects.room.get(i).number == Game_Objects.player.inRoom){
                    System.out.println(Game_Objects.room.get(i).name);
                    for(int y = 0;y<Game_Objects.room.get(i).exits.size(); y++) {
                     System.out.println(Game_Objects.room.get(i).desc.get(y));
                    }
                    System.out.println("Exits:");
                    for(int y =0; y<Game_Objects.room.get(i).exits.size();y++){

                        String exitNameFull =Game_Objects.room.get(i).exits.get(y);
                        String[] exitName = exitNameFull.split(" ");
                        System.out.println(exitName[0]);
                    }
                    for (int y=0; y<Game_Objects.room.get(i).npc.size();y++){
                        System.out.println(Game_Objects.room.get(i).npc.get(y).desc);
                    }
                }
            }
        }
        //If user typed in someting after look
        if(x.length ==2){
            if(x[1].equals("self")){Game_Objects.player.look();}

       for(int y =0; y<Game_Objects.room.size();y++){
           if(Game_Objects.room.get(y).number == Game_Objects.player.inRoom){
               for(int i=0; i< Game_Objects.room.get(y).npc.size();i++){
                   if(x[1].equalsIgnoreCase(Game_Objects.room.get(y).npc.get(i).id)){
                       Game_Objects.room.get(y).npc.get(i).look();}
               }
           }
       }
        }


    }
public void summon(String[] x){
    if (x.length == 1) {

        System.out.println("Summon what exactly?");

    }
    if(x.length ==2){
        for(int i= 0; i< Game_Objects.NPCDataBase.size();i++){
            NPC localNPC=(NPC) Game_Objects.NPCDataBase.get(i);
            if(localNPC.id.equalsIgnoreCase(x[1])){
                for(int y =0; y<Game_Objects.room.size();y++){
                    if(Game_Objects.room.get(y).number==Game_Objects.player.inRoom){
                        try{
                            Game_Objects.room.get(y).npc.add((NPC)Class.forName("NPC."+localNPC.id)
                                    .getDeclaredConstructor().newInstance());
System.out.println("You summon a "+ Game_Objects.room.get(y).npc
        .get(Game_Objects.room.get(y).npc.size() - 1).name);
                            }catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
    public void createCharacter(){
        System.out.println("Welcome to the Game. What is your name?");
        Scanner sc = new Scanner(System.in);
        Game_Objects.player.name=sc.next();
        System.out.println("For the sake of simplicity, the gods are giving you 100 hp and 75 accuracy.");
        Game_Objects.player.hp = 100;
        Game_Objects.player.accuracy = 75;
        Game_Objects.player.inRoom = 1;
    }

    public void create_item(String[] x){
        if(x.length==1){
    System.out.println("Create What Exactly?");
        }
        if(x.length==2){
            for(int i=0;i<Game_Objects.ItemDataBase.size();i++){
                Item localItem=(Item)Game_Objects.ItemDataBase.get(i);

            }
        }
    }

}

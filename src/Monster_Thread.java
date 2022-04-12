import NPC.NPC;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Monster_Tread {
    Game_Logic currentGL;

    public Monster_Thread(Game_Logic gl){
        currentGL = gl;
    }
    public void startMonsterThread(){
        Thread one = new Thread(){
            public void run(){
                try{
                    while (true){
                        //System.out.println("Something Happens");
                        populateGame();
                        Thread.sleep(1000);

                        //System.out.println("Something Happens Again");
                    }
                }catch(InterruptedException v){
                    System.out.println(v);
                }
            }
        };
        one.start();
    }
    public void populateGame(){
        int roomMobCount=0;
        List<String> lines=new ArrayList<String>();
        try{
            lines=currentGL.readLines("TextFiles/MonsterLocs.txt");
        }catch(IOException e){
            e.printStackTrace();
        }
        for(int i=0; i<lines.size();i++){
            String[] words= lines.get(i).split(" ");
            if(words[0].equals("Name:")){
                for(int y=0;y<Game_Objects.room.size(); y++){
                    if(Game_Objects.room.get(y).number==Integer.parseInt(words[2])){
                        for(int z =0; z<Game_Objects.room.get(y).npc.size();z++){
                            if(Game_Objects.room.get(y).npc.get(z).id.equalsIgnoreCase(words[1])){
                                roomMobCount++;
                            }
                        }
                    }
                }
                if(roomMobCount==0){
                    for(int y=0;y<Game_Objects.room.size();y++){
                        if(Game_Objects.room.get(y).number==Integer.parseInt(words[2])){
                            try{
                                Game_Objects.room.get(y).npc.add((NPC)Class.forName("NPC."+words[1]).getDeclaredConstructor().newInstance());
                            }catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (NoSuchMethodException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            roomMobCount=0;
        }
    }

}

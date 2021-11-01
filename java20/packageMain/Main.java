package packageMain;
import java.util.Random;
import java.util.Scanner;

import packageCharacters.*;
import packageIf.IGameChar;
public class Main {
    static int G_CHAR_MAX = 4;
    static int ENEMY_MAX = G_CHAR_MAX-1;
    static GameChar ch[] = new GameChar[G_CHAR_MAX];
    static boolean endFlg=false;
    public static void main(String[] args){

        GameChar gameChar = new Hero();
        IGameChar iHero = gameChar;
        iHero.statusMsg();

        System.out.println("Game Start.");
        init();
        System.out.println();
        for(GameChar gch: ch){ gch.statusMsg(); }

        do{
            System.out.println();
            endFlg = battleMain(ch);
        }while(!endFlg);
        System.out.println("Game End.");
    }
    private static void init(){
        ch[0] = new Hero();
        java.util.Random random = new Random();
        for(int i=1; i<          ; i++){
            makeEnemy(i, random);
        }
    }
    private static void makeEnemy(int i, Random random){
        int num = random.nextInt(ENEMY_MAX);
        switch(num){
            case 0:{ ch[i] = new Doragon(); break;}
            case  :{ ch[i] =             ; break;}
            case 2:default:{         = new Bird(); break;}
        }
    }
    // バトルメイン
    private static boolean battleMain(IGameChar[] pArray){
        boolean enemy_alive = true;
        IGameChar p1 = pArray[0];
        for(int i=1; i<G_CHAR_MAX; i++){
            if(!pArray[i].isDead()){
                new Scanner(System.in).nextLine();
                if(!p1.attack(pArray[i])){ enemy_alive=false;};
            }
            if(!                  ){
                if(pArray[i].attack(p1)){return true;}
            } 
        }
        System.out.println();
        for(IGameChar gch: pArray){ gch.statusMsg();}
        return enemy_alive;
    }
    
}

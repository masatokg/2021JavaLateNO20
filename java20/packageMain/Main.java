package packageMain;
import java.util.Random;
import java.util.Scanner;

import packageCharacters.*;
import packageIf.IGameChar;
public class Main {
    // ゲームキャラクターの最大数
    static int G_CHAR_MAX = 4;
    // 敵キャラクターの最大数
    static int ENEMY_MAX = G_CHAR_MAX-1;
    // ゲームキャラクターデータを格納する配列
    static GameChar ch[] = new GameChar[G_CHAR_MAX];
    // 終了フラグ
    static boolean endFlg=false;
    public static void main(String[] args){

        // GameChar gameChar = new Hero();
        // IGameChar iHero = gameChar;
        // iHero.statusMsg();

        System.out.println("Game Start.");
        // 各キャラクターデータの生成と初期化
        init();
        // 空改行して、各キャラクターのステータスを順番に表示
        System.out.println();
        for(GameChar gch: ch){ gch.statusMsg(); }

        // 終了フラグが立たないうちは、戦いのターンを繰り返す
        do{
            System.out.println(); // 空改行
            endFlg = battleMain(ch); // 1ターン分の戦い
        }while(!endFlg);
        System.out.println("Game End.");
    }
    // ゲームキャラクターの生成と初期か
    private static void init(){
        // ヒーローを生成
        ch[0] = new Hero();
        // ランダム値作成用のインスタンス
        java.util.Random random = new Random();
        // 敵の数だけ、敵のインスタンスを生成する
        for(int i=1; i<          ; i++){
            makeEnemy(i, random);
        }
    }
    // ゲームキャラクター配列i番目の敵を1体生成するメソッド
    private static void makeEnemy(int i, Random random){
        // ランダム変数からランダム値を取得（0～ENEMY_MAXまでの乱数）
        int num = random.nextInt(ENEMY_MAX);
        // 取得した値によって、敵の種類を決定、配列のi番目に収める
        switch(num){
            case 0:{ ch[i] = new Doragon(); break;} // 乱数が0の時
            case  :{ ch[i] =             ; break;} // 乱数が1の時
            case 2:default:{         = new Bird(); break;} // 乱数が2の時とデフォルト
        }
    }
    // バトルメイン（引数はゲームキャラクターの配列）
    private static boolean battleMain(IGameChar[] pArray){
        // 敵の生死フラグ（戻り値初期値：ゲームエンド=敵が全滅）
        // 変数名は game_endが良かったかも。ごめんなさい。
        boolean enemy_alive = true;
        IGameChar p1 = pArray[0];   // 0番目はヒーロー
        // 敵の部分をループする（i番目の敵と戦う）
        for(int i=1; i<G_CHAR_MAX; i++){
            // i番目の敵が生きている時
            if(!pArray[i].isDead()){
                new Scanner(System.in).nextLine(); // 入力待ち
                // ヒーローがi番目の敵を攻撃した結果、敵が生きていたら戻り値をfalseに変更
                if(!p1.attack(pArray[i])){ enemy_alive=false;};
            }
            // i番目の敵が生きている時
            if(!                  ){
                // i番目の敵が主人公を攻撃した結果、主人公が死んだら、即ゲームエンドをリターン
                if(pArray[i].attack(p1)){return true;}
            } 
        }
        System.out.println();
        // ゲームキャラクターの配列全員のステータスを表示
        for(IGameChar gch: pArray){ gch.statusMsg();}
        // 敵の生死によるゲームエンドを返す
        return enemy_alive;
    }
    
}

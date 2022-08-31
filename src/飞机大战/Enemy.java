package 飞机大战;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import 飞机大战.BaseFrame;
import 飞机大战.MyPanel;

public class Enemy {
    //使用MyPanel的原因是，要调用MyPanel中的timer
    public MyPanel myPanel;

    //width，height是敌机宽度与高度
    public int width;
    public int height;

    //x，y是敌机的坐标
    public int x;
    public int y;

    public Image image;


    public int hp; //敌机的生命值
    private Item[] items;


    public Enemy(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

    public void drawSelf(Graphics g) {

    }

    //移除死掉或者飞出界面的敌机
    public void killed() {
        if(items!=null && items.length>0) {
            //敌机死后，释放奖品
            for(int i=0;i<items.length;i++) {
                Item item=items[i];

                //奖品出现的位置就是敌机死掉的位置
                //25*i目的是将奖品隔开
                item.x=this.x+25*i;
                item.y=this.y;

                this.myPanel.items.add(item);

            }
        }

        this.myPanel.enemys.remove(this);
    }


    //敌机处在被攻击状态，其生命值减少
    public void underAttack() {
        if(hp>0) {
            hp--;
        }
    }



}


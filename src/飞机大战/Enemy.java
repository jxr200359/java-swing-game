package �ɻ���ս;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import �ɻ���ս.BaseFrame;
import �ɻ���ս.MyPanel;

public class Enemy {
    //ʹ��MyPanel��ԭ���ǣ�Ҫ����MyPanel�е�timer
    public MyPanel myPanel;

    //width��height�ǵл������߶�
    public int width;
    public int height;

    //x��y�ǵл�������
    public int x;
    public int y;

    public Image image;


    public int hp; //�л�������ֵ
    private Item[] items;


    public Enemy(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

    public void drawSelf(Graphics g) {

    }

    //�Ƴ��������߷ɳ�����ĵл�
    public void killed() {
        if(items!=null && items.length>0) {
            //�л������ͷŽ�Ʒ
            for(int i=0;i<items.length;i++) {
                Item item=items[i];

                //��Ʒ���ֵ�λ�þ��ǵл�������λ��
                //25*iĿ���ǽ���Ʒ����
                item.x=this.x+25*i;
                item.y=this.y;

                this.myPanel.items.add(item);

            }
        }

        this.myPanel.enemys.remove(this);
    }


    //�л����ڱ�����״̬��������ֵ����
    public void underAttack() {
        if(hp>0) {
            hp--;
        }
    }



}


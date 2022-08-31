package �ɻ���ս;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import �ɻ���ս.BaseFrame;
import �ɻ���ս.MyPanel;

public class Enemy1 extends Enemy{

    private final Item[] items;

    public Enemy1(MyPanel myPanel) {
        super(myPanel);
        // TODO Auto-generated constructor stub

        this.width = 57;
        this.height = 43;
        this.hp = 3;

        this.x = (int) (Math.random()*(BaseFrame.frameWidth - this.width));
        this.y = - this.height;

        this.image = Toolkit.getDefaultToolkit().getImage("enemy1.png");
        this.items=new Item[] {
                new Item001(myPanel),
                new Item001(myPanel),
                new Item001(myPanel)
        };

    }

    //�л���ըЧ�������ڷŵ�������
    public Image[] dieImages = new Image[] {
            Toolkit.getDefaultToolkit().getImage("enemy1_down1.png"),
            Toolkit.getDefaultToolkit().getImage("enemy1_down2.png"),
            Toolkit.getDefaultToolkit().getImage("enemy1_down3.png"),
            Toolkit.getDefaultToolkit().getImage("enemy1_down4.png"),
    };

    //��ŵ�ǰͼƬ���±�
    public int imageIndex = 0;

    //���л�
    public void drawSelf(Graphics g) {
        //�жϵл��Ƿ񱻻���
        if(hp>0) {
            g.drawImage(this.image,x,y,width,height,null);
        }
        else {
            //������
            g.drawImage(this.dieImages[imageIndex],x,y,width,height,null);

            //ÿ��10�����л�һ��ͼƬ
            if(this.myPanel.timer%50==0) {
                imageIndex++;
                if(imageIndex>=this.dieImages.length) {
                    //�л�����
                    killed();
                }

            }
        }

        //�л������ƶ�,����л����������
        if(this.myPanel.timer%35==0) {
            y=y+10;
            if(y>=BaseFrame.frameHeight) {
                killed();
            }
        }
    }

}

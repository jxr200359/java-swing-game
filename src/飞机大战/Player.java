package �ɻ���ս;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import �ɻ���ս.BaseFrame;
import �ɻ���ս.MyPanel;


//�����Ա����

public class Player {
    //ʹ��MyPanel��ԭ���ǣ�Ҫ����MyPanel�е�timer
    public MyPanel myPanel;

    //width��height�����Ƿɻ������߶�
    public int width = 102;
    public int height = 126;

    //x��y�����Ƿɻ������꣨���Ͻǣ�
    public int x;
    public int y;



    //�����е����Ƿɻ� ͼƬ����ŵ�������
    public Image[] images = new Image[] {
            Toolkit.getDefaultToolkit().getImage("me1.png"),
            Toolkit.getDefaultToolkit().getImage("me2.png")
    };


    //����1�����飬��ͼƬ�Ž�ȥ


    //��ŵ�ǰͼƬ���±�//һ�����������
    public int imageIndex = 0;

    //���췽�����������꣬Ϊ��ʼ���긳ֵ
    public Player(MyPanel myPanel) {
        this.myPanel = myPanel;
        this.x = (BaseFrame.frameWidth - this.width)/2;
        this.y = BaseFrame.frameHeight - this.height*2;
    }
    //�����ɻ���ʵ�ֶ�̬�л���ʹ�ɻ���̬�л�
    public void drawSelf(Graphics g) {
        g.drawImage(this.images[imageIndex],x,y,width,height,null);

        //���ö�ʱ��ÿ��50�����л�һ��ͼƬ
        if(this.myPanel.timer%50==0) {
            imageIndex++;
            //ͼƬ���������һ����ͼƬ�±��ٴ���0��ʼ
            if(this.imageIndex==this.images.length) {
                this.imageIndex = 0;
            }
        }
        //�ж����Ƿɻ��Ƿ�Ե���Ʒ
        for(int i=0;i<this.myPanel.items.size();i++) {
            Item item=this.myPanel.items.get(i);
            if((this.x>=item.x-this.width && this.x<=item.x+item.width) && (this.y>=item.y-this.height && this.y<=item.y+item.height) ) {
                item.eated();
            }
        }

    }

}

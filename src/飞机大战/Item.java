package �ɻ���ս;
import java.awt.Graphics;
import java.awt.Image;

import �ɻ���ս.BaseFrame;
import �ɻ���ս.MyPanel;

public class Item {
    //ʹ��MyPanel��ԭ���ǣ�Ҫ����MyPanel�е�timer
    public MyPanel myPanel;

    //width��height�ǽ�Ʒ�Ŀ����߶�
    public int width;
    public int height;

    //x��y�ǽ�Ʒ������
    public int x;
    public int y;

    public Image[] images;

    //��Ʒ�������ٶȣ���л��ٶ�һ�£�
    public int speed;

    //��Ʒ��������ת�ٶȣ�ͼƬ�л�ʱ�䣩
    public int imageSpeed;

    public Item(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

    //��ŵ�ǰͼƬ���±�
    public int imageIndex = 0;

    //����Ʒ
    public void drawSelf(Graphics g) {
        g.drawImage(this.images[imageIndex],x,y,width,height,null);

        //ÿ��imageSpeed�����л�һ��ͼƬ
        if(this.myPanel.timer%imageSpeed==0) {
            imageIndex++;
            //ͼƬ���������һ����ͼƬ�±��ٴ���0��ʼ
            if(this.imageIndex==this.images.length) {
                this.imageIndex = 0;
            }
        }
        //ÿ��speed���뽱Ʒ����һ����λ
        if(this.myPanel.timer%speed==0) {
            //��Ʒ����
            y++;
            //��Ʒ�ƶ��������ڣ�������
            if(this.y>=BaseFrame.frameHeight) {
                this.myPanel.items.remove(this);
            }
        }

    }
    //��Ʒ���Ե�
    public void eated() {
        this.myPanel.items.remove(this);
    }
}


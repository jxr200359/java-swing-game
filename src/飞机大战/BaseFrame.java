package �ɻ���ս;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import �ɻ���ս.FrameMouseListener;
import �ɻ���ս.Enemy1;
import �ɻ���ս.Enemy2;
import �ɻ���ս.Enemy3;



public class BaseFrame extends JFrame{

    //���ڵĿ�Ⱥ͸߶ȣ�����ֵ�ɱ���ͼƬ��С������
    public static int frameWidth=480;
    public static int frameHeight=700;

    public MyPanel myPanel;

    //�������¼�
    public FrameMouseListener frameMouseListener;

    public void setTouchListener() {
        this.frameMouseListener=new FrameMouseListener();
        this.frameMouseListener.baseFrame = this;
        this.addMouseListener(this.frameMouseListener);
    }
    public void addEnemyType(Class c) {
        this.myPanel.enemyType.add(c);
    }

    //���췽��
    public  BaseFrame()
    {
        //���ñ���
        super("�ɻ���ս");

        //�����Ļ�ֱ���
        Dimension  screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //���ô���λ�úʹ�С�����Ͻǣ�x��y������͸ߣ�w��h��
        setBounds((int) ((screenSize.getWidth()-frameWidth)/2),30,frameWidth,frameHeight);

        //���ò��ַ�ʽ
        setLayout(null);

        //����һ��MyPanel����
        this.myPanel=new MyPanel();

        //����MyPanel�����λ�úʹ�С
        this.myPanel.setBounds(0,0,frameWidth,frameHeight);

        //�������ӵ�������
        this.add(this.myPanel);

        //���ü�����
        setTouchListener();
        //��ӵл�����
        addEnemyType(Enemy1.class);
        addEnemyType(Enemy2.class);
        addEnemyType(Enemy3.class);


        //��ʾ���ڣ�JFrame Ĭ�ϴ��ڲ���ʾ
        setVisible(true);

        //���ô��ڹرգ��رմ��ں󣬳���ֹͣ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}


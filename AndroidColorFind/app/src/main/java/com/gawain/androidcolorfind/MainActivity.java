package com.gawain.androidcolorfind;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    private int firstPointWidth = 3015;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap sourceBitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.source1);
        boolean isFind = findTargetListPointInPicture(sourceBitmap,firstPointWidth,initTargetPoint());
        System.out.println("isFind " + isFind);
    }

    public boolean findTargetListPointInPicture(Bitmap sourceBitmap,int firstPointWidth, HashMap<Integer,TargetPoint> targetList){
        int h = sourceBitmap.getHeight();
        int w = sourceBitmap.getWidth();
        boolean isTarget = false;
        if(firstPointWidth < w){
            for(int y = 0; y < h; y++){
                int color = sourceBitmap.getPixel(firstPointWidth, y);
                int r = Color.red(color);
                int g = Color.green(color);
                int b = Color.blue(color);
//                int a = Color.alpha(color);

                if(checkColor(r,g,b,targetList.get(1)))
                {
                    for(int i = 2; i <= targetList.size(); i++){
                        ArrayList<Integer> checkPointColor = getNearPoint(sourceBitmap,firstPointWidth,y,targetList.get(i));
                        if(checkColor(checkPointColor.get(0),checkPointColor.get(1),checkPointColor.get(2),targetList.get(i))){
                            isTarget = true;
                            if(i == 9){
                                return isTarget;
                            }
                        }else {
                            isTarget = false;
                            break;
                        }
                    }
                }
            }
        }
        return isTarget;
    }

    public ArrayList<Integer>  getNearPoint(Bitmap sourceBitmap,int firstPointWidth, int firstPointHeight, TargetPoint targetPoint){
        int color = sourceBitmap.getPixel((firstPointWidth + targetPoint.getPointWidth()), (firstPointHeight + targetPoint.getPointHeight()));
        ArrayList<Integer> checkPointColor = new ArrayList<>();
        checkPointColor.add(Color.red(color));
        checkPointColor.add(Color.green(color));
        checkPointColor.add(Color.blue(color));
        return checkPointColor;
    }

    private double differentRate = 0.01;
    public boolean checkColor(int sourceColorRed, int sourceColorGreen, int sourceColorBlue, TargetPoint targetPoint){
        double r3 =( sourceColorRed - targetPoint.getPointRed()) / 256.0000;
        double g3 = (sourceColorGreen - targetPoint.getPointGreen()) / 256.0000;
        double b3 = (sourceColorBlue - targetPoint.getPointBlue()) / 256.0000;

        double diff = sqrt(r3 * r3 + g3 * g3 + b3 * b3);
//                System.out.println(diff);
        //diff more small, more like the target color, more good
        if(diff < differentRate)
        {
//            System.out.println("SourceColor: Red:" + sourceColorRed + " Green:" + sourceColorGreen + " Blue:" + sourceColorBlue);
//            System.out.println("TargetColor: Red:" + targetPoint.getPointRed() + " Green:" + targetPoint.getPointGreen() + " Blue:" + targetPoint.getPointBlue());
//            System.out.println("Different Rate:" + diff);
            return true;
        }
        else {
            return false;
        }


    }

    public HashMap<Integer,TargetPoint> initTargetPoint(){
        HashMap<Integer,TargetPoint> targetPointHashMap = new HashMap<>();
        TargetPoint targetPoint1 = new TargetPoint(0,0,232,232,232,1);
        TargetPoint targetPoint2 = new TargetPoint(-27,-27,232,232,232,2);
        TargetPoint targetPoint3 = new TargetPoint(0,-27,255,255,255,3);
        TargetPoint targetPoint4 = new TargetPoint(27,-27,232,232,232,4);
        TargetPoint targetPoint5 = new TargetPoint(-27,0,255,255,255,5);
        TargetPoint targetPoint6 = new TargetPoint(27,0,255,255,255,6);
        TargetPoint targetPoint7 = new TargetPoint(-27,30,232,232,232,7);
        TargetPoint targetPoint8 = new TargetPoint(0,30,255,255,255,8);
        TargetPoint targetPoint9 = new TargetPoint(27,30,232,232,232,9);
        targetPointHashMap.put(targetPoint1.getCheckPointNumber(),targetPoint1);
        targetPointHashMap.put(targetPoint2.getCheckPointNumber(),targetPoint2);
        targetPointHashMap.put(targetPoint3.getCheckPointNumber(),targetPoint3);
        targetPointHashMap.put(targetPoint4.getCheckPointNumber(),targetPoint4);
        targetPointHashMap.put(targetPoint5.getCheckPointNumber(),targetPoint5);
        targetPointHashMap.put(targetPoint6.getCheckPointNumber(),targetPoint6);
        targetPointHashMap.put(targetPoint7.getCheckPointNumber(),targetPoint7);
        targetPointHashMap.put(targetPoint8.getCheckPointNumber(),targetPoint8);
        targetPointHashMap.put(targetPoint9.getCheckPointNumber(),targetPoint9);
        return targetPointHashMap;
    }

}

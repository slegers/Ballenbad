package deel4.domain;

/**
 * Created by yanice on 11/05/17.
 */
public class SchuinBaan implements IBaan {
    private int x,y;
    boolean rechtsOnder;

    public SchuinBaan(int x, int y){
        this.x = x;
        this.y = y;
        rechtsOnder = true;
    }

    @Override
    public int getX() {

        if(rechtsOnder){
            x = x +2;
        }else{
            x = x-2;
        }
        return x;
    }

    @Override
    public int getY() {
        if(rechtsOnder){
        y +=2;
    }else{
         y -=2;
    }
        return y;
    }

    @Override
    public void veranderRichting() {
        rechtsOnder = !rechtsOnder;
    }
}

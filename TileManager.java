import java.util.*;
import java.awt.*;

class TileManager {
    private ArrayList<Tile> tileList = new ArrayList<Tile>();
    private Tile save;

    public void addTile(Tile rect){
        tileList.add(rect);
    }

    public void drawAll(Graphics g){
        for (int i = 0; i<tileList.size(); i++){
            tileList.get(i).draw(g);
        }
    }

    public void raise(int x, int y){
        for (int i = tileList.size()-1; i >= 0  ; i--){
            if (isTouching(x, y, tileList.get(i)) == true){
                save = tileList.get(i);
                tileList.remove(i);
                tileList.add(save);
                System.out.println(tileList.toString());
                
                
                return;
            }
        }
    }

    public void lower(int x, int y){
        for (int i = tileList.size() -1; i >= 0 ; i--){
            if (isTouching(x, y, tileList.get(i)) == true){
                save = tileList.get(i);
                tileList.add(0, save);
                tileList.remove(i+1);
                
                return;
            }
        }  
    }

    public void delete (int x, int y){
        for (int i = tileList.size()-1; i >= 0 ; i--){
            if (isTouching(x, y, tileList.get(i)) == true){
                tileList.remove(i);
                return;
            }
        }       
    }

    public void deleteAll(int x, int y){
        for (int i = tileList.size()-1; i > 0 ; i--){
            if (isTouching(x, y, tileList.get(i)) == true){
                tileList.remove(i);
            }
        }  
    }

    public void shuffle(int width, int height){
        ArrayList<Tile> subList = new ArrayList<Tile>();
        int random;
        while (tileList.size() > 0){
            random = (int) Math.random() * (tileList.size() + 1);
            tileList.get(random).setX((Math.random() * 
            (double)(300 - tileList.get(random).getWidth())));
            tileList.get(random).setY((Math.random() * 
            (double)(300 - tileList.get(random).getHeight())));
            subList.add(tileList.get(random));
            tileList.remove(random);
            
        }
        tileList = subList;
        System.out.println("Randomized");
    }

    public boolean isTouching(int x, int y, Tile t){
        if ((x >= t.getX() && x < (t.getX() + t.getWidth())) &&
         (y >= t.getY() && y < (t.getY() + t.getHeight()))){
            return true;
        }

        else{return false;}
    }
}




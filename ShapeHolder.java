import java.util.Iterator;
import java.util.NoSuchElementException;
import shapes.*;

public class ShapeHolder implements Iterable<Shape>{
    Shape[] shapes;
    int counter = 0;
    private static ShapeHolder inst;

    private ShapeHolder(){
        this.shapes = new Shape[50];
    }

    public static ShapeHolder getInstance(){
        if(inst == null){
            inst = new ShapeHolder();
        }
        return inst;
    }

    public ShapeHolderIterator iterator(){
        return new ShapeHolderIterator(this);
    }

    public void addShape(Shape shape){
        if(counter < 50){
            this.shapes[counter] = shape;
            counter++;
        }
    }

    public void removeShape(){
        if(counter > 0){
            this.shapes[counter] = null;
            counter--;
        }   
    }
}

class ShapeHolderIterator implements Iterator<Shape>{
    int current = 0;
    ShapeHolder sh;

    public ShapeHolderIterator(ShapeHolder sh){
        this.sh = sh;
    }

    public boolean hasNext(){
        return (current < sh.counter);
    }

    public Shape next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return sh.shapes[current++];
    }
}
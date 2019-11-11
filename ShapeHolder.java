/**
 * ShapeHolder.java
 * an object that holds all the shapes, is iterable through all types of shapes
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import shapes.*;

/**
 * ShapeHolder class
 * iterable object shape
 */

public class ShapeHolder implements Iterable<Shape>{
    Shape[] shapes;
    int counter = 0;
    private static ShapeHolder inst;


    /**
     * ShapeHolder
     * creates an array of shapes and sets its max to 50
     */
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
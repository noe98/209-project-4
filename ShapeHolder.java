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

    /**
     * ShapeHolder getInstance
     * instance getter
     * because it is a singleton, we create a new instance of the ShapeHolder
     * @return inst
     */

    public static ShapeHolder getInstance(){
        if(inst == null){
            inst = new ShapeHolder();
        }
        return inst;
    }

    /**
     * ShapeHolderIterator
     * @return new ShapeHolderIterator
     */

    public ShapeHolderIterator iterator(){
        return new ShapeHolderIterator(this);
    }

    /**
     * addShape
     * @param Shape shape
     * adds new shapes into array if they can fit
     */

    public void addShape(Shape shape){
        if(counter < 50){
            this.shapes[counter] = shape;
            counter++;
        }
    }

    /**
     * removeShape
     * removes shapes from the counter
     */

    public void removeShape(){
        if(counter > 0){
            this.shapes[counter] = null;
            counter--;
        }   
    }
}


/**
 * ShapeHolderIterator implements Iterator<Shape>
 * sets curret to zero
 * creates ShapeHolder
 */

class ShapeHolderIterator implements Iterator<Shape>{
    int current = 0;
    ShapeHolder sh;

    /**
     * ShapeHolderIterator
     * @param ShapeHolder sh
     * sets sh
     */
    public ShapeHolderIterator(ShapeHolder sh){
        this.sh = sh;
    }

    /**
     * hasNext
     * @return boolean of if the shape is followed by a shape in the counter
     */

    public boolean hasNext(){
        return (current < sh.counter);
    }

    /**
     * Shape next
     * if the shape does not have a next, @throw exception
     * else
     * @return sh.shapes and add to current
     */

    public Shape next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return sh.shapes[current++];
    }
}
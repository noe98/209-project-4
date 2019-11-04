import java.util.Iterator;

public class ShapeHolder implements Iterable<Shape>{
    public Iterator<> iterator(){
        return new ShapeHolderIterator<>(this);
    }
}
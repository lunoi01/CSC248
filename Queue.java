import java.util.LinkedList;
public class Queue
{
    protected LinkedList list;
    public Queue()
    {
        list=new LinkedList();
    }
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    public int size()
    {
        return list.size();
    }
    public void enqueue(Object element)
    {
        list.add(element);
    }
    public Object dequeue()
    {
        return list.removeFirst();
    }
    public Object getFirst()
    {
        return list.getFirst();
    }
}
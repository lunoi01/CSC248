public class LinkedList
{
    private Node head;
    private Node current;
    private Node tail;
    private String name;
    public LinkedList(String s)
    {
        name=s;
        head=current=tail=null;
    }
    public LinkedList()
    {
        this("linked list");
    }
    //a
  
    public void insertAtBack(Object num) {
        if(head == null) {
            head = new Node(num);
            tail = head;
        }
        else {
            tail = tail.next = new Node(num);
        }
    }
    
    //b
    public Object removeFromFront() throws EmptyListException
    {
        Object removeItem=null;
        if(isEmpty())
        throw new EmptyListException(name);
        
        removeItem=head.data;
        if(head.equals(tail))
        head=tail=null;
        else
        head=head.next;
        return removeItem;
    }
    public Object removeFromBack() throws EmptyListException
    {
        Object removeItem=null;
        if(isEmpty())
        throw new EmptyListException(name);
        
        removeItem=tail.data; 
        if(head.equals(tail))
        head=tail=null;
        else
        {
            Node current=head;
            while(current.next!=tail)
            current=current.next;
            tail=current;
            current.next=null;
        }
        return removeItem;
    }
    
      
    public Object removeAtBack() {
        Object remove = null;
        Node previous = null;
        
        if(head == null ) {
            remove = null;
        }
        else if (head == tail) {
            remove = head.data;
            head = null;
            tail = null;
        }
        else {
            
            if(tail == head.next) {
                
                remove = tail.data;
                tail = head;
            }
            else {
                current = head;
                while(current.next != null) {
                    previous = current;
                    current = previous.next;
                }
                remove = tail.data;
                tail = previous;
                previous.next = null; 
            }
            
        }
        
        return remove;
    }
    //c
    public Object getHead()
    {
        if(isEmpty())
        return null;
        else
        {
            current=head;
            return current.data;
        }
    }
    public Object getNext()
    {
        if(current!=tail)
        {
            current=current.next;
            return current.data;
        }
        else
        return null;
    }
    //d
    public int size()
    {
        Node current=head;
        int count=0;
        while(current!=null)
        {
            count++;
            current=current.next;
        }
        return count;
    }
    //e
    public boolean isEmpty()
    {
        return head==null;
    }
    //f
    public void display(Object insertItem)
    {
        Node current=head;
        if(isEmpty())
        {
            System.out.println("list is empty");
        }
        else
        {
            while(current!=null)
            {
                System.out.println(current.data);
                current=current.next;
            }
        }
    }
}
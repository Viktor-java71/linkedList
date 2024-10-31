public class MyLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void add(T obj){
        if (head==null){
            head = new Node<>(obj,null,null);
            tail = head;
        } else {
            Node<T> newNode =  new Node<>(obj,tail, null );
            newNode.getPrev().setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void print(){
        Node<T> currentNode = head;
        while (currentNode!=null){
            System.out.println(currentNode.getObj());
            currentNode = currentNode.getNext();
        }
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        Node<T> currenNode = head;
        while (currenNode!=null){
            sb.append(currenNode.getObj()).append(System.lineSeparator());
            currenNode = currenNode.getNext();
        }
        return sb.toString();

    }

    private Node<T> getNodeByIndex(int index){
        if(index<0|| index>=size){
            return null;
        };
        int currentIndex = 0;
        Node<T> currenNode = head; //(0)
        while (currenNode!=null && currentIndex!=index){
            currenNode = currenNode.getNext();
            currentIndex++;
        }
        return currenNode;
    }

    public T get(int index){
        Node<T> nodeByIndex = getNodeByIndex(index);
        if (nodeByIndex!=null){
            return nodeByIndex.getObj();
        }
        return null;
    }

    public int size(){
        return size;
    }


    public  static <E> MyLinkedList<E> of(E ... elements){
        MyLinkedList<E> result = new MyLinkedList<>();
        for (E element: elements){
            result.add(element);
        }
        return result;
    }





}

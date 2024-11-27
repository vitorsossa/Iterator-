interface Iterator<T> {
  boolean hasNext();

  T getNext();

  void reset();
}

interface Lista<T> {
  Iterator<T> criarIteradorSimples();

  Iterator<T> criarIteradorBFS();
}

class Node<T> {
  T data;
  Node<T> next;

  Node(T data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList<T> implements Lista<T> {
  private Node<T> head;
  private Node<T> current;

  public LinkedList() {
    this.head = null;
    this.current = null;
  }

  public void add(T data) {
    Node<T> newNode = new Node<T>(data);
    if (head == null) {
      head = newNode;
      current = head;
    } else {
      current.next = newNode;
      current = newNode;
    }
  }

  public Iterator<T> criarIteradorSimples() {
    return new LinkedListIterator<T>(this);
  }

  public Iterator<T> criarIteradorBFS() {
    // Retornar um iterador breadth first search
    return null;
  }

  public Node<T> getHead() {
    return head;
  }

}

class LinkedListIterator<T> implements Iterator<T> {
  private LinkedList<T> lista;
  private Node<T> current;

  public LinkedListIterator(LinkedList<T> ls) {
    lista = ls;
    current = lista.getHead();
  }

  public boolean hasNext() {
    return current != null;
  }

  public T getNext() {
    if (current == null) {
      return null;
    }
    T data = current.data;
    current = current.next;
    return data;
  }

  public void reset() {
    current = lista.getHead();
  }
}

public class Main {
  public static void main(String[] args) {

    LinkedList<Integer> list = new LinkedList<Integer>();

    list.add(1);
    list.add(5);
    list.add(3);

    Iterator<Integer> iterador = list.criarIteradorSimples();

    iterador.reset();
    while (iterador.hasNext()) {
      System.out.println(iterador.getNext());
    }

  }
}

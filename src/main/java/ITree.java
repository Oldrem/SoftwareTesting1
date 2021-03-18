public interface ITree<T> {


    public boolean add(T value);

    public T remove(T value);

    public void clear();

    public boolean contains(T value);

    public int size();

    public boolean validate();

    public java.util.Collection<T> toCollection();

}

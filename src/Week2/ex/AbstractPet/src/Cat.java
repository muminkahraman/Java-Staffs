public class Cat extends Pet
{
    private int lengthOfTail;

    public Cat(String name, int lengthOfTail)
    {
        super(name);
        this.lengthOfTail = lengthOfTail;
    }

    public int getLengthOfTail()
    {
        return lengthOfTail;
    }

    public void setLengthOfTail(int lengthOfTail)
    {
        this.lengthOfTail = lengthOfTail;
    }

    @Override
    public String toString()
    {
        return super.getName() + " (Tail: " + lengthOfTail + "cm)";
    }
}

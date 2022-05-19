package array_sorter;



/**
 *
 * @author gdm1
 */
public abstract class ArraySorter
{
    protected final int[] numbers;
    private final String sortType;
    protected long sortDuration = -1;

    public ArraySorter(int[] numbers, String sortType)
    {
        this.numbers = numbers;
        this.sortType = sortType;
    }

    public abstract int[] sort();

    @Override
    public String toString()
    {
        return "Sort (" + sortType + ") took " + sortDuration + " milliseconds";
    }
}

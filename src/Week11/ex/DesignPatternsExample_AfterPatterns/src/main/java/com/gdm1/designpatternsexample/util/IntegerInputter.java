package com.gdm1.designpatternsexample.util;

import java.util.InputMismatchException;

/**
 *
 * @author gdm1
 */
public class IntegerInputter extends Inputter<Integer>
{

    public IntegerInputter()
    {
        super();
    }

    @Override
    public Integer input(String prompt)
    {
        boolean dataOK = false;
        int num = -1;

        do
        {
            System.out.println(prompt);
            try
            {
                num = kybd.nextInt();
                kybd.nextLine(); //flush the buffer
                dataOK = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nERROR: Please enter an integer.");
            }
        }
        while (!dataOK);

        return num;
    }
}

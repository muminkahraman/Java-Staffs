package com.gdm1.designpatternsexample.command;

/**
 *
 * @author gdm1
 */
public class Null_Command implements Command
{

    @Override
    public void execute()
    {
        System.out.println("\nERROR: Choice not recognised");
    }
}

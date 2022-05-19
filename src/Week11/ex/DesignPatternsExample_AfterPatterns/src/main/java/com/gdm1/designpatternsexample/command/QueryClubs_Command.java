package com.gdm1.designpatternsexample.command;

import com.gdm1.designpatternsexample.database.ClubGateway;

/**
 *
 * @author gdm1
 */
public class QueryClubs_Command implements Command
{

    @Override
    public void execute()
    {
        System.out.println("\nAll clubs");
        System.out.println("=========");
        ClubGateway
                .getInstance()
                .findAll()
                .stream()
                .forEach(c -> System.out.printf("%4d\t%s\n", c.getId(), c.getName()));
        System.out.println("=========");
    }
}

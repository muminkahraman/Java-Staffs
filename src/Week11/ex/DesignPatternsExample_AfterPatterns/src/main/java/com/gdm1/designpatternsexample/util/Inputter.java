package com.gdm1.designpatternsexample.util;

import java.util.Scanner;

/**
 *
 * @author gdm1
 */
public abstract class Inputter<T>
{
    protected Scanner kybd = new Scanner(System.in);

    public abstract T input(String prompt);
}

package com.mujahidk.prime.strategy;

public class InvalidConsoleArgumentsHandler
        implements IHandler {

    @Override
    public void handle() {
        String usage = "Invalid arguments.\n" 
                + "---------------------------------\n"
                + "Usage: program <number> <thread>\n" 
                + "\tnumber: Number till prime numbers should be searched.\n"
                + "\tthreads: number of threads to use.";
        System.out.println(usage);
    }

}

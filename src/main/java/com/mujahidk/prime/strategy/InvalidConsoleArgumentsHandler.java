package com.mujahidk.prime.strategy;

/**
 * When invalid arguments are passed, this handler is used to write usage message to console.
 *
 */
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

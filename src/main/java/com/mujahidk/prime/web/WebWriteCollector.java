package com.mujahidk.prime.web;

import java.io.IOException;
import java.io.Writer;

import com.mujahidk.prime.module.IPrimeCollector;

/**
 * PrimeCollector for writing the contents to write the prime number to character stream. 
 *
 */
public class WebWriteCollector implements IPrimeCollector {
    private int count = 0;
    private final Writer writer;
    private final String format;
    
    /**
     * Create instance of WebWriteCollector.
     * @param writer - Character stream writer instance.
     * @param format - String format type to write prime number to writer. 
     */
    public WebWriteCollector(final Writer writer, final String format) {
        this.writer = writer;
        this.format = format;
    }
    
    /**
     * Collect the prime number and write it to writer.
     * Not thread safe.
     */
    @Override
    public void collect(int prime) {
        try {
            writer.write(String.format(format, prime));
        } catch (IOException ioe) {
            // If there is an exception writing to stream, this collector does
            // not know how to handle. So re-throw as RuntimeException. 
            throw new RuntimeException("IOException while writing to writer.", ioe);
        }
        count++;
    }

    @Override
    public int count() {
        return count;
    }

}

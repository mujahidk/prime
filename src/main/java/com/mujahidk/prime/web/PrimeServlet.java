package com.mujahidk.prime.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mujahidk.prime.Arguments;
import com.mujahidk.prime.Parser;
import com.mujahidk.prime.module.IPrimeCollector;
import com.mujahidk.prime.module.SlowPrimeFinder;

public class PrimeServlet
        extends HttpServlet {

    private static final long serialVersionUID = -3075651316832105023L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the response as html text.
        resp.setContentType("text/html");
        
        PrintWriter writer = resp.getWriter();
        
        String limit = readParam(req, "limit");
        
        String[] args = new String[] { limit };
        Arguments arguments = new Parser(args).parse();
        
        if (arguments.isValid()) {
            // Format string for printing prime number in html output.
            final String format = "%s</br>";
            // WebWriteCollector of IPrimeCollector type, to write the html
            // output to servlet response stream when prime number is found.

            final IPrimeCollector collector = new WebWriteCollector(writer, format);
            // PrimeFinder to search for primes.
            new SlowPrimeFinder(arguments.getLimit(), collector).find();
            // Output the count of primes found.
            writer.write("Prime numbers generated " + collector.count());
        } else {
            writer.write("Invalid arguments.");
        }
        
    }
    
    private String readParam(HttpServletRequest req, String name){
        String value = req.getParameter(name);
        if(value == null || value.trim().equals("")) {
            return null;
        } else {
            return value.trim();
        }
    }
}

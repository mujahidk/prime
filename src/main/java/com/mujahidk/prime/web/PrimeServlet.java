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
        // Get the response stream writer.
        PrintWriter writer = resp.getWriter();
        // Get the parameter from the query string.
        String limit = readParam(req, "limit");
        // Parse the parameter.
        String[] args = new String[] { limit };
        Arguments arguments = new Parser(args).parse();
        // Start the html content.
        writer.write(HTML_BEGIN);
        if (arguments.isValid()) {
            writer.write("<div>");
            // WebWriteCollector of IPrimeCollector type, to write the html
            // output to servlet response stream when prime number is found.
            final IPrimeCollector collector = new WebWriteCollector(writer, "%s, ");
            // PrimeFinder to search for primes.
            new SlowPrimeFinder(arguments.getLimit(), collector).find();
            // Output the count of primes found.
            writer.write( String.format("</div>\n<br /><p class=\"text-success\">Prime numbers found: %s</p>\n", collector.count()));
        } else {
            // Write the error message for invalid input.
            writer.write("<p class=\"text-danger\">Invalid input.</p>\n");
        }
        // End the html content.
        writer.write(HTML_END);
    }
    
    private String readParam(HttpServletRequest req, String name){
        String value = req.getParameter(name);
        if(value == null || value.trim().equals("")) {
            return null;
        } else {
            return value.trim();
        }
    }
    
    private final String HTML_BEGIN = "<!DOCTYPE html>\r\n"
            + "<html lang=\"en\">\r\n"
            + "<head>\r\n<meta charset=\"utf-8\">\r\n"
            + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
            + "<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\r\n"
            + "<title>Prime numbers</title>\r\n\r\n"
            + "<!-- Bootstrap -->\r\n"
            + "<!-- Latest compiled and minified CSS -->\r\n"
            + "<link rel=\"stylesheet\"\r\n\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n"
            + "\tintegrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n"
            + "\tcrossorigin=\"anonymous\">\r\n\r\n"
            + "<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\r\n"
            + "<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n"
            + "<!--[if lt IE 9]>\r\n      "
            + "<script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\r\n      "
            + "<script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n    "
            + "<![endif]-->\r\n</head>\r\n<body>\r\n  <div class=\"container\">\r\n  "
            + "<h1>Prime numbers</h1>";
    private final String HTML_END = "<a href=\"/prime/\">Home</a>"
            + "\n</div>\t<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n"
            + "\t<script\r\n\t\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n"
            + "\t<!-- Latest compiled and minified JavaScript -->\r\n"
            + "\t<script\r\n\t\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"\r\n"
            + "\t\tintegrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\"\r\n"
            + "\t\tcrossorigin=\"anonymous\"></script>\r\n"
            + "</body>\r\n"
            + "</html>";
            
}

package org.example.WebAPI;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import org.example.DataAccess.QuoteDB;
import org.example.DataAccess.TestDatabase;
import org.example.QuoteDomain.Quote;

public class QuoteApiHandler {
    private static final QuoteDB database = new TestDatabase();

    /**
     * Get all quotes
     *
     * @param context The Javalin Context for the HTTP GET Request
     */
    public static void getAll(Context context) {
        context.json(database.all());
    }

    /**
     * Get one quote
     *
     * @param context The Javalin Context for the HTTP GET Request
     */
    public static void getOne(Context context) {
        Integer id = context.pathParamAsClass("id", Integer.class).get();
        Quote quote = database.get(id);
        context.json(quote);
    }

    /**
     * Create a new quote
     *
     * @param context The Javalin Context for the HTTP POST Request
     */
    public static void create(Context context) {
        Quote quote = context.bodyAsClass(Quote.class);
        Quote newQuote = database.add(quote);
        context.header("Location", "/quote/" + newQuote.getId());
        context.status(HttpCode.CREATED);
        context.json(newQuote);
    }
}
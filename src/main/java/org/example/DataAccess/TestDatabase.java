package org.example.DataAccess;

import org.example.QuoteDomain.Quote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDatabase implements QuoteDB {
    private Map<Integer, Quote> quotes;

    public TestDatabase() {
        quotes = new HashMap<>();
        this.add(Quote.create("There is no snooze button on a cat who wants breakfast.", "Unknown"));
        this.add(Quote.create("Never try to outstubborn a cat.","Robert A. Heinlein"));
        this.add(Quote.create("To err is human, to purr is feline.", "Robert Byrne"));
    }

    @Override
    public Quote get(Integer id) {
        return quotes.get(id);
    }

    @Override
    public List<Quote> all() {
        return new ArrayList<>(quotes.values());
    }

    @Override
    public Quote add(Quote quote) {
        Integer index = quotes.size() + 1;
        quote.setId(index);
        quotes.put(index, quote);
        return quote;
    }

}

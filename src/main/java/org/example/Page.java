package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Page {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<MoviesFromAPI> results;

    public Page() {
    }

    public Page(int page, List<MoviesFromAPI> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MoviesFromAPI> getResults() {
        return results;
    }

    public void setResults(List<MoviesFromAPI> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", results=" + results +
                '}';
    }
}

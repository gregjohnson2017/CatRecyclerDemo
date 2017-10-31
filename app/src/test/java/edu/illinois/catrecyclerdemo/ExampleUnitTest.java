package edu.illinois.catrecyclerdemo;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void parseCats() throws Exception {
        Gson gson = new Gson();
        Cat[] cats = gson.fromJson(Cat.CATS_JSON, Cat[].class);
        for (Cat cat : cats) {
            System.out.println(cat);
        }

    }

}
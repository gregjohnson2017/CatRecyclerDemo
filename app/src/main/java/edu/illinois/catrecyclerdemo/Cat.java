package edu.illinois.catrecyclerdemo;

/**
 * Created by zilles on 10/31/17.
 */

public class Cat {
    public static final String CATS_JSON = "[\n" +
            "{ \"name\": \"Speedy\", \n" +
            "  \"location\": \"Austin, TX\",         \n" +
            "  \"imageUrl\": \"http://r.ddmcdn.com/s_f/o_1/cx_462/cy_245/cw_1349/ch_1349/w_720/APL/uploads/2015/06/caturday-shutterstock_149320799.jpg\"},\n" +
            "{ \"name\": \"Milo\", \n" +
            "  \"location\": \"Venice, CA\",         \n" +
            "  \"imageUrl\": \"https://img.buzzfeed.com/buzzfeed-static/static/2015-03/3/16/enhanced/webdr09/enhanced-7711-1425417143-1.jpg?downsize=715:*&output-format=auto&output-quality=auto\"},\n" +
            "{ \"name\": \"Fifi\", \n" +
            "  \"location\": \"Bozeman, MT\",         \n" +
            "  \"imageUrl\": \"https://www.petfinder.com/wp-content/uploads/2013/09/cat-black-superstitious-fcs-cat-myths-162286659.jpg\"},\n" +
            "{ \"name\": \"Fluffles\", \n" +
            "  \"location\": \"Chicago, IL\"},\n" +
            "{ \"name\": \"Shadow\", \n" +
            "  \"location\": \"Champaign, IL\"},\n" +
            "{ \"name\": \"Bladed Death\", \n" +
            "  \"location\": \"St Louis, MO\",         \n" +
            "  \"imageUrl\": \"https://vetstreet.brightspotcdn.com/dims4/default/38e16fc/2147483647/thumbnail/320x275/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2F04%2F09%2F1a9bfeea41e5b32f71c5cebd393d%2Fkitten-playing-with-toy.jpg\"},\n" +
            "{ \"name\": \"Charles\", \n" +
            "  \"location\": \"New York, NY\",         \n" +
            "  \"imageUrl\": \"https://media.mnn.com/assets/images/2016/11/cat-with-big-eyes-gimo.jpg.653x0_q80_crop-smart.jpg\"}\n" +
            "]\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n";


    private String name;
    private String location;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Cat() {
    }

    public Cat(String name, String location, String imageUrl) {
        this.name = name;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return name + " (" + location + ") " + ((imageUrl != null) ? (" [" + imageUrl + "]") : "");
    }

}

# Web Scraping Starter-Kit using Jsoup
JSoup is a powerful library for web scraping in Java. This repository is a very high level way to use and understand web scraping.

## Usage
Download or clone this repository and import this in javafile by...
```
import javaweb.JavaWebOps;
```
### Example Code
The code below showcase the usage of Java Web Operations library.
```
import javaweb.JavaWebOps;

import java.util.List;

public class main {
    public static void main(String[] args) {
        JavaWebOps jwo = new JavaWebOps("https://www.google.com"); // Initialize with web url to scrap

        String title = jwo.getTitleOfPage(); // Get the title
        String html = jwo.getSource(); // Get the whole source code

        List<String> links = jwo.getAllLinks(); // Get All links (a href="")
        List<String> images = jwo.getAllImages(); // Get All Images
        List<String> texts = jwo.getAllTexts(); // Get All Texts

        String data_at_id = jwo.getDataAtElementId("submit"); // return the text of selected ID
        String data_at_class = jwo.getDataAtElementClass("header"); // return the text of selected class
        String data_at_tag = jwo.getDataAtElementTag("sound"); // return the text of selected Tag

    }
}

```
## Build Instructions
Use normal Java Development Kit to use this library.
```
javac yourjavafile.class
java yourjavafile
```

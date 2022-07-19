package com.cydeo.Day5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {


    @Test
    public void simpleTest1() {
        assertThat(5 + 5, is(10));
        assertThat(2 * 3, is(equalTo(6)));

        assertThat(2 * 3, is(not(equalTo(8))));

        assertThat(4*5, is(greaterThan(15)));
      }

      @DisplayName("Assertion with string")
    @Test
    public void test2(){
        String text="B22 is learning Hamcrest";

        assertThat(text, is("B22 is learning Hamcrest"));
        assertThat(text,equalTo("B22 is learning Hamcrest"));
        assertThat(text,is(equalTo("B22 is learning Hamcrest")));


        assertThat(text,startsWith("B22"));

        assertThat(text,startsWithIgnoringCase("b22")); //it is NOT CASE SENSITIVE
          assertThat(text,endsWith("crest"));

          //check if text contains String learning
          assertThat(text,containsString("learning"));
          //with ignoring case
          assertThat(text,containsStringIgnoringCase("LEARNING"));

          String str ="  ";

          //check if above str is blank
          assertThat(str,blankString());
          //check if trimmed str is empty string
          assertThat(str.trim(),emptyString());
      }

    @DisplayName("Hamcrest for Collection")
    @Test
    public void testCollection(){

        List<Integer> listOfNumbers = Arrays.asList(1,4,5,6,32,54,66,77,45,23);

        //check size of the list
        assertThat(listOfNumbers,hasSize(10));
        //check if this list hasItem 77
        assertThat(listOfNumbers,hasItem(77));
        //check if this list hasItems 77,54,23
        assertThat(listOfNumbers,hasItems(77,54,23));

        //check if all numbers greater than 0
        assertThat(listOfNumbers,everyItem(greaterThan(0)));

    }

}




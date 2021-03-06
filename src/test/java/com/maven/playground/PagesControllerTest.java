package com.maven.playground;

/**
 * Created by Claire on 4/29/17.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(PagesController.class)
public class PagesControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testPi() throws Exception {

        this.mvc.perform(get("/math/pi")).andExpect(status().isOk())
                .andExpect(content().string("3.14159"));
    }

    @Test
    public void testAdd() throws Exception {

        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6")).andExpect(status()
                .isOk()).andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    public void testMultiply() throws Exception {

        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6")).andExpect(status()
                .isOk()).andExpect(content().string("4 * 6 = 24"));
    }

    @Test
    public void testDivision() throws Exception {

        this.mvc.perform(get("/math/calculate?operation=divide&x=30&y=5")).andExpect(status()
                .isOk()).andExpect(content().string("30 / 5 = 6"));
    }

    @Test
    public void testSubtraction() throws Exception {

        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6")).andExpect(status()
                .isOk()).andExpect(content().string("4 - 6 = -2"));
    }

    @Test
    public void testNoGivenOperation() throws Exception {

        this.mvc.perform(get("/math/calculate?x=30&y=5")).andExpect(status()
                .isOk()).andExpect(content().string("30 + 5 = 35"));
    }

    @Test
    public void testSameParamName() throws Exception {
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6")).andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

    @Test
    public void testVolume() throws Exception {
        this.mvc.perform(post("/math/volume/3/4/5")).andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void testVolumeTwo() throws Exception {
        this.mvc.perform(patch("/math/volume/6/7/8")).andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }
}

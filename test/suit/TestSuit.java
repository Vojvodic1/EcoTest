/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suit;


import indexSlider.TestIndexSliderPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import photoGallery.TestPhotoGalleryPage;



/**
 *
 * @author IKA
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestPhotoGalleryPage.class, TestIndexSliderPage.class})
public class TestSuit {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

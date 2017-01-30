package word.machine;

import word.machine.WordMachine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yeison Melo <melo.yeison@gmail.com>
 */
public class WorldMachineTest {
    
    private static final int ERROR = -1;
    
    public WorldMachineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class WordMachine.
     */
    @Test
    public void test1() {
        System.out.println("main");
        String args ="13 DUP 4 POP 5 DUP + DUP + -";
        int r = WordMachine.solution(args);
        assertNotEquals(ERROR, r);
        assertEquals(7, r);
    }
    
    @Test
    public void test2() {
        System.out.println("main");
        String args ="5 6 + -";
        int r = WordMachine.solution(args);
        assertEquals(ERROR, r);
    }
    
    @Test
    public void test3() {
        System.out.println("main");
        String args ="3 DUP 5 - -";
        int r = WordMachine.solution(args);
        assertEquals(ERROR, r);
    }
    
     @Test
    public void test4() {
        System.out.println("main");
        String args ="-";
        int r = WordMachine.solution(args);
        assertEquals(ERROR, r);
    }
    
    @Test
    public void test5() {
        System.out.println("main");
        String args ="+";
        int r = WordMachine.solution(args);
        assertEquals(ERROR, r);
    }
    
    @Test
    public void test6() {
        System.out.println("main");
        String args ="5";
        int r = WordMachine.solution(args);
        assertNotEquals(ERROR, r);
        assertEquals(5,r);
    }
    
     @Test
    public void test7() {
        System.out.println("main");
        String args ="212 + 1048576";
        int r = WordMachine.solution(args);
        assertEquals(ERROR,r);
    }
    
      @Test
      /*
      * Input elements from 0 to 2^20 -1 
      * 2^20-1 = 1048575
      * we can think the 2147483647 is obtained
      * from a previous ADD operation
      */
    public void testOverFlow() {
        System.out.println("testOverFlow");
        String args ="2147483647 1048576 +";
        int r = WordMachine.solution(args);
        assertEquals(ERROR, r);
    }
    
    @Test
    public void testTryUnderFlow() {
        System.out.println("testUnderFlow");
        String args ="2147483646 1 + 0 -";
        int r = WordMachine.solution(args);
        assertEquals(ERROR, r);
    }

}

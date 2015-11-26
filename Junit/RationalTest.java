import junit.framework.TestCase;

public class RationalTest extends TestCase {
    
    protected Rational HALF;
    
    protected void setUp() {
        HALF = new Rational( 1, 2 );
    }
    
    // Create new test
    public RationalTest (String name) {
        super(name);
    }
    
    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }
    
    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
                                             new Rational(1,3)));
    }
    
    public void testAccessors() {
        assertEquals(new Rational(2,3).numerator(), 2);
        assertEquals(new Rational(2,3).denominator(), 3);
    }
    
    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) )
                   && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }
    
    public void testIllegalRoot() {
        Rational s = new Rational( -1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) )
                   && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }
    
    public void testPlus() {
        Rational x=new Rational(1,0);
        Rational y=new Rational(2,0);
        assertTrue(x.plus(y).equals(new Rational(1,0)));
    }
    
    public void testPlusLarge() {
        Rational x=new Rational(2000000000,1);
        Rational y=new Rational(1999999999,1);
        assertTrue(x.plus(y).isLessThan(new Rational(1,1))==false);
    }
    
    public void testMinus(){
        Rational x=new Rational(2000000000,1);
        Rational y=new Rational(2000000000*2,2);
        assertEquals(new Rational(0,1), x.minus(y));
    }
    
    public void testMinusLarge(){
        Rational x=new Rational(2000000000,1);
        Rational y=new Rational(-2000000000,1);
        assertTrue(x.minus(y).isLessThan(new Rational(0,1))==false);
    }
    
    public void testTimes(){
        Rational x=new Rational(2000000000,1);
        Rational y=new Rational(2,1);
        assertEquals(x,x.times(y).times(HALF));
    }
    
    public void testOtherTimes(){
        Rational x=new Rational(2000000000,1);
        Rational y=new Rational(2,1);
        Rational z=new Rational(1,2);
        assertEquals(x.times(z).times(y),x.times(y).times(z));
    }
    
    public void testDivides(){
        Rational x=new Rational(1999999,1);
        Rational y=new Rational(1999999*2,1);
        Rational z=new Rational(2,1);
        assertEquals(x,y.divides(z));
    }
    
    public void testOtherDivides(){
        Rational x=new Rational(1999999,1);
        Rational z=new Rational(3,1);
        assertEquals(x,x.plus(x).plus(x).divides(z));
    }
    
    public void testABS(){
        Rational x=new Rational(-2,1);
        Rational y=new Rational(2,1);
        assertEquals(x.abs(),y.abs());
    }
    
    public static void main(String args[]) {
        String[] testCaseName =
        { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}
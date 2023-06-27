package lesson2;

public class Main {

    private static byte b;
    private static short s;
    private static char c;
    private static int i;
    private static long l;
    private static String str;
    private static float f;
    private static double d;
    private static boolean bool;
    private static Byte bObj;
    private static Short sObj;
    private static Integer iObj;
    private static Long lObj;
    private static Float fObj;
    private static Double dObj;
    private static Boolean boolObj;

    public static byte getB() {
        return b;
    }

    public static void setB(byte b) {
        Main.b = b;
    }

    public static short getS() {
        return s;
    }

    public static void setS(short s) {
        Main.s = s;
    }

    public static char getC() {
        return c;
    }

    public static void setC(char c) {
        Main.c = c;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Main.i = i;
    }

    public static long getL() {
        return l;
    }

    public static void setL(long l) {
        Main.l = l;
    }

    public static String getStr() {
        return str;
    }

    public static void setStr(String str) {
        Main.str = str;
    }

    public static float getF() {
        return f;
    }

    public static void setF(float f) {
        Main.f = f;
    }

    public static double getD() {
        return d;
    }

    public static void setD(double d) {
        Main.d = d;
    }

    public static boolean getBool() {
        return bool;
    }

    public static void setBool(boolean bool) {
        Main.bool = bool;
    }

    public static Byte getbObj() {
        return bObj;
    }

    public static void setbObj(Byte bObj) {
        Main.bObj = bObj;
    }

    public static Short getsObj() {
        return sObj;
    }

    public static void setsObj(Short sObj) {
        Main.sObj = sObj;
    }

    public static Integer getiObj() {
        return iObj;
    }

    public static void setiObj(Integer iObj) {
        Main.iObj = iObj;
    }

    public static Long getlObj() {
        return lObj;
    }

    public static void setlObj(Long lObj) {
        Main.lObj = lObj;
    }

    public static Float getfObj() {
        return fObj;
    }

    public static void setfObj(Float fObj) {
        Main.fObj = fObj;
    }

    public static Double getdObj() {
        return dObj;
    }

    public static void setdObj(Double dObj) {
        Main.dObj = dObj;
    }

    public static Boolean getBoolObj() {
        return boolObj;
    }

    public static void setBoolObj(Boolean boolObj) {
        Main.boolObj = boolObj;
    }

    public static void initStaticVars() {
        setB((byte) 1);
        setS((short) 2);
        setC((char) 'c');
        setI(10);
        setL(9000);
        setStr("Str");
        setF(-12.34f);
        setD(56.78);
        setBool(true);
        setbObj(Byte.MAX_VALUE);
        setsObj(Short.MIN_VALUE);
        setiObj(Integer.SIZE);
        setlObj(Long.MAX_VALUE);
        setfObj(Float.MIN_NORMAL);
        setdObj(Double.NEGATIVE_INFINITY);
        setBoolObj(Boolean.FALSE);
    }

    public static void printStaticVars() {
        System.out.println(" b = " + getB() +
                        ",  s = " + getS() +
                        ",  c = " + getC() +
                        ",  i = " + getI() +
                        ",  l = " + getL() +
                        ",  str = " + getStr() +
                        ",  f = " + getF() +
                        ",  d = " + getD() +
                        ",  bool = " + getBool() +
                        ",  bObj = " + getbObj() +
                        ",  sObj = " + getsObj() +
                        ",  iObj = " + getiObj() +
                        ",  lObj = " + getlObj() +
                        ",  fObj = " + getfObj() +
                        ",  dObj = " + getdObj() +
                        ",  boolObj = " + getBoolObj()
        );
    }

    public static void changeStaticVars() {
        b++;
        s++;
        c++;
        i++;
        l++;
        f++;
        d++;
        str = str.concat("ing");
        bool = false;
        bObj--;
        sObj++;
        iObj++;
        lObj++;
        fObj++;
        dObj++;
        boolObj = true;
    }

    public static Person createPerson() {
        Person prsn = new Person();
        prsn.setName("Barbie");
        prsn.setAge((byte) 22);
        prsn.setWeight((char) 50);
        prsn.setCountHairOnHead((short) 32000);
        prsn.setCountFollowers(2_000_000_000);
        prsn.setJustLongNum(2_000_000_000);
        prsn.setMoneyOnBankAccount(12345.25f);
        prsn.setNeedMoney(1_000_000_000_000.0);
        return prsn;
    }

    public static void changePrimitiveVars(int a, int b) {
        a++;
        b++;
        System.out.println("a внутри метода " + a);
        System.out.println("b внутри метода " + b);
    }

    public static void changeObjectVars(Integer a, Integer b) {
        a++;
        b++;
        System.out.println("a внутри метода " + a);
        System.out.println("b внутри метода " + b);
    }

    static int tryLongToInt(long l, long ln) {
        return Math.toIntExact(l + ln);
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        Integer xx = 10;
        Integer yy = 20;
        long lng1 = Long.MAX_VALUE;
        long lng2 = Long.MIN_VALUE;

        System.out.println("Пробуем запихнуть long в integer: " + tryLongToInt(lng1, lng2));

        System.out.println();

        Person barbie = createPerson();
        System.out.println(
                "Hi, my name's " + barbie.getName() +
                ", I'm "+ barbie.getAge() +
                ", and I have " + barbie.getCountFollowers() +
                " followers in Instagram");

        initStaticVars();
        printStaticVars();
        changeStaticVars();
        printStaticVars();

        System.out.println("iObj.byteValue()  : " + iObj.byteValue());
        System.out.println("lObj.compareTo(l) : " + lObj.compareTo(l));
        System.out.println("fObj.toString()   : " + fObj.toString());
        System.out.println("dObj.intValue()   : " + dObj.intValue());
        System.out.println("boolObj.equals(bool) : " + boolObj.equals(bool));

        changePrimitiveVars(x, y);
        System.out.println("x после метода " + x);
        System.out.println("y после метода " + y);

        changeObjectVars(xx, yy);
        System.out.println("xx после метода " + xx);
        System.out.println("yy после метода " + yy);
    }
}

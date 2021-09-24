public class Cometa {
    public static void main(String args[])  { 
        int nextComet, year = MyIO.readInt();
        if(year == 0){
            System.exit(0);
        }
        if(year < 2062){
            nextComet = year + (76 - (year - 1986));
            System.out.println(nextComet);
        }else if(year < 2138){
            nextComet = year + (76 - (year - 2062));
            System.out.println(nextComet);
        }else if(year < 2214){
            nextComet = year + (76 - (year - 2138));
            System.out.println(nextComet);
        }else if(year < 2290){
            nextComet = year + (76 - (year - 2214));
            System.out.println(nextComet);
        }else if(year < 2366){
            nextComet = year + (76 - (year - 2290));
            System.out.println(nextComet);
        }else if(year < 2442){
            nextComet = year + (76 - (year - 2366));
            System.out.println(nextComet);
        }else if(year < 2518){
            nextComet = year + (76 - (year - 2442));
            System.out.println(nextComet);
        }else if(year < 2594){
            nextComet = year + (76 - (year - 2518));
            System.out.println(nextComet);
        }else if(year < 2670){
            nextComet = year + (76 - (year - 2594));
            System.out.println(nextComet);
        }else if(year < 2746){
            nextComet = year + (76 - (year - 2670));
            System.out.println(nextComet);
        }else if(year < 2822){
            nextComet = year + (76 - (year - 2746));
            System.out.println(nextComet);
        }else if(year < 2898){
            nextComet = year + (76 - (year - 2822));
            System.out.println(nextComet);
        }else if(year < 2974){
            nextComet = year + (76 - (year - 2898));
            System.out.println(nextComet);
        }else{
            System.out.println(0);
        }
   }   
}

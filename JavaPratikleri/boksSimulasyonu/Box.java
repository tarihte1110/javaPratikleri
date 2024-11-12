public class Box {
    public static void main(String[] args){
        int s1= (int) (12+Math.random()*3);
        int s2= (int) (17+Math.random()*3);
     Fighter ali=new Fighter("Muhammed Ali",s1,93,90,65);
     Fighter mike=new Fighter("Mike Tyson",s2,95,96,32);
     Ring match=new Ring(ali,mike,80,120);
     match.run();
    }
}

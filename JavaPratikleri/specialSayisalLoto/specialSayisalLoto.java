import java.util.*;
public class specialSayisalLoto {
    public static void main(String [] args){
        Scanner input=new Scanner(System.in);

        System.out.println("""
                   +  KURALLAR  +
                * Bir sayı birden fazla kez çıkabilir dolayısıyla bir sayıya birden fazla kez oynanabilir.
                * Oynanan sayılar 1_50 arasında 5 tam sayı olmalıdır.Aksi takdirde program çalışmayacaktır.""");

            System.out.println("\nOynamak istediğniz sayıları ( 1_50 arasında) giriniz:");

            int[] sayiTahmin = new int[5];
            for (int i = 0; i < sayiTahmin.length; i++) {
                sayiTahmin[i] = input.nextInt();

                if(sayiTahmin[i]<1 || sayiTahmin[i]>50){
                    System.out.println("50'den büyük sayı girilemez!");
                      System.exit(1110);
                }
            }

        System.out.print("Yatırmak istedğiniz tutarı TL cinsinden giriniz:");
        int para= input.nextInt();

        int[] dizi=new int[5];
        Random rand=new Random();

        for(int i=0;i<dizi.length;i++)
        {
            dizi[i]=rand.nextInt(51);
        }

        int count=0;

        for (int k : dizi) {
            for (int j = 0; j < dizi.length; j++) {
                if (k == sayiTahmin[j]) {
                    count++;
                }
            }
        }

        System.out.println("TALİHLİ SAYILAR:"+java.util.Arrays.toString(dizi));

        if(count>0){
            System.out.println("SONUÇ => "+"TEBRİKLER! "+count+" sayı doğru tahmin ettiniz.");
            if(count==1){
                System.out.println(para*1.5+" TL kazandınız!");
            }
            else if(count==2){
                System.out.println((para*2)+50+" TL kazandınız!");
            }
            else if(count==3){
                System.out.println(para*4+" TL kazandınız!");
            }
            else if(count==4){
                System.out.println(para*8+" TL kazandınız!");
            }
            else if(count==5){
                System.out.println(para*18+" TL kazandınız!");
            }
        }
        else{
            System.out.println("SONUÇ => "+"Maalesef sayı tahmin edemediniz.");
        }
    }
}


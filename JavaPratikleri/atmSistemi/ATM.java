import java.util.Scanner;

class UserAccount {
    private String cardNo;
    private String password;
    private int balance;

    public UserAccount(String cardNo, String password, int balance) {
        this.cardNo = cardNo;
        this.password = password;
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}

public class ATM {

    private static final int MAX_ATTEMPTS = 3;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserAccount user = new UserAccount("545656121898232", "tarihte1110.", 1250);

        System.out.println("    ***|=  FIRAT BANKASI  =|***    \n" + "  \nHOŞGELDİNİZ! "
                + "\n+ Hesabınızı görüntülemek için lütfen bilgilerinizi giriniz.\n");

        if (!authenticate(user)) {
            System.out.println("Hesabınız bloke olmuştur. Lütfen banka ile iletişime geçiniz.");
            return;
        }

        System.out.println("\nMerhaba YUSUF UYGUR ");

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            handleMenuChoice(choice, user);
        } while (choice != 5);

        System.out.println("\n* Hesaptan başarıyla çıkış yapıldı. *");
    }

    private static boolean authenticate(UserAccount user) {
        int attempts = 0;
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Kart numaranız: ");
            String cardNo = scanner.next();
            System.out.print("Şifreniz: ");
            String password = scanner.next();

            if (user.getCardNo().equals(cardNo) && user.checkPassword(password)) {
                System.out.print("* Sisteme giriş yapıldı. *\n");
                return true;
            } else {
                attempts++;
                System.out.println("Kart numarası ya da şifre hatalı! Kalan hakkınız: " + (MAX_ATTEMPTS - attempts));
            }
        }
        return false;
    }

    private static void showMenu() {
        System.out.println("\nLütfen gerçekleştirmek istediğiniz işlemi seçiniz:");
        System.out.println("1- Para Yatırma");
        System.out.println("2- Para Çekme");
        System.out.println("3- Bakiye Sorgulama");
        System.out.println("4- Şifre Değiştirme");
        System.out.println("5- Çıkış");
    }

    private static void handleMenuChoice(int choice, UserAccount user) {
        switch (choice) {
            case 1:
                depositMoney(user);
                break;
            case 2:
                withdrawMoney(user);
                break;
            case 3:
                checkBalance(user);
                break;
            case 4:
                changePassword(user);
                break;
            case 5:
                System.out.println("Çıkış yapılıyor...");
                break;
            default:
                System.out.println("Hatalı giriş yaptınız!");
        }
    }

    private static void depositMoney(UserAccount user) {
        System.out.print("Yatırmak istediğiniz miktarı giriniz: ");
        int amount = scanner.nextInt();
        user.deposit(amount);
        System.out.println("Para başarıyla yatırıldı. Güncel bakiyeniz: " + user.getBalance());
    }

    private static void withdrawMoney(UserAccount user) {
        System.out.print("Çekmek istediğiniz tutarı giriniz: ");
        int amount = scanner.nextInt();
        if (user.withdraw(amount)) {
            System.out.println("Para başarıyla çekildi. Güncel bakiyeniz: " + user.getBalance());
        } else {
            System.out.println("Bakiye yetersiz.");
        }
    }

    private static void checkBalance(UserAccount user) {
        System.out.println("Bakiyeniz: " + user.getBalance());
    }

    private static void changePassword(UserAccount user) {
        System.out.print("Yeni şifrenizi giriniz: ");
        String newPassword = scanner.next();
        user.changePassword(newPassword);
        System.out.println("Şifreniz başarıyla değiştirildi.");
    }
}

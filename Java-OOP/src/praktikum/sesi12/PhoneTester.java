package praktikum.sesi12;

interface Phone {
    int MAX_VOLUME = 100;
    int MIN_VOLUME = 0;

    void powerOn();
    void powerOff();
    void volumeUp();
    void volumeDown();
}

class Xiaomi implements Phone {
    private int volume;
    private boolean isPowerOn;

    public Xiaomi() {
        this.volume = 50;
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Xiaomi menyala.");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Xiaomi mati.");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            if (volume < MAX_VOLUME) {
                volume += 10;
            }
            System.out.println("Volume Xiaomi: " + volume);
        } else {
            System.out.println("Nyalakan dulu Xiaomi.");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            if (volume > MIN_VOLUME) {
                volume -= 10;
            }
            System.out.println("Volume Xiaomi: " + volume);
        } else {
            System.out.println("Nyalakan dulu Xiaomi.");
        }
    }

    public int getVolume() {
        return volume;
    }
}

class iPhone implements Phone {
    private int volume;
    private boolean isPowerOn;

    public iPhone() {
        this.volume = 50;
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("iPhone menyala.");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("iPhone mati.");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            if (volume < MAX_VOLUME) {
                volume += 10;
            }
            System.out.println("Volume iPhone: " + volume);
        } else {
            System.out.println("Nyalakan dulu iPhone.");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            if (volume > MIN_VOLUME) {
                volume -= 10;
            }
            System.out.println("Volume iPhone: " + volume);
        } else {
            System.out.println("Nyalakan dulu iPhone.");
        }
    }

    public int getVolume() {
        return volume;
    }
}

class Samsung implements Phone {
    private int volume;
    private boolean isPowerOn;

    public Samsung() {
        this.volume = 50;
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Samsung menyala.");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Samsung mati.");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            if (volume < MAX_VOLUME) {
                volume += 10;
            }
            System.out.println("Volume Samsung: " + volume);
        } else {
            System.out.println("Nyalakan dulu Samsung.");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            if (volume > MIN_VOLUME) {
                volume -= 10;
            }
            System.out.println("Volume Samsung: " + volume);
        } else {
            System.out.println("Nyalakan dulu Samsung.");
        }
    }

    public int getVolume() {
        return volume;
    }
}

class Oppo implements Phone {
    private int volume;
    private boolean isPowerOn;

    public Oppo() {
        this.volume = 50;
        this.isPowerOn = false;
    }

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Oppo menyala.");
    }

    @Override
    public void powerOff() {
        isPowerOn = false;
        System.out.println("Oppo mati.");
    }

    @Override
    public void volumeUp() {
        if (isPowerOn) {
            if (volume < MAX_VOLUME) {
                volume += 10;
            }
            System.out.println("Volume Oppo: " + volume);
        } else {
            System.out.println("Nyalakan dulu Oppo.");
        }
    }

    @Override
    public void volumeDown() {
        if (isPowerOn) {
            if (volume > MIN_VOLUME) {
                volume -= 10;
            }
            System.out.println("Volume Oppo: " + volume);
        } else {
            System.out.println("Nyalakan dulu Oppo.");
        }
    }

    public int getVolume() {
        return volume;
    }
}

class PhoneUser {
    private final Phone phone;

    public PhoneUser(Phone phone) {
        this.phone = phone;
    }

    public void turnOnThePhone() {
        phone.powerOn();
    }

    public void turnOffThePhone() {
        phone.powerOff();
    }

    public void makePhoneLouder() {
        phone.volumeUp();
    }

    public void makePhoneSilent() {
        phone.volumeDown();
    }
}

public class PhoneTester {
    public static void main(String[] args) {
        Phone xiaomi = new Xiaomi();
        Phone iphone = new iPhone();
        Phone samsung = new Samsung();
        Phone oppo = new Oppo();

        PhoneUser user1 = new PhoneUser(xiaomi);
        PhoneUser user2 = new PhoneUser(iphone);
        PhoneUser user3 = new PhoneUser(samsung);
        PhoneUser user4 = new PhoneUser(oppo);

        System.out.println("=== Xiaomi ===");
        user1.turnOnThePhone();
        user1.makePhoneLouder();
        user1.makePhoneSilent();
        user1.turnOffThePhone();

        System.out.println("\n=== iPhone ===");
        user2.turnOnThePhone();
        user2.makePhoneLouder();
        user2.makePhoneSilent();
        user2.turnOffThePhone();

        System.out.println("\n=== Samsung ===");
        user3.turnOnThePhone();
        user3.makePhoneLouder();
        user3.makePhoneSilent();
        user3.turnOffThePhone();

        System.out.println("\n=== Oppo ===");
        user4.turnOnThePhone();
        user4.makePhoneLouder();
        user4.makePhoneSilent();
        user4.turnOffThePhone();
    }
}
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        Items.printStrings("ru", "RU");
    }
}

class Items {
    public static void printStrings(String lang, String country) {

        Locale locale = new Locale(lang, country);
        ResourceBundle bundle = ResourceBundle.getBundle("BundlePackage.ItemBundles", locale);

        System.out.println("name = " + bundle.getString("name"));
        System.out.println("size = " + bundle.getString("size"));
        System.out.println("color = " + bundle.getString("color"));
        System.out.println("price = " + format(locale, bundle));
    }

    private static String format(Locale locale, ResourceBundle bundle) {

        final double PRICE = Integer.parseInt(bundle.getString("price"));
        final double EUR_RATE = 0.9;
        final double RUB_RATE = 62.1;
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);

        if (locale.getCountry().equals("DE"))
            return format.format(PRICE * EUR_RATE);
        else if (locale.getCountry().equals("RU"))
            return format.format(PRICE * RUB_RATE);
        else
            return format.format(PRICE);
    }
}
